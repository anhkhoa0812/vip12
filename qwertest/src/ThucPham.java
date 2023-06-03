
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.text.DecimalFormat;
import java.util.Date;

public class ThucPham {

    private final String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    public ThucPham(String maHang) {
        if (maHang.isEmpty()) {
            throw new IllegalArgumentException("Ma Hang khong the trong!");
        }
        this.maHang = maHang;
    }

    public ThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        if (maHang.isEmpty()) {
            throw new IllegalArgumentException("Ma Hang khong the trong!");
        }
        if (tenHang.isEmpty()) {
            throw new IllegalArgumentException("Ten Hang khong duoc trong!");
        }
        if (ngaySanXuat == null || ngayHetHan == null) {
            throw new IllegalArgumentException("Ngay khong duoc trong!");
        }

        if (ngaySanXuat.after(ngayHetHan)) {
            throw new IllegalArgumentException("Ngay san xuat phai truoc ngay het han!");
        }
        if (donGia <= 0) {
            throw new IllegalArgumentException("Don gia phai lon hon 0!");
        }
        this.maHang = maHang;
        setTenHang(tenHang);
        setDonGia(donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang.isEmpty()) {
            throw new IllegalArgumentException("Ten Hang khong duoc trong!");
        }
        this.tenHang = tenHang;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat == null) {
            throw new IllegalArgumentException("Ngay khong duoc trong!");
        }
        if (ngaySanXuat.after(ngayHetHan)) {
            throw new IllegalArgumentException("Ngay san xuat phai truoc ngay het han!");
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    public Date getNgayHetHan() {

        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan == null) {
            throw new IllegalArgumentException("Ngay khong duoc trong!");
        }
        if (ngayHetHan.before(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat!");
        }
        this.ngayHetHan = ngayHetHan;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            throw new IllegalArgumentException("Don gia phai lon hon 0!");
        }
        this.donGia = donGia;
    }

    public void thucPhamHetHan(String ngayHetHan) {

        LocalDate ngayHienTai = LocalDate.now();

        LocalDate ngayHetHanLocalDate = LocalDate.parse(ngayHetHan);

        if (ngayHetHanLocalDate.isBefore(ngayHienTai)) {
            System.out.println("Thuc pham da het han!");
        } else {
            System.out.println("Thuc pham chua het han!");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dinhDangNgay = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat hangNghin = new DecimalFormat("#,###");

        String dinhDangNgaySanXuat = dinhDangNgay.format(ngaySanXuat);
        String dinhDangNgayHetHan = dinhDangNgay.format(ngayHetHan);
        String dinhDangDonGia = hangNghin.format(donGia);

        return "Ma hang: " + maHang + ", " + "Ten hang: " + tenHang + ", " + "Don gia: "
                + donGia + ", " + "Ngay san xuat: " + dinhDangNgaySanXuat
                + ", " + "Ngay het han: " + ngayHetHan;

    }

}
