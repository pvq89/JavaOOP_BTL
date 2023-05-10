package NhanVien;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConNguoi implements Serializable {
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private String gioiTinh;
    private int soDT;

    //hàm tạo
    public ConNguoi(){
    }

    //nhập
    public void nhapThongTin() throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập họ tên : ");
        this.hoTen=sc.nextLine();
        System.out.println("Nhập ngày sinh (dd/mm/yyyy) : ");
        String s=sc.nextLine();
        this.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(s);
        System.out.println("Nhập địa chỉ : ");
        this.diaChi=sc.nextLine();
        System.out.println("Nhập giới tính :");
        this.gioiTinh=sc.nextLine();
        System.out.println("Nhập SĐT : ");
        this.soDT=sc.nextInt();
    }

    //hiện
    @Override
    public String toString() {
        return String.format("%-20s %-35s %-15s %-15s %-15d",this.hoTen,this.ngaySinh,this.diaChi
        ,this.gioiTinh,this.soDT);
    }

    //set,get
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getSoDT() {
        return soDT;
    }
    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }


}
