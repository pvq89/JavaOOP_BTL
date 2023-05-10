package NhanVien;

import File.XuLyFile;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyNhanVien {
     ArrayList<NhanVien> dsNhanVien=new ArrayList<>();

    //1.nhập
    public void nhapDSNhanVien() throws ParseException {
        System.out.println("Nhập số lượng nhân viên : ");
        int slNhanVien= new Scanner(System.in).nextInt();
        NhanVien nv;
        for(int i=0; i<slNhanVien; i++){
            System.out.println("Nhân viên thứ "+(i+1));
            nv=new NhanVien();
            nv.nhapThongTin();
            dsNhanVien.add(nv);
            System.out.println("====================================");
        }
    }

    //2.hiện
    public void hienDSNhanVien(){
        System.out.printf("%-10s %-20s %-35s %-15s %-15s %-15s %-10s\n","Mã","Họ tên","Ngày sinh",
        "Địa chỉ","Giới tính","SĐT","Số lượng sản phẩm");
        for(NhanVien nv : dsNhanVien)
            System.out.println(nv.toString());
    }

    //3.tìm kiếm 1 nhân viên theo mã
    public void timKiemTheoMa(){
        System.out.println("Nhập mã cần tìm : ");
        String maCanTim=new Scanner(System.in).nextLine();
        for(NhanVien nv : dsNhanVien){
            if(nv.getMaNV().equalsIgnoreCase(maCanTim)){
                System.out.println("Tìm thấy nhân viên !");
                System.out.printf("%-10s %-20s %-35s %-15s %-15s %-15s %-10s\n","Mã","Họ tên","Ngày sinh",
                        "Địa chỉ","Giới tính","SĐT","Số lượng sản phẩm");
                System.out.println(nv.toString());
                break;
            }
        }
    }

    //4.tìm kiếm 1 nhân viên theo họ tên
    public void timKiemTheoHoTen(){
        System.out.println("Nhập họ tên nhân viên cần tìm : ");
        String hoTenNVCanTim=new Scanner(System.in).nextLine();
        for(NhanVien nv : dsNhanVien){
            if(nv.getHoTen().equalsIgnoreCase(hoTenNVCanTim)){
                System.out.println("Tìm thấy nhân viên !");
                System.out.printf("%-10s %-20s %-35s %-15s %-15s %-15s %-10s\n","Mã","Họ tên","Ngày sinh",
                        "Địa chỉ","Giới tính","SĐT","Số lượng sản phẩm");
                System.out.println(nv.toString());
                break;
            }
        }
    }


    //5.hiện ra các nhân viên có số lượng sản phẩm từ x đến y
    public void soLuongTuXDenY(){
        System.out.println("Nhập số sản phẩm : ");
        int x=new Scanner(System.in).nextInt();
        int y=new Scanner(System.in).nextInt();
        System.out.printf("Danh sách nhân viên có số lượng sản phẩm từ %d đến %d : \n",x,y);
        System.out.printf("%-10s %-20s %-35s %-15s %-15s %-15s %-10s\n","Mã","Họ tên","Ngày sinh",
                "Địa chỉ","Giới tính","SĐT","Số lượng sản phẩm");
        for(NhanVien nv : dsNhanVien){
            if(nv.getSoLuongSanPham()>x && nv.getSoLuongSanPham()<= y)
                System.out.println(nv.toString());
        }
    }

    //6.sửa thông tin nhân viên theo mã
    public void suaThongTinNhanVien() throws ParseException {
        System.out.println("Nhập mã nhân viên cần sửa : ");
        String maNhanVienCanSua = new Scanner(System.in).nextLine();
        for(NhanVien nv : dsNhanVien)
            if(nv.getMaNV().equalsIgnoreCase(maNhanVienCanSua)){
                System.out.println("Nhân viên cần sửa : ");
                System.out.printf("%-10s %-20s %-35s %-15s %-15s %-15s %-10s\n","Mã","Họ tên","Ngày sinh",
                        "Địa chỉ","Giới tính","SĐT","Số lượng sản phẩm");
                System.out.println(nv.toString());
                nv.nhapThongTin();
                System.out.println("Sau khi sửa : ");
                hienDSNhanVien();
                break;
            }
    }

    //7.sắp xếp theo số lượng sản phẩm giảm dần
    public void sapXepTheoSanPham(){
        Comparator sx= new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return (o2.getSoLuongSanPham()-o1.getSoLuongSanPham());
            }
        };
        Collections.sort(dsNhanVien,sx);
        hienDSNhanVien();
    }

    //8.sắp xếp nhân viên theo họ tên a->z
    public void sapXepTheoHoTen(){
        Comparator sx=new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
            }
        };
        Collections.sort(dsNhanVien,sx);
        hienDSNhanVien();
    }

    //9.Thêm 1 nhân viên vào vị trí
    public void themNhanVien() throws ParseException {
        System.out.println("Nhập vị trí cần thêm ");
        int vt=new Scanner(System.in).nextInt();
        System.out.println("Nhập thông tin nhân viên cần thêm : ");
        NhanVien nv=new NhanVien();
        if(vt<=dsNhanVien.size()) {
            nv.nhapThongTin();
            dsNhanVien.add(vt-1, nv);
            System.out.println("Thêm nhân viên thành công !");
            hienDSNhanVien();
        }else
            System.out.println("Vị trí cần thêm ko hợp lệ !");
    }

    //10.Xoá 1 nhân viên khỏi vị trí
    public void xoaNhanVien(){
        System.out.println("Nhập vị trị cần xoá : ");
        int vt=new Scanner(System.in).nextInt();
        if(vt<=dsNhanVien.size()){
            System.out.println("Xoá nhân viên thành công !");
            dsNhanVien.remove(vt);
            hienDSNhanVien();
        }else
            System.out.println("Vị trí cần xoá ko hợp lệ !");
    }
    //11.Thống kê tổng số sản phẩm làm dc
    public void thongKeSanPham(){
        int tongSanPham=0;
        for(NhanVien nv : dsNhanVien){
            System.out.println("Nhân viên "+nv.getHoTen().toUpperCase()+" làm được :"+nv.getSoLuongSanPham()+" sản phẩm ");
            tongSanPham+=nv.getSoLuongSanPham();
        }
        System.out.println("Tổng số lượng sản phẩm : "+tongSanPham);
    }

    //12.ghi file
    public void ghiFileNhanVien(){
        XuLyFile xlFile=new XuLyFile();
        xlFile.ghiFile(dsNhanVien,"dsnhanvien.txt");
    }

    //13.đọc file
    public void docFileNhanVien(){
        XuLyFile xlFile=new XuLyFile();
        this.dsNhanVien=(ArrayList<NhanVien>) xlFile.docFile("dsnhanvien.txt");

    }

    //14.kiểm tra nhân viên có tồn tại bằng mã
    public NhanVien kiemTraNhanVien(String ma){
        for (NhanVien nv :dsNhanVien){
            if(nv.getMaNV().equals(ma))
            return nv;
            }
        return null;
    }









}
