package Ss11.Bai01;

//    PHẦN 1 – PHÂN TÍCH
//
//    Rò rỉ kết nối (Connection Leak)
//    Mỗi lần gọi DriverManager.getConnection() sẽ tạo một connection mới. Nếu không đóng lại, các connection này vẫn tồn tại trong database. Sau một thời gian, số lượng connection đạt giới hạn tối đa, khiến hệ thống không thể tạo thêm kết nối mới và gây lỗi "Communications link failure".
//    Treo hệ thống
//    Khi database hết connection khả dụng, các request mới sẽ phải chờ. Nếu không có cơ chế timeout hợp lý, các thread sẽ bị treo, dẫn đến toàn bộ hệ thống ngừng phản hồi. Trong hệ thống bệnh viện, điều này rất nguy hiểm vì có thể làm gián đoạn việc truy xuất hồ sơ bệnh nhân.
//    Không kiểm soát trạng thái kết nối
//    Đoạn code hiện tại không kiểm tra database có đang hoạt động hay không, cũng không có cơ chế xử lý khi kết nối bị mất sau một thời gian dài hoạt động.
//    Hard-code thông tin cấu hình
//    Việc viết trực tiếp URL, username, password trong code gây khó khăn khi thay đổi cấu hình và tiềm ẩn rủi ro bảo mật.
//
//    Kết luận:
//    Không đóng connection và không quản lý tập trung sẽ dẫn đến rò rỉ tài nguyên, treo hệ thống và giảm độ ổn định, đặc biệt nguy hiểm với hệ thống cần hoạt động liên tục như bệnh viện.
//
//            PHẦN 2 – THỰC THI
//
//    Code viết lại lớp DBContext:


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a {

    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital_DB";
    private static final String USER = "admin";
    private static final String PASSWORD = "med123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void executeQueryExample() {
        Connection conn = null;

        try {
            conn = getConnection();

            // Thực hiện truy vấn ở đây
            System.out.println("Kết nối thành công");

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Đã đóng kết nối");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


