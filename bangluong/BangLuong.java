package bangluong;

import NhanVien.NhanVien;
import NhanVien.QuanLyNhanVien;

import jdk.swing.interop.SwingInterOpUtils;
import sanphamthoitrang.QuanLySPThoiTrang;
import sanphamthoitrang.SanPham;
import sanphamtieudung.QuanLySPTieuDung;

import java.util.ArrayList;
import java.util.Scanner;

public class BangLuong {
    private String maLuong, maNhanVienTrongBL;
    private double thanhTien;
    private ArrayList<SanPham> dsSanPhamTrongBangLuong =new ArrayList<>();
    NhanVien nvTrongBL;
    SanPham spTrongBL;



    //hàm tạo
    public BangLuong(){

    }


    //Nhập sản phẩm vào bảng lương
    public void nhapSPvaoBL(){
        QuanLySPThoiTrang dsSPTT=new QuanLySPThoiTrang();
        QuanLySPTieuDung dsSPTD=new QuanLySPTieuDung();
        Scanner sc = new Scanner(System.in);
        String maSP;
        int luaChon;
        do {
            System.out.println("Chọn loại sản phẩm ( 1-Thời trang | 2-Tiêu dùng ) ");
            luaChon=Integer.parseInt(sc.nextLine());
            switch (luaChon){
                case 1 :
                    //lấy thông tin sản phẩm từ file
                    dsSPTT.docFileSPTT();
                    dsSPTT.hienSPThoiTrang();
                    System.out.println("Nhập mã sản phẩm thời trang : ");
                    maSP=sc.nextLine();
                    //kiểm tra sp có tồn tại ko
                    spTrongBL=(SanPham) dsSPTT.kiemTraSPThoiTrang(maSP);
                    if(spTrongBL==null)
                        System.out.println("Ko tìm thấy !");
                    break;
                case 2 :
                    dsSPTD.docFileSPTieuDung();
                    dsSPTD.hienSPTieuDung();
                    System.out.println("Nhập mã sản phẩm tiêu dùng : ");
                    maSP=sc.nextLine();
                    spTrongBL=(SanPham) dsSPTD.kiemTraMaSPTieuDung(maSP);
                    if(spTrongBL==null)
                        System.out.println("Ko tìm thấy !");
                    break;
                default:
                    System.out.println("Lựa chọn ko hợp lệ, mời nhập lại !");
            }
        }while (luaChon<0 || luaChon>2);
        dsSanPhamTrongBangLuong.add(spTrongBL);
    }

    //Nhập nhân viên vào bảng lương
    public void nhapNVvaoBL(){
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien qlnv=new QuanLyNhanVien();
        //lấy thông tin nhân viên từ file
        qlnv.docFileNhanVien();
        qlnv.hienDSNhanVien();
        //kiểm tra nhập có đúng mã hay ko
        boolean flag=true;
        while (flag) {
            System.out.println("Nhập mã nhân viên cần tạo bảng lương : ");
            this.maNhanVienTrongBL = sc.nextLine();
            nvTrongBL = qlnv.kiemTraNhanVien(maNhanVienTrongBL);
            if (nvTrongBL != null) {
                flag = false;
            }else
                System.out.println("Ko tìm thấy nhân viên có mã " + this.maNhanVienTrongBL);
        }
    }

    //Nhập các thông tin vào bảng lương
    public void nhapBangLuong(){
        System.out.println("Nhập mã bảng lương : ");
        this.maLuong=new Scanner(System.in).nextLine();
        nhapNVvaoBL();
        nhapSPvaoBL();
    }


   //Hiện hoá đơn
    public void hienBangLuong(){
        System.out.println("\t\t\t\t\t\t\t====================== BẢNG LƯƠNG ============================");
        System.out.println("Mã lương : "+this.maLuong);
        //hiện tt nhân viên
        System.out.println("_____________________________________________________");
        System.out.println("THÔNG TIN NHÂN VIÊN ");
        System.out.printf("%-10s %-20s %-35s %-15s %-15s %-15s %-10s\n","Mã","Họ tên","Ngày sinh",
                "Địa chỉ","Giới tính","SĐT","Số lượng sản phẩm");
        System.out.println(nvTrongBL.toString());

        //hiện tt sản phẩm
        System.out.println("_____________________________________________________");
        System.out.println("THÔNG TIN SẢN PHẨM ");
        //
        System.out.printf("%s\t %-20s %-20s %-20s %-20s %-20s\n", "Nhãn hàng ", "Mã SP", "Tên SP", "Nước SX", "Năm SX",
                "Đơn giá");
        System.out.println(spTrongBL.toString());
        //hiện lương
        this.thanhTien=nvTrongBL.getSoLuongSanPham()*spTrongBL.getDonGia();
        System.out.println("_____________________________________________________");
        System.out.println("LƯƠNG = SỐ LƯỢNG SP * ĐƠN GIÁ = "+nvTrongBL.getSoLuongSanPham()+" * "+spTrongBL.getDonGia()+
                    " = "+this.thanhTien);
        System.out.println("\t\t\t\t\t\t\t===============================================================\n");

    }


    //get,set
    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getMaNhanVienTrongBL() {
        return maNhanVienTrongBL;
    }

    public void setMaNhanVienTrongBL(String maNhanVienTrongBL) {
        this.maNhanVienTrongBL = maNhanVienTrongBL;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
