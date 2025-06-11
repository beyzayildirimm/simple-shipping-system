public interface Refundable {
    boolean requestRefund(String reason);
    double getRefundAmount();
    default void logRefundRequest(String packageIdentifier) {
        System.out.println("Refund request logged for package " + packageIdentifier);
    }
}
