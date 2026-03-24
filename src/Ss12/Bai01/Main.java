//Phần 1 – Phân tích
//Vì sao code hiện tại bị SQL Injection? truy van cau truc
//
//Do bạn nối chuỗi trực tiếp từ input người dùng:
//
//String sql = "SELECT * FROM Doctors WHERE code = '" + code + "' AND pass = '" + pass + "'";
//
//Khi người dùng nhập:
//
//        ' OR '1'='1
//
//Câu SQL trở thành:
//
//SELECT * FROM Doctors WHERE code = 'abc' AND pass = '' OR '1'='1'
//
//Điều kiện '1'='1' luôn đúng → toàn bộ mệnh đề WHERE trở thành đúng → hệ thống trả về dữ liệu → đăng nhập thành công dù sai mật khẩu.
//
//Vì sao PreparedStatement chống được SQL Injection?
//
//PreparedStatement hoạt động theo cơ chế tách biệt câu lệnh SQL và dữ liệu đầu vào.
//
//Pre-compiled (biên dịch trước)
//
//Câu SQL được gửi lên database dưới dạng cố định:
//
//SELECT * FROM Doctors WHERE code = ? AND pass = ?
//
//Database đã phân tích và cố định cấu trúc câu lệnh từ trước.
//
//Gán tham số
//stmt.setString(1, code);
//stmt.setString(2, pass);
//
//Giá trị người dùng nhập vào chỉ được xem là dữ liệu, không thể thay đổi cấu trúc SQL.
//
//Ví dụ nếu nhập:
//
//        ' OR '1'='1
//
//Thì database hiểu là:
//
//pass = "' OR '1'='1"
//
//Đây chỉ là một chuỗi bình thường, không còn ý nghĩa logic SQL → không thể injection.
//
//        Kết luận
//Statement thường: dễ bị SQL Injection do nối chuỗi
//PreparedStatement: an toàn vì tách SQL và dữ liệu, và dùng cơ chế biên dịch trước
//Phần 2 – Code an toàn với PreparedStatement
//String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
//
//PreparedStatement stmt = conn.prepareStatement(sql);
//
//// Gán giá trị
//stmt.setString(1, code);
//stmt.setString(2, pass);
//
//// Thực thi
//ResultSet rs = stmt.executeQuery();
//
//// Kiểm tra kết quả
//if (rs.next()) {
//        System.out.println("Đăng nhập thành công");
//} else {
//        System.out.println("Sai tài khoản hoặc mật khẩu");
//}