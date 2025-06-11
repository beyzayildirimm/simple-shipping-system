public class Main {
    public static void main(String[] args) {
        ShippingSystem system = new ShippingSystem();

        // 1. StandardPackage oluştur
        StandardPackage package1 = new StandardPackage("Alice", "Bob", 5, "Istanbul", "Turkey");
        StandardPackage package2 = new StandardPackage("Charlie", "David", 3, "Ankara", "Turkey");

        // 2. Paketin güncel konumunu güncelle ve takip bilgilerini al
        package1.updateLocation("Sorting Facility");
        System.out.println(package1.getTrackingInfo());

        // 3. Paketi teslim et
        package1.markDelivered();

        // 4. Paketleri sisteme ekle
        system.addPackage(package1);
        system.addPackage(package2);

        // 5. Tüm paket bilgilerini yazdır
        system.printAllPackages();

        // 6. Raporu oluştur
        system.generateReport();
    }
}
