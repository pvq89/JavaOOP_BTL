package sanphamtieudung;

import sanphamthoitrang.SanPham;

import java.util.Scanner;

public class SanPhamTieuDung extends SanPham {
    private String loaiSanPham;

    //nhập
    @Override
    public void nhapSanPham() {
        int luaChon;
        do{
            System.out.println("Nhập loại sản phẩm ( 1-Loại 1 | 2-Loại 2 | 3-Loại 3 | 4-Loại 4 | 5-Loại 5 ");
            luaChon=new Scanner(System.in).nextInt();
            switch (luaChon){
                case 1 :
                    this.loaiSanPham="Loại 1";
                    this.setDonGia(100);
                    break;
                case 2 :
                    this.loaiSanPham="Loại 2";
                    this.setDonGia(200);
                    break;
                case 3 :
                    this.loaiSanPham="Loại 3";
                    this.setDonGia(300);
                    break;
                case 4 :
                    this.loaiSanPham="Loại 4";
                    this.setDonGia(400);
                    break;
                case 5 :
                    this.loaiSanPham="Loại 5";
                    this.setDonGia(500);
                    break;
                default:
                    System.out.println("Nhập sai lựa chọn , mời nhập lại !");
            }
        }while (luaChon<1 || luaChon>5);
        super.nhapSanPham();
    }

    //hiện
    @Override
    public String toString() {
        return String.format("%s\t\t %-15s",this.loaiSanPham,super.toString());
    }

    //get,set
    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}
