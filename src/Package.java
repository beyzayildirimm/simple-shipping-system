import java.util.ArrayList;
public abstract class Package {
    private String senderName;
    private String recipientName;
    private double weight;
    private boolean isDelivered = false;
    private String destinationCity;
    private String destinationCountry;

    public Package() {
        this.senderName = "";
        this.recipientName = "";
        this.weight = 0;
        this.destinationCity = "";
        this.destinationCountry = "";
    }

    public Package(String senderName, String recipientName, double weight, String destinationCity, String destinationCountry) {
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.weight = weight;
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
    }

    public double getWeight() {
        return weight;
    }
    public String getSenderName() {
        return senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }
    public abstract double calculateShippingCost();
    public void markDelivered() {
        isDelivered = true;
        System.out.println("Package delivered.");
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void printInfo() {
        System.out.println("Sender: " + senderName + ", Recipient: " + recipientName + ", Weight: " + weight + "kg, Delivered: " + isDelivered + ", Destination: " + destinationCity + ", " + destinationCountry);
    }
}
interface Refundable {
    boolean requestRefund(String reason);
    double getRefundAmount();
    default void logRefundRequest(String packageIdentifier) {
        System.out.println("Refund request logged for package " + packageIdentifier);
    }
}
interface Trackable {
    String getTrackingInfo();
    void updateLocation(String newLocation);
    void setEstimatedDeliveryTime(String dateTime);
    String getEstimatedDeliveryTime();
}
interface Insurable {
    void insurePackage(double insuredValue);
    double getInsuredValue();
    boolean claimInsurance(String claimReason);
    default void logInsuranceClaim(String packageIdentifier, String reason) {
        System.out.println("Insurance claim logged for package: " + packageIdentifier + ", Reason: " + reason);
    }
}
class StandardPackage extends Package implements Trackable {
    private String shippingType = "Ground";
    private String currentLocation;
    private String estimatedDeliveryTime;

    public StandardPackage(String senderName, String recipientName, double weight, String destinationCity, String destinationCountry) {
        super(senderName, recipientName, weight, destinationCity, destinationCountry);
    }
    public double calculateShippingCost() {
        return getWeight() * 2.0;
    }
    public String getTrackingInfo() {
        return currentLocation;
    }
    public void setEstimatedDeliveryTime(String dateTime) {
        this.estimatedDeliveryTime = dateTime;
    }
    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Shipping Type: " + shippingType + ", Current Location: " + currentLocation);
    }
}
class ExpressPackage extends Package implements Trackable, Insurable {
    private int priorityLevel;
    private String currentLocation;
    private String estimatedDeliveryTime;
    private double insuredValue;

    public ExpressPackage(String senderName, String recipientName, double weight, String destinationCity, String destinationCountry, int priorityLevel) {
        super(senderName, recipientName, weight, destinationCity, destinationCountry);
        this.priorityLevel = priorityLevel;
    }
    public double calculateShippingCost() {return (getWeight() * 5.0) + 10.0;}
    public String getTrackingInfo() {return currentLocation;}

    public void setEstimatedDeliveryTime(String dateTime) {
        this.estimatedDeliveryTime = dateTime;
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public void insurePackage(double insuredValue) {
        this.insuredValue = insuredValue;
    }

    public double getInsuredValue() {
        return insuredValue;
    }

    public boolean claimInsurance(String claimReason) {
        if (claimReason.equalsIgnoreCase("lost") || claimReason.equalsIgnoreCase("damaged")) {
            System.out.println("Insurance claim approved for reason: " + claimReason);
            return true;
        } else {
            System.out.println("Insurance claim denied. Reason: " + claimReason);
            return false;
        }
    }
}
class FragilePackage extends Package implements Trackable, Insurable, Refundable {
    private boolean requiresReinforcedBox;
    private boolean requiresTemperatureControl;
    private String currentLocation;
    private String estimatedDeliveryTime;
    private double insuredValue;
    private double refundAmount;

    public FragilePackage(String senderName, String recipientName, double weight, String destinationCity, String destinationCountry) {
        super(senderName, recipientName, weight, destinationCity, destinationCountry);
    }

    public double calculateShippingCost() {
        return (getWeight() * 2.0) + 8.0;
    }

    public String getTrackingInfo() {
        return currentLocation;
    }

    public void setEstimatedDeliveryTime(String dateTime) {
        this.estimatedDeliveryTime = dateTime;
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public void insurePackage(double insuredValue) {
        this.insuredValue = insuredValue;
    }
    public double getInsuredValue() {
        return insuredValue;
    }
    public boolean requestRefund(String reason) {
        if (reason.equalsIgnoreCase("damaged")) {
            this.refundAmount = insuredValue * 0.4;
            System.out.println("Refund approved: " + refundAmount);
            return true;
        } else {
            System.out.println("Refund denied. Reason: " + reason);
            return false;
        }
    }
    public double getRefundAmount() {
        return refundAmount;
    }
    @Override
    public void markDelivered() {
        super.markDelivered();
        System.out.println("Handle with care – Fragile item delivered!");
    }
    public boolean claimInsurance(String claimReason) {
        if (claimReason.equalsIgnoreCase("lost") || claimReason.equalsIgnoreCase("damaged")) {
            System.out.println("Insurance claim approved for reason: " + claimReason);
            return true;
        } else {
            System.out.println("Insurance claim denied. Reason: " + claimReason);
            return false;
        }
    }
}
class ShippingSystem {
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