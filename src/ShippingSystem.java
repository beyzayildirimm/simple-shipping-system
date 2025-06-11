import java.util.ArrayList;

public class ShippingSystem {
    private ArrayList<Package> packages;

    public ShippingSystem() {
        packages = new ArrayList<>();
    }
    public void addPackage(Package pkg) {
        if (!packages.contains(pkg)) {
            packages.add(pkg);
            System.out.println("Package added: " + pkg.getSenderName() + " to " + pkg.getRecipientName());
        } else {
            System.out.println("Package already exists in the system.");
        }
    }
    public void removePackage(Package pkg) {
        if (packages.remove(pkg)) {
            System.out.println("Package removed: " + pkg.getSenderName() + " to " + pkg.getRecipientName());
        } else {
            System.out.println("Package not found in the system.");
        }
    }
    public void printAllPackages() {
        for (Package pkg : packages) {
            pkg.printInfo();
        }
    }
    public void generateReport() {
        int deliveredCount = 0;
        double totalShippingCost = 0.0;
        for (Package pkg : packages) {
            if (pkg.isDelivered()) {
                deliveredCount++;
            }
            totalShippingCost += pkg.calculateShippingCost();
        }
        int totalPackages = packages.size();
        double averageShippingCost = totalPackages > 0 ? totalShippingCost / totalPackages : 0.0;
        System.out.println("===== Shipping System Report =====");
        System.out.println("Total Packages: " + totalPackages);
        System.out.println("Delivered Packages: " + deliveredCount);
        System.out.println("Undelivered Packages: " + (totalPackages - deliveredCount));
        System.out.printf("Average Shipping Cost: %.2f TL\n", averageShippingCost);
        System.out.println("==================================");
    }
}