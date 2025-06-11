interface Trackable {
    String getTrackingInfo();
    void updateLocation(String newLocation);
    void setEstimatedDeliveryTime(String dateTime);
    String getEstimatedDeliveryTime();
}