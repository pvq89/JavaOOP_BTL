package NhanVien;

import java.text.ParseException;
import java.util.Scanner;

public class MainNhanVien {
    public static void menuNhanVien(){
        System.out.println("=======================Quản lý nhân viên===========================");
        System.out.println("\t\t0.Thoát");
        System.out.println("\t\t1.Nhập danh sách nhân viên ");
        System.out.println("\t\t2.Hiện danh sách nhân viên ");
        System.out.println("\t\t3.Tìm kiến nhân viên theo mã ");
        System.out.println("\t\t4.Tìm kiếm nhân viên theo họ tên ");
        System.out.println("\t\t5.Tìm kiếm nhân viên làm được số sản phẩm từ x->y");
        System.out.println("\t\t6.Sửa thông tin nhân viên theo mã ");
        System.out.println("\t\t7.Sắp xếp thông tin nhân viên giảm dần theo số sản phẩm");
        System.out.println("\t\t8.Sắp xếp thông tin nhân viên theo họ tên a->z");
        System.out.println("\t\t9.Thêm 1 nhân viên vào vị trí ");
        System.out.println("\t\t10.Xoá 1 nhân viên theo vị trí ");
        System.out.println("\t\t11.Thống kê tổng số sản phẩm các nhân viên làm được ");
        System.out.println("\t\t12.Ghi danh sách nhân viên ");
        System.out.println("\t\t13.Đọc danh sách nhân viên ");
        System.out.println("===================================================================");
    }
    public static void main(String[] args) throws ParseException {
        QuanLyNhanVien qlnv=new QuanLyNhanVien();
        int luaChon;
        boolean flag=true;
        do {
            menuNhanVien();
            System.out.println("Nhập lựa chọn : ");
            luaChon=new Scanner(System.in).nextInt();
            switch (luaChon){
                case 1 :
                    qlnv.nhapDSNhanVien();
                    break;
                case 2 :
                    qlnv.hienDSNhanVien();
                    break;
                case 3 :
                    qlnv.timKiemTheoMa();
                    break;
                case 4 :
                    qlnv.timKiemTheoHoTen();
                    break;
                case 5 :
                    qlnv.soLuongTuXDenY();
                    break;
                case 6 :
                    qlnv.suaThongTinNhanVien();
                    break;
                case 7 :
                    qlnv.sapXepTheoSanPham();
                    break;
                case 8 :
                    qlnv.sapXepTheoHoTen();
                    break;
                case 9 :
                    qlnv.themNhanVien();
                    break;
                case 10 :
                    qlnv.xoaNhanVien();
                    break;
                case 11 :
                    qlnv.thongKeSanPham();
                    break;
                case 12 :
                    qlnv.ghiFileNhanVien();
                    break;
                case 13 :
                    qlnv.ghiFileNhanVien();
                    break;
                case 0 :
                    System.out.println("Kết thúc chương trình !");
                    flag=false;
                    break;
                default:
                    System.out.println("Lựa chọn ko hợp lệ ! Mời chọn lại !");

            }
        }while (flag!=false);


    }
}
