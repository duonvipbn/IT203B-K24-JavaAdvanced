//PHẦN 1 – PHÂN TÍCH
//Ý nghĩa của executeUpdate()
//int result = stmt.executeUpdate(sql);
//executeUpdate() trả về số dòng (row) bị ảnh hưởng
//Giá trị	Ý nghĩa
//> 0	Có dòng được cập nhật thành công
//= 0	Không có dòng nào bị ảnh hưởng
//Áp dụng vào bài toán
//
//Trường hợp:
//
//WHERE bed_id = 'Bed_999'
//Nếu Bed_999 không tồn tại → không có dòng nào khớp
//executeUpdate() trả về 0
//Kết luận
//
//→ Dựa vào giá trị trả về:
//
//        > 0 → Cập nhật thành công
//        = 0 → Mã giường không tồn tại
//
//→ Nhờ đó có thể thông báo chính xác cho y tá
//
//PHẦN 2 – THỰC THI
//Code đúng
//String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = '" + inputId + "'";
//
//int rowsAffected = stmt.executeUpdate(sql);
//
//if (rowsAffected > 0) {
//        System.out.println("Đã cập nhật giường bệnh thành công!");
//} else {
//        System.out.println("Lỗi: Mã giường không tồn tại!");
//}