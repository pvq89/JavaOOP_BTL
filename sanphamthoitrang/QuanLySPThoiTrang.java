package sanphamthoitrang;

import File.XuLyFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySPThoiTrang {
    ArrayList<SanPhamThoiTrang> dsSPThoiTrang = new ArrayList<>();

    //1.nhập
    public void nhapSPThoiTrang() {
        System.out.println("Nhập số sản phẩm thời trang : ");
        int soLuong = new Scanner(System.in).nextInt();
        SanPhamThoiTrang spDon;
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin sản phẩm thời trang thứ " + (i + 1));
            spDon = new SanPhamThoiTrang();
            spDon.nhapSanPham();
            dsSPThoiTrang.add(spDon);
            System.out.println("===================================");
        }
    }

    //2.hiện
    public void hienSPThoiTrang() {
        System.out.printf("%s\t %-20s %-20s %-20s %-20s %-20s\n", "Nhãn hàng ", "Mã SP", "Tên SP", "Nước SX", "Năm SX",
                "Đơn giá");
        for (SanPhamThoiTrang spd : dsSPThoiTrang) {
            System.out.println(spd.toString());
        }
    }

    //3.sắp xếp theo giá ,nếu giá bằng nhau thí sắp xếp theo năm sản xuất
    public void sapXepTheoGiaHoacNamSanXuat()   {
        Comparator sx=new Comparator<SanPhamThoiTrang>() {
            @Override
            public int compare(SanPhamThoiTrang o1, SanPhamThoiTrang o2) {
                int kq=o1.getDonGia()-o2.getDonGia();
                if(kq==0)
                    return kq=o1.getNamSanXuat()-o2.getNamSanXuat();
                else
                    return kq;
            }
        };
        Collections.sort(dsSPThoiTrang,sx);
        hienSPThoiTrang();
    }

    //4.tìm kiếm theo nhãn hàng
    public void timKiemTheoNhanHang() {
        System.out.println("Nhập nhãn hàng cần tìm : ");
        String s = new Scanner(System.in).nextLine();
        System.out.printf("%s\t %-20s %-20s %-20s %-20s %-20s\n", "Nhãn hàng ", "Mã SP", "Tên SP", "Nước SX", "Năm SX",
                "Đơn giá");
        for (SanPhamThoiTrang spd : dsSPThoiTrang) {
            if (spd.getNhanHang().equalsIgnoreCase(s))
                System.out.println(spd.toString());
        }
    }

    //5.Thêm 1 sản phẩm vào vị trí
    public void themvaoViTri(){
        int vt;
        do{
            System.out.println("Nhập vị trí cần thêm :");
            vt=new Scanner(System.in).nextInt();
        }while (vt <0 || vt> dsSPThoiTrang.size()+1);
        SanPhamThoiTrang spd=new SanPhamThoiTrang();
        spd.nhapSanPham();
        dsSPThoiTrang.add(vt-1,spd);
        hienSPThoiTrang();
    }

    //6.Sửa sản phẩm theo mã
    public void suaSPTheoMa(){
        System.out.println("Nhập mã sản phẩm cần sửa : ");
        String maCanSua=new Scanner(System.in).nextLine();
        for(SanPhamThoiTrang spd : dsSPThoiTrang){
            if(spd.getMaSanPham().equalsIgnoreCase(maCanSua)){
                System.out.println("Sản phẩm cần sửa :");
                System.out.printf("%s\t %-20s %-20s %-20s %-20s %-20s\n", "Nhãn hàng ", "Mã SP", "Tên SP", "Nước SX", "Năm SX",
                        "Đơn giá");
                System.out.println(spd.toString());
                spd.nhapSanPham();
                System.out.println("Danh sách sau khi sửa : ");
                hienSPThoiTrang();
            }
        }
    }

    //7.Xoá các sản phẩm có năm sx tuỳ chọn
    public void xoaTheoNam(){
        System.out.println("Nhập năm cần xoá : ");
        int namCanXoa=new Scanner(System.in).nextInt();
        ArrayList<SanPhamThoiTrang> dsXoa= new ArrayList<SanPhamThoiTrang>();
        for(int i=0; i<dsSPThoiTrang.size();i++){
            SanPhamThoiTrang sptt=dsSPThoiTrang.get(i);
            if(sptt.getNamSanXuat()==namCanXoa)
                dsXoa.add(sptt);
        }
        dsSPThoiTrang.removeAll(dsXoa);
        hienSPThoiTrang();
    }

    //8.Ghi file ds sản phẩm
    public void ghiFileSPTT(){
        XuLyFile xlFile =new XuLyFile();
        xlFile.ghiFile(dsSPThoiTrang,"dssanphamthoitrang.txt");
    }

    //9.Đọc file
    public void docFileSPTT(){
        XuLyFile xlFile=new XuLyFile();
        this.dsSPThoiTrang=(ArrayList<SanPhamThoiTrang>) xlFile.docFile("dssanphamthoitrang.txt");
    }

    //10.Kiểm tra mã sptt có tồn tại hay ko
    public SanPhamThoiTrang kiemTraSPThoiTrang(String ma){
        for(SanPhamThoiTrang sptt : dsSPThoiTrang)
            if(sptt.getMaSanPham().equalsIgnoreCase(ma))
                return sptt;
        return null;
    }

}
