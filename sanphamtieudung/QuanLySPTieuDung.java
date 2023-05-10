package sanphamtieudung;

import File.XuLyFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySPTieuDung {
    ArrayList<SanPhamTieuDung> dsSPTieuDung=new ArrayList<>();

    //1.nhập
    public void nhapSPTieuDung(){
        System.out.println("Nhập số lượng sản phẩm :");
        int sl=new Scanner(System.in).nextInt();
        SanPhamTieuDung sptd;
        for(int i=0; i<sl; i++){
            System.out.println("Nhập sản phẩm tiêu dùng thứ "+(i+1));
            sptd=new SanPhamTieuDung();
            sptd.nhapSanPham();
            dsSPTieuDung.add(sptd);
            System.out.println("=========================================");
        }
    }

    //2.Hiện
    public void hienSPTieuDung(){
        System.out.printf("%s\t %-20s %-20s %-20s %-20s %-20s\n", "Loại SP ", "Mã SP", "Tên SP", "Nước SX", "Năm SX",
                "Đơn giá");
        for(SanPhamTieuDung sptd :dsSPTieuDung){
            System.out.println(sptd.toString());
        }
    }

    //3.Sắp xếp theo tên, nếu trùng nhau thì sắp xếp theo giá
    public void sapXepTheoTenHoacGia(){
        Comparator sx=new Comparator<SanPhamTieuDung>() {
            @Override
            public int compare(SanPhamTieuDung o1, SanPhamTieuDung o2) {
                int kq=o1.getTenSanPham().compareToIgnoreCase(o2.getTenSanPham());
                if(kq==0){
                    return kq=o1.getDonGia()-o2.getDonGia();
                }
                return kq;
            }
        };
        Collections.sort(dsSPTieuDung,sx);
        hienSPTieuDung();
    }

    //4.Tìm kiếm theo tên sản phẩm
    public void timKiemTheoTen(){
        System.out.println("Nhập tên sản phẩm tiêu dùng cần tìm :");
        String tenCanTim=new Scanner(System.in).nextLine();
        for(SanPhamTieuDung sptd :dsSPTieuDung){
            if(sptd.getTenSanPham().equalsIgnoreCase(tenCanTim)){
                System.out.printf("%s\t %-20s %-20s %-20s %-20s %-20s\n", "Loại SP ", "Mã SP", "Tên SP", "Nước SX", "Năm SX",
                        "Đơn giá");
                System.out.println(sptd.toString());
            }
        }
    }

    //5.Thêm nhiều sản phẩm vào vị trí
    public void themNhieuSP(){
        int vt;
        SanPhamTieuDung sptd;
        System.out.println("Nhập số lượng sản phẩm cần thêm :");
        int sl=new Scanner(System.in).nextInt();
        for(int i=0;i<sl; i++){
            do{
                System.out.println("SẢN PHẨM THÊM THỨ "+(i+1)+" thêm vào vị trí :");
                vt=new Scanner(System.in).nextInt();
                if(vt<0 || vt>dsSPTieuDung.size())
                    System.out.println("Nhập sai vị trí, mời nhập lại !");
            }while (vt<0 || vt>dsSPTieuDung.size());
            sptd=new SanPhamTieuDung();
            sptd.nhapSanPham();
            dsSPTieuDung.add(vt-1,sptd);
        }
        hienSPTieuDung();
    }

    //6.Sửa giá sản phẩm theo tên
    public void suaGia(){
        System.out.println("Nhập tên sản phẩm cần sửa :");
        String tenCanSua=new Scanner(System.in).nextLine();
        for(SanPhamTieuDung sptd :dsSPTieuDung){
            if(sptd.getTenSanPham().equalsIgnoreCase(tenCanSua)){
                int gia;
                System.out.println("Nhập giá : ");
                gia=new Scanner(System.in).nextInt();
                sptd.setDonGia(gia);
            }
        }
        hienSPTieuDung();
    }

    //7.Xoá các sản phẩm theo mã
    public void xoaTheoMa(){
        System.out.println("Nhập mã cẫn xoá :");
        String maXoa=new Scanner(System.in).nextLine();
        for(int i=0;i<dsSPTieuDung.size();i++) {
            SanPhamTieuDung sptd=dsSPTieuDung.get(i);
            if(sptd.getMaSanPham()==maXoa)
                dsSPTieuDung.remove(i);
        }
        hienSPTieuDung();
    }

    //8. Xoá toàn bộ danh sách
    public void xoaAll(){
        dsSPTieuDung.clear();
        System.out.println("Đã xoá toàn bộ danh sách ");
    }

    //9.Ghi file
    public void ghiFiledsSPTieuDung(){
        XuLyFile xlFile = new XuLyFile();
        xlFile.ghiFile(dsSPTieuDung,"dssptieudung.txt");
    }

    //10.đọc file
    public void docFileSPTieuDung(){
        XuLyFile xlFile=new XuLyFile();
        this.dsSPTieuDung=(ArrayList<SanPhamTieuDung>) xlFile.docFile("dssptieudung.txt");
    }

    //11.kiểm tra mã sptd có tồn tại hay ko
    public SanPhamTieuDung kiemTraMaSPTieuDung(String ma){
        for(SanPhamTieuDung sptd : dsSPTieuDung)
            if(sptd.getMaSanPham().equalsIgnoreCase(ma))
                return sptd;
        return null;
    }






}
