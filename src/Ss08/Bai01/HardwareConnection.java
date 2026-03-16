package Ss08.Bai01;

class HardwareConnection {
    private static HardwareConnection instance;

    // Constructor private
    private HardwareConnection() {}

    // Lấy instance duy nhất
    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("HardwareConnection: Đã kết nối phần cứng.");
    }

    public void disconnect() {
        System.out.println("HardwareConnection: Ngắt kết nối.");
    }
}
