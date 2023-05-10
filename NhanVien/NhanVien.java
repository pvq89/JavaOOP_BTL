package NhanVien;

import java.text.ParseException;
import java.util.Scanner;

public class NhanVien extends ConNguoi{
    private String maNV;
    private int soLuongSanPham;

    //hàm tạo
    public NhanVien(){
    }


    //nhập
    @Override
    public void nhapThongTin() throws ParseException {
        System.out.println("Nhập mã nhân viên : ");
        this.maNV=new Scanner(System.in).nextLine();
        super.nhapThongTin();
        System.out.println("Nhập số lượng sản phẩm : ");
        this.soLuongSanPham=new Scanner(System.in).nextInt();
    }

    //hiện
    @Override
    public String toString() {
        return String.format("%-10s %s %-10s",this.maNV,super.toString(),this.soLuongSanPham);
    }


    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }
}
