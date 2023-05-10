package File;


import java.io.*;
import java.util.ArrayList;

public class XuLyFile {

    //ghi file
    public static void ghiFile(ArrayList danhSach, String diaChi){
        File f= new File(diaChi);

        //kiểm tra file có tồn tại hay ko
        if(f.exists()==false){
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Lỗi mở file ");
            }
        }
        FileOutputStream fOut=null;
        ObjectOutputStream oOut=null;
        try{
            fOut=new FileOutputStream(f);
            oOut=new ObjectOutputStream(fOut);
            oOut.writeObject(danhSach);
            System.out.println("Ghi file thành công ! ");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi : "+e.getMessage());
        }finally {
            if(oOut!=null) {
                try {
                    oOut.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file : "+e.getMessage());
                }
            }
            if(fOut!=null){
                try {
                    fOut.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file : "+e.getMessage());
                }
            }

        }
    }


    //đọc file
    public static Object docFile(String diaChi){
        FileInputStream fIn=null;
        ObjectInputStream oIn=null;
        Object docf=null;
        try{
            fIn=new FileInputStream(new File(diaChi));
            oIn=new ObjectInputStream(fIn);
            docf=(Object) oIn.readObject();
            //trả về đối tượng docf
            return docf;
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Lỗi : "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi : "+e.getMessage());
        }finally {
            if(docf!=null)
                System.out.println("Đọc file thành công !");
            else
                System.out.println("Đọc file thất bại !");

            if(oIn!=null) {
                try {
                    oIn.close();
                } catch (IOException e) {
                    System.out.println("Lỗi : "+e.getMessage());
                }
            }

            if(fIn!=null) {
                try {
                    fIn.close();
                } catch (IOException e) {
                    System.out.println("Lỗi : "+e.getMessage());
                }
            }
        }
        return null;
    }
}
