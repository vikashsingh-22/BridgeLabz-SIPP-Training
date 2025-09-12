package Java_Methods.Level3;

public class Bonuscalculator {
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displayReport(employeeData, updatedData);
    }

    public static double[][] generateEmployeeData(int n) {
        double[][] data = new double[n][2];

        for (int i = 0; i < n; i++) {
            int salary = 10000 + (int)(Math.random() * 90000);
            int years = 1 + (int)(Math.random() * 10);
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] updated = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            int years = (int)data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;
            updated[i][0] = newSalary;
            updated[i][1] = bonus;
        }
        return updated;
    }

    public static void displayReport(double[][] original, double[][] updated) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-12s %-12s %-12s %-12s\n", "EmpID", "OldSalary", "YearsOfSvc", "Bonus", "NewSalary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < original.length; i++) {
            double oldSalary = original[i][0];
            int years = (int)original[i][1];
            double bonus = updated[i][1];
            double newSalary = updated[i][0];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%-10d %-12.2f %-12d %-12.2f %-12.2f\n", i + 1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-12.2f %-12s %-12.2f %-12.2f\n", "Total", totalOldSalary, "", totalBonus, totalNewSalary);
    }
}
