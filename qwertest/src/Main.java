
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date ngaySanXuat = dateFormat.parse("01/06/2023");
        Date ngayHetHan = dateFormat.parse("03/06/2023");

        ThucPham thucPham = new ThucPham("FE123", "Banh mi tuoi", 15000, ngaySanXuat, ngayHetHan);

        System.out.println("Mã hàng: " + thucPham.getMaHang());
        System.out.println("Tên hàng: " + thucPham.getTenHang());
        System.out.println("Đơn giá: " + thucPham.getDonGia());
        System.out.println("Ngày sản xuất: " + thucPham.getNgaySanXuat());
        System.out.println("Ngày hết hạn: " + thucPham.getNgayHetHan());

        thucPham.thucPhamHetHan("2023-06-30");

        System.out.println(thucPham.toString());
    }
}
