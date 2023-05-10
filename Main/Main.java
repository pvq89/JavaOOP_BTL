package Main;

import NhanVien.MainNhanVien;
import NhanVien.QuanLyNhanVien;
import bangluong.BangLuong;
import bangluong.MainBangLuong;
import sanphamthoitrang.MainSPThoiTrang;
import sanphamtieudung.MainSPTieuDung;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void menuMain(){
        System.out.println("\t\t\t\t\t=========== Chương trình quản lý lương theo sản phẩm ===========");
        System.out.println("\t\t\t\t\t\t\t0.Thoát");
        System.out.println("\t\t\t\t\t\t\t1.Quản lý nhân viên ");
        System.out.println("\t\t\t\t\t\t\t2.Quản lý sản phẩm thời trang");
        System.out.println("\t\t\t\t\t\t\t3.Quản lý sản phẩm tiêu dùng");
        System.out.println("\t\t\t\t\t\t\t4.Quản lý bảng lương ");
        System.out.println("\t\t\t\t\t================================================================");

    }
    public static void main(String[] args) throws ParseException, IOException {
       int luaChon;
       boolean flag=true;
       do {
           menuMain();
           System.out.println("Nhập lựa chọn : ");
           luaChon=new Scanner(System.in).nextInt();
           switch (luaChon){
               case 1 :
                   MainNhanVien.main(null);
                   break;
               case 2 :
                   MainSPThoiTrang.main(null);
                   break;
               case 3 :
                   MainSPTieuDung.main(null);
                   break;
               case 4  :
                   MainBangLuong.main(null);
                   break;
               case 0 :
                   System.out.println("Kết thúc chương trình ");
                   flag=false;
           }

       }while (flag!=false);
    }
}
