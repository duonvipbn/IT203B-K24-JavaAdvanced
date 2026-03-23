package learning;

public class TimSoCo5ChuSo {
    public static void main(String[] args) {
        int count = 0;


        for (int i = 10000; i <= 99999; i++) {
            if (tinhTongChuSo(i) == 25) {
                System.out.println(i);
                count++;
            }
        }

        System.out.println("Có tất cả " + count + " số thỏa mãn điều kiện.");
    }

    public static int tinhTongChuSo(int n) {
        int tong = 0;
        while (n > 0) {
            tong += n % 10;
            n /= 10;
        }
        return tong;
    }
}
