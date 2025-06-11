public class ExpressPackage extends Package implements Trackable, Insurable {
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