package QuanLyBenhNhan.Controller;

import QuanLyBenhNhan.Model.BenhAnModel;
import QuanLyBenhNhan.Model.BenhNhanModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class SuaXoaBenhNhanController {
    private ArrayList<BenhNhanModel> benhNhanModels;

    public SuaXoaBenhNhanController(ArrayList<BenhNhanModel> benhNhanModels) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        this.benhNhanModels = benhNhanModels;
        System.out.println("Tất cả các thông tin về ID và Tên bệnh nhân hiện có trong hệ thống.");
        this.drawLine();
        this.hienThiTatCaIDVaTenBenhNhan();
        System.out.print("Nhập ID bệnh nhân muốn thay đổi(Nhập ID = 0 để thoát chức năng): ");
        int id = Integer.parseInt(scan.nextLine().trim());
        if(id != 0) {
            this.suaThongTinTheoID(id);
        } else {
            this.drawLine();
        }
    }

    public void suaThongTinTheoID(int ID) {
        try {
            for (BenhNhanModel benhNhanModel : this.benhNhanModels) {
                if (ID == benhNhanModel.getIdBenhNhan()) {
                    this.suaThongTinBenhNhan(benhNhanModel);
                }
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
    public void suaThongTinBenhNhan(BenhNhanModel benhNhanModel) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        while(true) {
            this.hienThiThongTinMotBenhNhan(benhNhanModel);
            this.menu();
            int select = Integer.parseInt(scan.nextLine());
            if (select == 0) {
                this.drawLine();
                this.hieuUngCho("Hoàn tất các thay đổi !!!");
                break;
            }

            if (select == 5) {
                this.xoaBenhNhan(benhNhanModel);
                break;
            }

            switch (select) {
                case 1:
                    this.suaTenBenhNhan(benhNhanModel);
                    break;
                case 2:
                    this.suaQueQuanBenhNhan(benhNhanModel);
                    break;
                case 3:
                    this.suaTenBenhAn(benhNhanModel);
                    break;
                case 4:
                    this.suaTienVienPhi(benhNhanModel);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại");
            }

            benhNhanModel.setThoiGianThayThoiThongTin(benhNhanModel.getThoiGianHienTai());
        }

    }

    public void keDongDuoiBang(){
        for(int i = 0;i<19;i++) {
            System.out.format("%1s-", "");
        }
        System.out.format("%1s-%n", "");
    }
    public void hienThiTatCaIDVaTenBenhNhan() throws InterruptedException {
        System.out.format("%10s|","ID");
        System.out.format("%20s|%n","Tên");
        this.keDongDuoiBang();
        for(BenhNhanModel benhNhanModel : this.benhNhanModels){
            benhNhanModel.getIDVaTen();
            Thread.sleep(300L);
        }
        this.keDongDuoiBang();
    }

    public void suaTenBenhNhan(BenhNhanModel benhNhanModel) {
        System.out.println("Tên bệnh nhân hiện tại là: " + benhNhanModel.getHoTen());
        System.out.print("Bạn muốn đổi tên bệnh nhân thành: ");
        benhNhanModel.setHoTen();
    }

    public void suaQueQuanBenhNhan(BenhNhanModel benhNhanModel) {
        System.out.println("Quê quán bệnh nhân hiện tại là: " + benhNhanModel.getQueQuan());
        System.out.print("Bạn muốn đổi quê quán bệnh nhân thành: ");
        benhNhanModel.setQueQuan();
    }

    public void suaTenBenhAn(BenhNhanModel benhNhanModel) {
        System.out.println("Tên bệnh án hiện tại là: " + ((BenhAnModel)benhNhanModel).getTenBenhAn());
        System.out.print("Bạn muốn đổi tên bệnh án thành: ");
        ((BenhAnModel)benhNhanModel).setTenBenhAn();
    }

    public void suaTienVienPhi(BenhNhanModel benhNhanModel) {
        System.out.println("Tiền viện phí hiện tại là: " + ((BenhAnModel)benhNhanModel).getTienVienPhi());
        System.out.print("Bạn muốn đổi tên bệnh án thành: ");
        ((BenhAnModel)benhNhanModel).setTienVienPhi();
    }

    public void hienThiThongTinMotBenhNhan(BenhNhanModel benhNhanModel) {
        System.out.println("Thông tin của bệnh nhân.");
        this.drawLine();
        ((BenhAnModel)benhNhanModel).xuatThongTin();
        this.drawLine();
    }

    public void xoaBenhNhan(BenhNhanModel benhNhanModel) {
        try {
            this.benhNhanModels.remove(benhNhanModel);
            this.drawLine();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void menu() {
        System.out.println("Hệ thống có các chức năng sửa - xóa như sau");
        System.out.print("1- Sửa tên\n2- Sửa quê quán\n3- Tên bệnh án\n4- Tiền viện phí\n5- Xóa bệnh nhân\n0- Thoát hệ thống.\n=>Chọn: ");
    }

    public void drawLine() {
        for(int i = 0; i <= 50; ++i) {
            System.out.print("-");
        }

        System.out.println("-");
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
}
