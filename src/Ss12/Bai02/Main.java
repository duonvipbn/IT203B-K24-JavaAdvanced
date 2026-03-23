//Phần 1 – Phân tích gaio dien
//
//Vấn đề xảy ra do khi dùng Statement nối chuỗi, giá trị số bị phụ thuộc vào Locale của hệ điều hành:
//
//Một số hệ dùng 37.5
//Một số hệ dùng 37,5
//
//Khi nối vào SQL:
//
//temperature = 37,5
//
//Dấu , bị hiểu là phân tách → sai cú pháp SQL
//
//Vì sao setDouble() và setInt() giải quyết được?
//
//PreparedStatement không chèn giá trị bằng chuỗi, mà gửi dữ liệu theo kiểu nhị phân chuẩn đến database.
//
//Cụ thể:
//
//setDouble() gửi đúng kiểu số thực (double)
//setInt() gửi đúng kiểu số nguyên (int)
//Database nhận giá trị theo chuẩn nội bộ, không qua định dạng chuỗi
//Điểm quan trọng
//Không còn phụ thuộc vào cách hiển thị số của hệ điều hành
//Không cần quan tâm dấu . hay ,
//Driver JDBC tự chuyển đổi sang định dạng SQL chuẩn (luôn dùng .)
//Tóm lại
//Statement: chuyển số → string → dễ lỗi do Locale
//PreparedStatement: gửi số đúng kiểu → không lỗi định dạng
//Phần 2 – Thực thi
//String sql = "UPDATE Patients SET temperature = ?, heart_rate = ? WHERE id = ?";
//
//PreparedStatement stmt = conn.prepareStatement(sql);
//
//// Gán giá trị đúng kiểu dữ liệu
//stmt.setDouble(1, temperature); // nhiệt độ (double)
//stmt.setInt(2, heartRate);     // nhịp tim (int)
//stmt.setInt(3, patientId);     // id bệnh nhân
//
//// Thực thi cập nhật
//int rows = stmt.executeUpdate();
//
//if (rows > 0) {
//        System.out.println("Cập nhật thành công");
//} else {
//        System.out.println("Không tìm thấy bệnh nhân");
//}