//PHẦN 1 – PHÂN TÍCH
//Code hiện tại:
//String patientName = "' OR '1'='1";
//String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
//Sau khi nối chuỗi, câu SQL thực tế là:
//SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
//Vì sao WHERE luôn đúng?
//        '1'='1' luôn true
//Điều kiện trở thành:
//full_name = '' OR true
//
//        → Mà:
//
//        false OR true = true
//Kết quả
//WHERE luôn đúng với mọi dòng
//Database trả về toàn bộ bệnh nhân
//
//→ Dẫn đến:
//
//Rò rỉ dữ liệu nghiêm trọng
//Lộ toàn bộ bệnh án
//PHẦN 2 – THỰC THI
//: Lọc ký tự nguy hiểm (theo yêu cầu đề)
//Ý tưởng:
//
//Loại bỏ các ký tự:
//
//        '
//        ;
//        --
//Code xử lý
//String patientName = inputName;
//
//// Loại bỏ ký tự nguy hiểm
//patientName = patientName.replace("'", "");
//patientName = patientName.replace(";", "");
//patientName = patientName.replace("--", "");
//
//// Tạo câu SQL an toàn hơn
//String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
//
//ResultSet rs = stmt.executeQuery(sql);
//
//while (rs.next()) {
//        System.out.println("Tên: " + rs.getString("full_name"));
//        }