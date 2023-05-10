package sanphamthoitrang;

import java.io.Serializable;
import java.util.Scanner;

public class SanPham implements Serializable {
    private String maSanPham;
    private String tenSanPham;
    private String nuocSanXuat;
    private int namSanXuat;
    private int donGia;

    //hàm tạo
    public SanPham(){

    }
    //nhập
    public void nhapSanPham(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm : ");
        this.maSanPham=sc.nextLine();
        System.out.println("Nhập tên sản phẩm : ");
        this.tenSanPham=sc.nextLine();
        System.out.println("Nhập nước sản xuất : ");
        this.nuocSanXuat=sc.nextLine();
        System.out.println("Nhập năm sản xuất : ");
        this.namSanXuat=sc.nextInt();
    }

    //hiện
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20d %-20d",this.maSanPham,this.tenSanPham,this.nuocSanXuat,
                this.namSanXuat,this.donGia);
    }

    //get,set
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}




