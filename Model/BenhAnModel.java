package QuanLyBenhNhan.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class BenhAnModel extends BenhNhanModel {
    private String tenBenhAn;
    private double tienVienPhi;

    public BenhAnModel(ArrayList<BenhNhanModel> benhNhanModels) {
        this.nhapThongTin(benhNhanModels);
    }

    public void nhapThongTin(ArrayList<BenhNhanModel> benhNhanModels) {
        super.nhapThongTin(benhNhanModels);
        System.out.print("Nhập tên bệnh án: ");
        this.setTenBenhAn();
        System.out.print("Nhập số tiền viện phí: ");
        this.setTienVienPhi();
    }

    public void xuatThongTin() {
        super.xuatThongTin();
        String var10001 = this.tenBenhAn;
        System.out.println("Tên bệnh án: " + var10001 + "\nViện phí: " + this.tienVienPhi + "\nThời gian thay đổi gần nhất: " + super.getThoiGianThayThoiThongTin());
    }

    public String getTenBenhAn() {
        return this.tenBenhAn;
    }

    public void setTenBenhAn() {
        Scanner scan = new Scanner(System.in);

        while(true) {
            String tenBenhAn = scan.nextLine();
            if (!tenBenhAn.isBlank() && super.isNotSpecialSymbols(tenBenhAn) && !super.isNumeric(tenBenhAn)) {
                this.tenBenhAn = tenBenhAn;
                return;
            }

            System.out.println("Tên bệnh án không chứa kí tự đặc biệt hoặc số. Vui lòng nhập lại");
            System.out.print("Nhập tên bệnh án: ");
        }
    }

    public double getTienVienPhi() {
        return this.tienVienPhi;
    }

    public void setTienVienPhi() {
        Scanner scan = new Scanner(System.in);

        while(true) {
            String tienVienPhi = scan.nextLine();
            if (!tienVienPhi.isBlank() && super.isNotSpecialSymbols(tienVienPhi) && super.isNumeric(tienVienPhi)) {
                this.tienVienPhi = Double.parseDouble(tienVienPhi);
                return;
            }

            System.out.println("Số tiền không thể kí tự hoặc chử. Vui lòng nhập lại");
            System.out.print("Nhập số tiền viện phí: ");
        }
    }
}
