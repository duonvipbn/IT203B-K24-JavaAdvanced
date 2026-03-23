//PHẦN 1: PHÂN TÍCH LOGIC (LÝ THUYẾT)
//        Vi phạm nguyên tắc Atomicity (Tính nguyên tử):
//
//        Trong một giao dịch (Transaction), quy tắc tối thượng là "Tất cả hoặc không có gì".
//
//        Việc chỉ dùng System.out.println() trong khối catch mà không gọi rollback() khiến các lệnh SQL đã chạy thành công trước đó (lệnh trừ tiền) vẫn nằm ở trạng thái "treo" trong bộ đệm của Database.
//
//        Nếu kết nối không được đóng đúng cách hoặc bị dùng lại, dữ liệu sai lệch này có thể vô tình bị commit sau đó, dẫn đến việc bệnh nhân bị trừ tiền nhưng hóa đơn vẫn chưa thanh toán.
//
//        Hành động thiết yếu bị bỏ quên:
//
//        Lập trình viên đã quên lệnh conn.rollback(). Đây là lệnh bắt buộc để báo với Database hủy bỏ toàn bộ các thao tác tạm thời và quay về trạng thái an toàn trước khi bắt đầu giao dịch.
//
//        Ngoài ra, cần bọc rollback() trong một khối try-catch riêng vì bản thân việc hủy giao dịch cũng có thể gặp sự cố kết nối.
//
////        PHẦN 2: THỰC THI (MÃ NGUỒN HOÀN CHỈNH)
package Ss13.Bai02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Ss13.Bai02.util.DataConnect;

public class HospitalService {

    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        try (Connection conn = DataConnect.getConnection()) {
            if (conn == null) {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
                return;
            }

            conn.setAutoCommit(false);

            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            String sqlUpdateInvoice = "UPDATE Invoicesss SET status = 'PAID' WHERE invoice_id = ?";

            try (PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
                 PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice)) {

                ps1.setDouble(1, amount);
                ps1.setInt(2, patientId);
                int row1 = ps1.executeUpdate();
                System.out.println("Bước 1: Đã trừ tiền trong ví (tạm thời)...");


                ps2.setInt(1, invoiceId);
                int row2 = ps2.executeUpdate();
                System.out.println("Bước 2: Đã cập nhật hóa đơn (tạm thời)...");


                conn.commit();
                System.out.println("Thanh toán thành công! Dữ liệu đã được lưu.");

            } catch (SQLException e) {

                System.err.println("Lỗi xảy ra tại: " + e.getMessage());
                System.out.println("Đang thực hiện Rollback để bảo toàn số dư cho bệnh nhân...");

                try {
                    if (conn != null) {
                        conn.rollback(); // Khôi phục lại trạng thái ban đầu
                        System.out.println("Rollback thành công. Dữ liệu không bị thay đổi.");
                    }
                } catch (SQLException ex) {
                    System.err.println("Lỗi khi thực hiện Rollback: " + ex.getMessage());
                }
            } finally {

                try {
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi kết nối hoặc hệ thống: " + e.getMessage());
        }
    }
}