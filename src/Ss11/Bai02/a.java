package Ss11.Bai02;

public class a {
}


//PHẦN 1 – PHÂN TÍCH
//1. Vì sao if không đủ?
//
//Đoạn code hiện tại:
//
//        if (rs.next()) {
//        System.out.println("Thuốc: " + rs.getString("medicine_name"));
//        }
//        rs.next() chỉ di chuyển con trỏ đến dòng đầu tiên
//if chỉ chạy 1 lần duy nhất
//
//→ Kết quả:
//
//Chỉ in ra 1 dòng đầu tiên
//Không duyệt hết dữ liệu
//2. Cách con trỏ của ResultSet hoạt động
//
//Ban đầu:
//
//        (con trỏ) -> trước dòng đầu tiên
//
//Sau mỗi lần gọi rs.next():
//
//Con trỏ di chuyển xuống 1 dòng
//
//Ví dụ bảng có 3 dòng:
//
//Lần gọi	Vị trí con trỏ
//Ban đầu	trước dòng 1
//next()	dòng 1
//next()	dòng 2
//next()	dòng 3
//next()	hết dữ liệu → false
//        3. Khi bảng rỗng
//rs.next() trả về false
//        if không chạy → không in gì
//
//→ Dễ gây hiểu nhầm là lỗi
//
//Kết luận
//if chỉ xử lý được 1 dòng
//Muốn in danh sách → phải dùng vòng lặp
//PHẦN 2 – THỰC THI
//Code đúng (dùng while)
//ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
//
//while (rs.next()) {
//        System.out.println("Thuốc: " + rs.getString("medicine_name")
//        + " | Số lượng: " + rs.getInt("stock"));
//        }