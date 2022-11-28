package QuanLyBenhNhan.Controller;

import QuanLyBenhNhan.Model.BenhNhanModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class KetNoiFileDanhSachBenhNhanController {
    private File danhSachBN;
    private ObjectOutputStream objectOutputStream;
    private String pathToFileManage;
    private ArrayList<String> pathFileManage;
    private String pathFolder = "\\Assets\\Files";
    private String nameFile = "\\DanhSachBenhNhan.txt";
    private ArrayList<BenhNhanModel> danhSachBenhNhan;

    public KetNoiFileDanhSachBenhNhanController(ArrayList<BenhNhanModel> benhNhanModels) throws IOException, InterruptedException {
        this.danhSachBenhNhan = benhNhanModels;
        this.truyenDuongDanVaoHeThong();
        this.hieuUngCho("Kết nối thành công !!!");
    }

    public void truyenDuongDanVaoHeThong() {
        try {
            File f = new File("DuongDanDanhSachBenhNhan.txt");
            if (!f.exists()) {
                f.createNewFile();
                this.thietLapDuongDanDenDanhSachBenhNhan(f);
            }

            this.pathFileManage = (ArrayList)Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
            for(String url : this.pathFileManage){
                this.pathToFileManage = url;
            }
            File folder = new File(this.pathToFileManage + this.pathFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            this.danhSachBN = new File(this.pathToFileManage + this.pathFolder + this.nameFile);
        } catch (IOException var4) {
            var4.getStackTrace();
        }

    }

    public void thietLapDuongDanDenDanhSachBenhNhan(File f) throws IOException {
        PrintWriter pw = new PrintWriter(f, StandardCharsets.UTF_8);
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập đường dẫn đến package QuanLyBenhNhan (Ví dụ: D:\\JAVA\\QuanLyBenhNhan ): ");
        this.pathToFileManage = scan.nextLine();
        pw.print(this.pathToFileManage);
        pw.flush();
        pw.close();
    }

    public void nhapThongTinBenhNhanVaoFileQuanLyBenhNhan() {
        try {
            if (!this.danhSachBN.exists()) {
                this.danhSachBN.createNewFile();
            }

            if (this.danhSachBenhNhan.size() != 0) {
                try {
                    this.objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.danhSachBN));
                    for(BenhNhanModel benhNhanModel : this.danhSachBenhNhan){
                        this.objectOutputStream.writeObject(benhNhanModel);
                        this.objectOutputStream.flush();
                    }
                    this.objectOutputStream.close();
                } catch (IOException var3) {
                    var3.getStackTrace();
                }
            }
        } catch (IOException var4) {
            var4.getStackTrace();
        }

    }

    public void layThongTinBenhNhanTuFileQuanLyBenhNhan() {
        try {
            if (this.danhSachBN.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.danhSachBN));
                BenhNhanModel benhNhanModel = null;
                this.hieuUngCho("Lấy dữ liệu thành công.");

                while(true) {
                    Object oj = objectInputStream.readObject();
                    if (oj == null) {
                        objectInputStream.close();
                        break;
                    }

                    benhNhanModel = (BenhNhanModel)oj;
                    this.danhSachBenhNhan.add(benhNhanModel);
                }
            } else {
                this.hieuUngCho("Không tìm thấy file nhập.");
            }
        } catch (InterruptedException | IOException var4) {
            var4.getStackTrace();
        } catch (ClassNotFoundException var5) {
            throw new RuntimeException(var5);
        }

    }

    public void hieuUngCho(String result) throws InterruptedException {
        System.out.println("Hệ thống đang kiểm tra . Vui lòng chờ trong giây lát");
        System.out.print("Waiting");

        for(int i = 1; i <= 3; ++i) {
            System.out.print(".");
            Thread.sleep(500L);
        }

        System.out.println(result);
        this.drawLine();
    }

    public void drawLine() {
        for(int i = 0; i <= 50; ++i) {
            System.out.print("-");
        }

        System.out.println("-");
    }
}
