package sanphamthoitrang;

import java.util.Scanner;

public class SanPhamThoiTrang extends SanPham{
    String nhanHang;

    //hàm tạo
    public SanPhamThoiTrang(){

    }
    //nhập
    @Override
    public void nhapSanPham() {
        System.out.println("Chọn nhãn hàng (1-Gucci | 2-Adidas | 3-Nike | 4-Chanel | 5- Zara) : ");
        int luaChon;
        do {
            luaChon=new Scanner(System.in).nextInt();
            switch (luaChon) {
                case 1:
                    this.nhanHang ="Gucci";
                    this.setDonGia(150);
                    break;
                case 2:
                    this.nhanHang ="Adidas";
                    this.setDonGia(250);
                    break;
                case 3:
                    this.nhanHang ="Nike";
                    this.setDonGia(350);
                    break;
                case 4 :
                    this.nhanHang="Chanel";
                    this.setDonGia(450);
                    break;
                case 5 :
                    this.nhanHang="Zara";
                    this.setDonGia(550);
                    break;
                default:
                    System.out.println("Chọn sai nhãn hàng !");
                    System.out.println("Mời nhập lại : ");
            }
        }while (luaChon<1 || luaChon>5);
        super.nhapSanPham();
    }

    //hiện
    @Override
    public String toString() {
        return String.format("%s\t\t %-15s",this.nhanHang,super.toString());
    }

    //set,get
    public String getNhanHang() {
        return nhanHang;
    }

    public void setNhanHang(String nhanHang) {
        this.nhanHang = nhanHang;
    }
}
