public class FragilePackage extends Package implements Trackable, Insurable, Refundable {
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