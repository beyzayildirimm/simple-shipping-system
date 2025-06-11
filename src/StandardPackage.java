public class StandardPackage extends Package implements Trackable {
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