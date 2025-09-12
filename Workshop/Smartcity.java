
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Smartcity{

    /* -------------------- Models -------------------- */
    static class Location {
        final String name;
        final double lat, lon;

        Location(String name, double lat, double lon) {
            this.name = name;
            this.lat = lat;
            this.lon = lon;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Route {
        final String id;
        final Location from;
        final Location to;
        final double distanceKm;

        Route(String id, Location from, Location to) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.distanceKm = GeoUtils.calculateDistance(from, to);
        }

        @Override
        public String toString() {
            return id + " (" + from + " -> " + to + ", " + String.format("%.2fkm", distanceKm) + ")";
        }
    }

    static class Passenger {
        final String id;
        final String name;

        Passenger(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() { return name + "(" + id + ")"; }
    }

    static class Trip {
        final String id;
        final Passenger passenger;
        final Route route;
        final LocalDateTime startTime;
        final double fare;
        final TransportService provider;
        final boolean peak;

        Trip(String id, Passenger passenger, Route route, LocalDateTime startTime,
             double fare, TransportService provider, boolean peak) {
            this.id = id;
            this.passenger = passenger;
            this.route = route;
            this.startTime = startTime;
            this.fare = fare;
            this.provider = provider;
            this.peak = peak;
        }

        @Override
        public String toString() {
            return "Trip{" + id + ", " + passenger + ", " + route + ", at=" + startTime.toLocalTime() + ", fare=" + fare + ", svc=" + provider.getServiceName() + "}";
        }
    }

    /* -------------------- Interfaces & Functional Types -------------------- */
    interface GeoUtils {
        // static utility method in an interface (Java 8)
        static double calculateDistance(Location a, Location b) {
            // very simple Euclidean-like approximation for demo (not Haversine)
            double dx = a.lat - b.lat;
            double dy = a.lon - b.lon;
            return Math.sqrt(dx*dx + dy*dy) * 111; // rough conversion degrees->km
        }
    }

    interface TransportService {
        String getServiceName();
        List<Route> getRoutes();
        List<LocalTime> getScheduleForRoute(String routeId);

        // default method shared by all transport services
        default void printServiceDetails() {
            System.out.println("-- Service: " + getServiceName() + " --");
            getRoutes().forEach(r -> System.out.println("  " + r));
        }

        // static utility helper for fare calculation or similar could also be here
        static void log(String msg) {
            System.out.println("[TransportService] " + msg);
        }
    }

    // Functional Interface for fare calculation
    @FunctionalInterface
    interface FareCalculator {
        double calculateFare(Route route, boolean peak, Map<String,Object> opts);
    }

    // Marker interface for emergency-capable services
    interface EmergencyService {}

    /* -------------------- Concrete Services -------------------- */
    static abstract class AbstractTransportService implements TransportService {
        protected final String name;
        protected final List<Route> routes;
        protected final Map<String, List<LocalTime>> schedule = new HashMap<>();

        AbstractTransportService(String name, List<Route> routes) {
            this.name = name;
            this.routes = routes;
            // default simple schedule: departures every hour 6-22
            for (Route r : routes) {
                List<LocalTime> times = new ArrayList<>();
                for (int h=6; h<=22; h++) times.add(LocalTime.of(h, 0));
                schedule.put(r.id, times);
            }
        }

        @Override public String getServiceName() { return name; }
        @Override public List<Route> getRoutes() { return Collections.unmodifiableList(routes); }
        @Override public List<LocalTime> getScheduleForRoute(String routeId) { return schedule.getOrDefault(routeId, Collections.emptyList()); }
    }

    static class BusService extends AbstractTransportService {
        final FareCalculator fareCalc;
        BusService(String name, List<Route> routes, FareCalculator fareCalc) {
            super(name, routes);
            this.fareCalc = fareCalc;
        }

        double fareFor(Route route, boolean peak) { return fareCalc.calculateFare(route, peak, Collections.singletonMap("type","bus")); }
    }

    static class MetroService extends AbstractTransportService {
        final FareCalculator fareCalc;
        MetroService(String name, List<Route> routes, FareCalculator fareCalc) {
            super(name, routes);
            this.fareCalc = fareCalc;
        }

        double fareFor(Route route, boolean peak) { return fareCalc.calculateFare(route, peak, Collections.singletonMap("type","metro")); }
    }

    static class TaxiService extends AbstractTransportService implements EmergencyService {
        final FareCalculator fareCalc;
        TaxiService(String name, List<Route> routes, FareCalculator fareCalc) {
            super(name, routes);
            this.fareCalc = fareCalc;
            // taxis run 24/7 in this demo
            for (Route r : routes) {
                List<LocalTime> times = new ArrayList<>();
                for (int h=0; h<24; h+=1) times.add(LocalTime.of(h, 0));
                schedule.put(r.id, times);
            }
        }

        double fareFor(Route route, boolean peak) { return fareCalc.calculateFare(route, peak, Collections.singletonMap("type","taxi")); }
    }

    // New service to demonstrate easy extension
    static class FerryService extends AbstractTransportService {
        final FareCalculator fareCalc;
        FerryService(String name, List<Route> routes, FareCalculator fareCalc) { super(name, routes); this.fareCalc = fareCalc; }
        double fareFor(Route route, boolean peak) { return fareCalc.calculateFare(route, peak, Collections.singletonMap("type","ferry")); }
    }

    /* -------------------- System Components -------------------- */
    static class Scheduler {
        final List<TransportService> services;
        Scheduler(List<TransportService> services) { this.services = services; }

        // Filter and sort services for a passenger booking
        List<TransportService> findServices(Route desiredRoute, LocalTime after, Comparator<TransportService> sorter) {
            return services.stream()
                    // filter services that have the route
                    .filter(s -> s.getRoutes().stream().anyMatch(r -> r.id.equals(desiredRoute.id)))
                    // further filter by schedule available after given time
                    .filter(s -> s.getScheduleForRoute(desiredRoute.id).stream().anyMatch(t -> !t.isBefore(after)))
                    .sorted(sorter)
                    .collect(Collectors.toList());
        }

        void displayLiveServices() {
            System.out.println("=== Live Services ===");
            services.forEach(TransportService::printServiceDetails); // method reference
        }
    }

    static class Dashboard {
        void showActiveServices(List<TransportService> services) {
            System.out.println("[Dashboard] Active services:");
            services.forEach(s -> System.out.println("  - " + s.getServiceName())); // lambda
        }
    }

    static class RevenueReport {
        final List<Trip> trips;
        RevenueReport(List<Trip> trips) { this.trips = trips; }

        void generate() {
            System.out.println("=== Revenue Report ===");

            // groupingBy route id -> list of trips
            Map<String, List<Trip>> byRoute = trips.stream().collect(Collectors.groupingBy(t -> t.route.id));
            byRoute.forEach((routeId, list) -> System.out.println("Route " + routeId + " -> " + list.size() + " trips"));

            // partitioningBy peak vs non-peak
            Map<Boolean, List<Trip>> partitioned = trips.stream().collect(Collectors.partitioningBy(t -> t.peak));
            System.out.println("Peak trips: " + partitioned.get(true).size() + ", Non-peak: " + partitioned.get(false).size());

            // summarizingDouble for fares
            DoubleSummaryStatistics stats = trips.stream().collect(Collectors.summarizingDouble(t -> t.fare));
            System.out.println("Total revenue: " + stats.getSum() + ", Avg fare: " + stats.getAverage());

            // top-used route
            String topRoute = byRoute.entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().size())).map(Map.Entry::getKey).orElse("-none-");
            System.out.println("Top-used route: " + topRoute);
        }
    }

    /* -------------------- Demo / Main Flow -------------------- */
    public static void main(String[] args) {
        // create some locations
        Location A = new Location("Central Station", 28.6139, 77.2090);
        Location B = new Location("East Park", 28.6210, 77.2300);
        Location C = new Location("Tech Hub", 28.5672, 77.2390);

        // routes
        Route r1 = new Route("R1", A, B);
        Route r2 = new Route("R2", B, C);
        Route r3 = new Route("R3", A, C);

        // fare calculator lambdas (functional interface)
        FareCalculator baseFare = (route, peak, opts) -> {
            double perKm = 5.0; // base per km
            String type = (String) opts.getOrDefault("type", "generic");
            if ("metro".equals(type)) perKm = 3.0;
            if ("ferry".equals(type)) perKm = 4.0;
            double fare = perKm * route.distanceKm;
            if (peak) fare *= 1.25;
            // simple rounding
            return Math.round(fare * 100.0) / 100.0;
        };

        // create services
        BusService buses = new BusService("CityBus", Arrays.asList(r1, r2), baseFare);
        MetroService metros = new MetroService("CityMetro", Arrays.asList(r3, r2), baseFare);
        TaxiService taxis = new TaxiService("CityTaxi", Arrays.asList(r1, r3), baseFare);
        FerryService ferry = new FerryService("RiverFerry", Arrays.asList(r2), baseFare);

        // system registry
        List<TransportService> registry = Arrays.asList(buses, metros, taxis, ferry);
        Scheduler scheduler = new Scheduler(registry);
        Dashboard dashboard = new Dashboard();

        // 1) Passenger books a trip -> filter & sort using lambdas
        Passenger p1 = new Passenger("P1", "Anita");
        LocalTime earliest = LocalTime.of(9, 0);

        // define comparator using fare estimate: cheapest first (uses lambda + method ref indirectly)
        Comparator<TransportService> cheapestFirst = Comparator.comparingDouble(s -> {
            // assume first route is desired one for the sake of computing fare estimate
            Route route = s.getRoutes().get(0);
            // we attempt to call fareFor if present via reflection-like cast; simpler: estimate using baseFare
            return baseFare.calculateFare(route, false, Collections.singletonMap("type","est"));
        });

        List<TransportService> options = scheduler.findServices(r2, earliest, cheapestFirst);

        // print available options using method reference for printing names
        System.out.println("Available services for route " + r2.id + " after " + earliest + ":");
        options.stream().map(TransportService::getServiceName).forEach(System.out::println); // method references

        // 2) Dashboard updates live -> forEach displays current active services
        dashboard.showActiveServices(registry);

        // 3) Simulate trips and revenue calculations
        List<Trip> trips = new ArrayList<>();
        trips.add(new Trip("T1", p1, r2, LocalDateTime.now().minusHours(2), metros.fareFor(r2, true), metros, true));
        trips.add(new Trip("T2", new Passenger("P2","Ravi"), r1, LocalDateTime.now().minusHours(1), buses.fareFor(r1, false), buses, false));
        trips.add(new Trip("T3", new Passenger("P3","Meera"), r3, LocalDateTime.now().minusMinutes(30), taxis.fareFor(r3, true), taxis, true));
        trips.add(new Trip("T4", new Passenger("P4","Sahil"), r2, LocalDateTime.now().minusMinutes(10), ferry.fareFor(r2, false), ferry, false));

        RevenueReport report = new RevenueReport(trips);
        report.generate();

        // 4) System expansion -> adding FerryService already shown above; one could add BikeRental by implementing TransportService
        System.out.println("\nAdding a new BikeRental service is straightforward: implement TransportService and optionally use default methods.");

        // 5) Emergency scenario -> priority detection via marker interface
        System.out.println("\nDetecting emergency-capable services:");
        registry.stream().filter(s -> s instanceof EmergencyService).forEach(s -> System.out.println("  Priority: " + s.getServiceName()));

        // Example: using collectors to group passengers by route (roles & capabilities)
        Map<String, List<Passenger>> passengersByRoute = trips.stream()
                .collect(Collectors.groupingBy(t -> t.route.id, Collectors.mapping(t -> t.passenger, Collectors.toList())));
        System.out.println("\nPassengers grouped by route:");
        passengersByRoute.forEach((routeId, list) -> System.out.println(routeId + " -> " + list));

        // Partition trips into peak/non-peak using partitioningBy
        Map<Boolean, Long> counts = trips.stream().collect(Collectors.partitioningBy(t -> t.peak, Collectors.counting()));
        System.out.println("Peak trips count=" + counts.get(true) + ", Non-peak=" + counts.get(false));

        // ForEach usage to display live schedule of all services for route R2
        System.out.println("\nLive schedules for route " + r2.id + ":");
        registry.forEach(s -> {
            List<LocalTime> times = s.getScheduleForRoute(r2.id);
            if (!times.isEmpty()) {
                System.out.print(s.getServiceName() + ": ");
                times.stream().limit(5).forEach(t -> System.out.print(t + " ")); // forEach on stream
                System.out.println();
            }
        });

        System.out.println("\nDemo complete.");
    }
}
