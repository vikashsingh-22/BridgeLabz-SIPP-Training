package ScenarioBased.IceCream;

public class FlavorSales {
    private String flavor;
    private int sales;

    public FlavorSales(String flavor, int sales) {
        this.flavor = flavor;
        this.sales = sales;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "FlavorSales{flavor='" + flavor + "', sales=" + sales + "}";
    }
    
}
