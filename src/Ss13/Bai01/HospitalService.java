//PHẦN 1 – PHÂN TÍCH LOGIC
//
//        Trong JDBC, mặc định đối tượng Connection hoạt động với chế độ:
//
//        autoCommit = true
//
//        Điều này có nghĩa là:
//
//        Mỗi câu lệnh SQL được thực thi sẽ tự động commit ngay lập tức
//        Mỗi lần gọi executeUpdate() được xem là một transaction độc lập
//        Phân tích đoạn code đã cho
//        Bước 1:
//        ps1.executeUpdate();
//        Thực hiện trừ số lượng thuốc trong kho
//        Do autoCommit = true → dữ liệu được lưu ngay lập tức vào database
//        Bước 2:
//        int x = 10 / 0;
//        Xảy ra lỗi RuntimeException (chia cho 0)
//        Chương trình bị dừng tại đây
//        Bước 3:
//        ps2.executeUpdate();
//        Không được thực thi do chương trình đã lỗi trước đó
//        Không có dữ liệu được ghi vào bảng lịch sử
//        Kết quả
//        Bảng Medicine_Inventory: đã bị trừ thuốc
//        Bảng Prescription_History: không có bản ghi
//
//        → Dữ liệu bị sai lệch
//
//        Nguyên nhân
//
//        Do hệ thống sử dụng chế độ Auto-Commit, nên:
//
//        Câu lệnh đầu tiên đã được commit ngay lập tức
//        Khi lỗi xảy ra, không có cơ chế rollback để hoàn tác
//        Kết luận
//
//        Chương trình không đảm bảo tính Atomicity trong Transaction:
//
//        Một nghiệp vụ phải thực hiện toàn bộ hoặc không thực hiện gì cả
//
//        PHẦN 2 – THỰC THI (SỬA CODE)
//        Giải pháp
//        Tắt chế độ Auto-Commit
//        Thực hiện commit thủ công khi tất cả câu lệnh thành công
//        Nếu xảy ra lỗi → rollback toàn bộ
//        Code hoàn chỉnh

package Ss13.Bai01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Ss13.Bai01.util.DataConnect;

public class HospitalService {

    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;

        try {
            conn = DataConnect.getConnection();

            // Tắt auto-commit
            conn.setAutoCommit(false);

            // Thao tác 1: Trừ thuốc
            String sqlUpdateInventory =
                    "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlUpdateInventory);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            // Thao tác 2: Ghi lịch sử
            String sqlInsertHistory =
                    "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
            PreparedStatement ps2 = conn.prepareStatement(sqlInsertHistory);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            // Nếu tất cả thành công → commit
            conn.commit();

            System.out.println("Cấp phát thuốc thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) {
                    // Có lỗi → rollback
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Có lỗi xảy ra: " + e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true); // reset lại
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}