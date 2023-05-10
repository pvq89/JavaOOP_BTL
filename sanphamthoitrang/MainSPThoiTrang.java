package sanphamthoitrang;

import java.util.Scanner;

public class MainSPThoiTrang {
    public static void menuSPThoiTrang(){
        System.out.println("===============Quản lý sản phẩm thời trang=============");
        System.out.println("\t\t 0.Thoát");
        System.out.println("\t\t 1.Nhập danh sách sản phẩm ");
        System.out.println("\t\t 2.Hiện danh sách sản phẩm ");
        System.out.println("\t\t 3.Sắp xếp theo giá hoặc năm sản xuất");
        System.out.println("\t\t 4.Tìn kiếm theo nhãn hàng ");
        System.out.println("\t\t 5.Thêm 1 sản phẩm vào vị trí ");
        System.out.println("\t\t 6.Sửa sản phẩm theo mã ");
        System.out.println("\t\t 7.Xoá sản phẩm theo năm tuỳ chọn ");
        System.out.println("\t\t 8.Ghi file danh sách sản phẩm ");
        System.out.println("\t\t 9.Đọc file danh sách sản phẩm ");
        System.out.println("================================================");
    }

    public static void main(String[] args) {
        QuanLySPThoiTrang qlSPDon=new QuanLySPThoiTrang();
        int luaChon;
        boolean flag=true;
        do{
            menuSPThoiTrang();
            System.out.println("Nhập lựa chọn : ");
            luaChon=new Scanner(System.in).nextInt();
            switch (luaChon){
                case 1 :
                    qlSPDon.nhapSPThoiTrang();
                    break;
                case 2 :
                    qlSPDon.hienSPThoiTrang();
                    break;
                case 3 :
                    qlSPDon.sapXepTheoGiaHoacNamSanXuat();
                    break;
                case 4 :
                    qlSPDon.timKiemTheoNhanHang();
                    break;
                case 5 :
                    qlSPDon.themvaoViTri();
                    break;
                case 6 :
                    qlSPDon.suaSPTheoMa();
                    break;
                case 7 :
                    qlSPDon.xoaTheoNam();
                    break;
                case 8:
                    qlSPDon.ghiFileSPTT();
                    break;
                case 9 :
                    qlSPDon.docFileSPTT();
                    break;
                case 0 :
                    System.out.println("Kết thúc ");
                    flag=false;
            }
        }while(flag!=false);
    }
}
