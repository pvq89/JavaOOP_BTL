package bangluong;

import File.XuLyFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyBangLuong {
    ArrayList<BangLuong> dsBangLuong =new ArrayList<>();

    //1.nhập
    public void nhapBangLuong(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng bảng lương cần tạo : ");
        int soLuong=sc.nextInt();
        BangLuong bl;
        for(int i=0; i<soLuong; i++){
            System.out.println("Nhập bảng lương thứ "+(i+1));
            bl =new BangLuong();
            bl.nhapBangLuong();
            dsBangLuong.add(bl);
        }
    }

    //2.hiện
    public void hienBangLuong(){
        for(BangLuong bl :dsBangLuong )
            bl.hienBangLuong();
    }

    //3.Sắp xếp theo lương
    public void sapXepLuong(){
        Comparator sx= new Comparator<BangLuong>() {
            @Override
            public int compare(BangLuong o1, BangLuong o2) {
                return (int) (o1.getThanhTien()-o2.getThanhTien());
            }
        };
        Collections.sort(dsBangLuong,sx);
        hienBangLuong();
    }

    //4.Tính tổng lương phải trả
    public void tinhTongLuongTra(){
        double tongLuong=0;
        for(BangLuong bl : dsBangLuong) {
            System.out.println("Bảng lương  : "+bl.getMaLuong() +"\n"+"Thành tiền : "+bl.getThanhTien() );
            tongLuong += bl.getThanhTien();
        }
        System.out.println("Tổng lương phải trả : "+tongLuong);
    }

    //5. Tìm bảng lương theo mã
    public void timKiemBangLuongTheoMa(){
        System.out.println("Nhập mã bảng lương : ");
        String ma=new Scanner(System.in).nextLine();
        for(BangLuong bl : dsBangLuong)
            if(bl.getMaLuong().equalsIgnoreCase(ma))
                bl.hienBangLuong();
    }

    //6.Xoá 1 bảng lương
    public void xoaBangLuongTheoMa(){
        System.out.println("Nhập mã bảng lương cần xoá : ");
        String ma = new Scanner(System.in).nextLine();
        BangLuong bl;
        for(int i=0; i<dsBangLuong.size(); i++){
            bl=dsBangLuong.get(i);
            if(bl.getMaLuong().equalsIgnoreCase(ma))
                dsBangLuong.remove(bl);
        }
        System.out.println("Danh sách sau khi xoá : ");
        hienBangLuong();
    }

    //7.Thêm 1 bảng lương vào vị trí
    public void themBangLuong(){
        int vt;
        do{
            System.out.println("Nhập vị trí cần thêm bảng lương : ");
            vt = new Scanner(System.in).nextInt();
            BangLuong bl = new BangLuong();
            bl.nhapBangLuong();
            dsBangLuong.add(vt-1,bl);
        }
        while (vt<0 || vt>dsBangLuong.size()+1);
    }

    //8. Sửa bảng lương
    public void suaBangLuong(){
        System.out.println("Nhập mã bảng lương cần sửa : ");
        String maBL=new Scanner(System.in).nextLine();
        BangLuong bl;
        for(int i=0; i<dsBangLuong.size(); i++){
            bl=dsBangLuong.get(i);
            if(bl.getMaLuong().equalsIgnoreCase(maBL)) {
                bl.nhapBangLuong();
            }

        }
        System.out.println("Danh sách sau khi sửa : ");
        hienBangLuong();
    }

    //9. Ghi file
    public void ghifileBangLuong(){
        XuLyFile xlFile=new XuLyFile();
        xlFile.ghiFile(dsBangLuong,"dsbangluong.txt");
    }
    //10. Đọc file
    public void docFileBangLuong(){
        XuLyFile xlFile = new XuLyFile();
        this.dsBangLuong=(ArrayList<BangLuong>) xlFile.docFile("dsbangluong.txt");
    }


}
