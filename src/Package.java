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






