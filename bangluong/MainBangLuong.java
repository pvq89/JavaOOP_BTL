package bangluong;

import NhanVien.QuanLyNhanVien;
import sanphamthoitrang.QuanLySPThoiTrang;
import sanphamthoitrang.SanPham;
import sanphamthoitrang.SanPhamThoiTrang;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainBangLuong {
    public static void menuBangLuong(){
        System.out.println("==================== Quản lý bảng lương ====================");
        System.out.println("\t0.Thoát");
        System.out.println("\t1.Nhập bảng lương ");
        System.out.println("\t2.Hiện bảng lượng");
        System.out.println("\t3.Sắp xếp theo lương ");
        System.out.println("\t4.Tính tổng lương phải trả ");
        System.out.println("\t5.Tìm bảng lương theo mã  ");
        System.out.println("\t6.Xoá bảng lương theo mã ");
        System.out.println("\t7.Thêm 1 bảng lương vào vị trí ");
        System.out.println("\t8. Sửa bảng lương theo mã ");
        System.out.println("\t9.Ghi file danh sách bảng lương ");
        System.out.println("\t10.Đọc file danh sách bảng lương ");
        System.out.println("============================================================");
    }
    public static void main(String[] args) throws ParseException, IOException {
        QuanLyBangLuong qlBangLuong = new QuanLyBangLuong();
        int luaChon;
        boolean flag=true;
        do{
            menuBangLuong();
            System.out.println("Nhập lựa chọn của bạn : " );
            luaChon=new Scanner(System.in).nextInt();
            switch (luaChon){
                case 1 :
                    qlBangLuong.nhapBangLuong();
                    break;
                case 2 :
                    qlBangLuong.hienBangLuong();
                    break;
                case 3 :
                    qlBangLuong.sapXepLuong();
                    break;
                case 4:
                    qlBangLuong.tinhTongLuongTra();
                    break;
                case 5 :
                    qlBangLuong.timKiemBangLuongTheoMa();
                    break;
                case 6 :
                    qlBangLuong.xoaBangLuongTheoMa();
                    break;
                case 7 :
                    qlBangLuong.themBangLuong();
                    break;
                case 8 :
                    qlBangLuong.suaBangLuong();
                    break;
                case 9 :
                    qlBangLuong.ghifileBangLuong();
                    break;
                case 10 :
                    qlBangLuong.docFileBangLuong();
                    break;
                case 0 :
                    System.out.println("Kết thúc chương trình ");
                    flag=false;
            }

        }while (flag!=false);














    }
}
