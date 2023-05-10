package sanphamtieudung;

import java.util.Scanner;

public class MainSPTieuDung {
    public static void menuSPTieuDung(){
        System.out.println("==============Quản lý sản phẩm tiêu dùng=============");
        System.out.println("\t\t0.Thoát");
        System.out.println("\t\t1.Nhập thông tin sản phẩm tiêu dùng");
        System.out.println("\t\t2.Hiện thông tin sản phẩm tiêu dùng ");
        System.out.println("\t\t3.Sắp xếp sản phẩm theo tên hoặc giá ");
        System.out.println("\t\t4.Tìm kiếm theo mã sản phẩm ");
        System.out.println("\t\t5.Thêm 1/nhiều sản phẩm vào vị trí");
        System.out.println("\t\t6.Sửa giá sản phẩm theo tên ");
        System.out.println("\t\t7.Xoá sản phẩm theo mã");
        System.out.println("\t\t8.Xoá toàn bộ danh sách");
        System.out.println("\t\t9.Ghi file danh sách ");
        System.out.println("\t\t10.Đọc file danh sách");
        System.out.println("====================================================");
    }

    public static void main(String[] args) {
        QuanLySPTieuDung qlSPTieuDung=new QuanLySPTieuDung();
        int luaChon;
        boolean flag=true;
        do{
            menuSPTieuDung();
            System.out.println("Nhập lựa chọn :");
            luaChon=new Scanner(System.in).nextInt();
            switch (luaChon){
                case 1:
                    qlSPTieuDung.nhapSPTieuDung();
                    break;
                case 2 :
                    qlSPTieuDung.hienSPTieuDung();
                    break;
                case 3 :
                    qlSPTieuDung.sapXepTheoTenHoacGia();
                    break;
                case 4 :
                    qlSPTieuDung.timKiemTheoTen();
                    break;
                case 5 :
                    qlSPTieuDung.themNhieuSP();
                    break;
                case 6:
                    qlSPTieuDung.suaGia();
                    break;
                case 7 :
                    qlSPTieuDung.xoaTheoMa();
                    break;
                case 8:
                    qlSPTieuDung.xoaAll();
                    break;
                case 9:
                    qlSPTieuDung.ghiFiledsSPTieuDung();
                    break;
                case 10 :
                    qlSPTieuDung.docFileSPTieuDung();
                    break;
                case 0 :
                    System.out.println("Kết thúc ");
                    flag=false;
            }

        }while (flag!=false);

    }
}
