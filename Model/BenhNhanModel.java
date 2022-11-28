package QuanLyBenhNhan.Model;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class BenhNhanModel implements Serializable {
    private String hoTen;
    private String queQuan;
    private int namSinh;
    private int idBenhNhan;
    private String thoiGianThayThoiThongTin;

    public BenhNhanModel() {
    }

    public void nhapThongTin(ArrayList<BenhNhanModel> benhNhanModels) {
        this.setThoiGianThayThoiThongTin(this.getThoiGianHienTai());
        System.out.print("Nhập tên bệnh nhân: ");
        this.setHoTen();
        this.setIdBenhNhan(benhNhanModels);
        System.out.println("ID bệnh nhân: " + this.idBenhNhan);
        System.out.print("Nhập quê quán: ");
        this.setQueQuan();
        System.out.print("Nhập năm sinh: ");
        this.setNamSinh();
    }

    public void xuatThongTin() {
        String var10001 = this.hoTen;
        System.out.println("Tên bệnh nhân: " + var10001 + "\nID: " + this.idBenhNhan + "\nQuê quán: " + this.queQuan + "\nTuổi: " + this.getTuoi());
    }

    public int getIdBenhNhan() {
        return this.idBenhNhan;
    }

    public void setIdBenhNhan(ArrayList<BenhNhanModel> benhNhanModels) {
        boolean check;
        int id;
        do {
            check = false;
            id = (int)Math.floor(Math.random() * 899999.0 + 100000.0);
            for(BenhNhanModel benhNhanModel : benhNhanModels) {
                if (id == benhNhanModel.getIdBenhNhan()) {
                    check = true;
                    break;
                }
            }
        } while(check);
        this.idBenhNhan = id;
    }

    public int getTuoi() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) - this.namSinh;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen() {
        Scanner scan = new Scanner(System.in);

        while(true) {
            String hoTen = scan.nextLine();
            if (!hoTen.isBlank() && this.isNotSpecialSymbols(hoTen) && !this.isNumeric(hoTen)) {
                this.hoTen = hoTen;
                return;
            }

            System.out.println("Họ tên không chứa kí tự đặc biệt hoặc số. Vui lòng nhập lại");
            System.out.print("Nhập tên bệnh nhân: ");
        }
    }

    public String getQueQuan() {
        return this.queQuan;
    }

    public void setQueQuan() {
        Scanner scan = new Scanner(System.in);

        while(true) {
            String queQuan = scan.nextLine();
            if (!queQuan.isBlank() && this.isNotSpecialSymbols(queQuan) && !this.isNumeric(queQuan)) {
                this.queQuan = queQuan;
                return;
            }

            System.out.println("Quê quán không chứa kí tự đặc biệt hoặc số. Vui lòng nhập lại");
            System.out.print("Nhập quê quán: ");
        }
    }

    public int getNamSinh() {
        return this.namSinh;
    }

    public void setNamSinh() {
        Scanner scan = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        int namSinh = Integer.parseInt(scan.nextLine());
        if (calendar.get(Calendar.YEAR) - namSinh < 0) {
            System.out.println("Năm sinh không hợp lệ vui lòng nhập lại.");
            System.out.print("Nhập năm sinh: ");
            namSinh = Integer.parseInt(scan.nextLine());
            if (calendar.get(Calendar.YEAR) - namSinh < 0) {
                System.out.println("Năm sinh không hợp lệ. Hệ thống mặc định năm sinh bằng năm ngoái" +
                        " :" + (calendar.get(Calendar.YEAR) - 1));
                this.namSinh = calendar.get(Calendar.YEAR) - 1;
            } else {
                this.namSinh = namSinh;
            }
        }

    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean isNotSpecialSymbols(String str) {
        return !str.matches("\\p{Punct}");
    }

    public void setThoiGianThayThoiThongTin(String thoiGianThayThoiThongTin) {
        this.thoiGianThayThoiThongTin = thoiGianThayThoiThongTin;
    }

    public String getThoiGianThayThoiThongTin() {
        return this.thoiGianThayThoiThongTin;
    }

    public String getThoiGianHienTai() {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        return today + "-" + time;
    }

    public void getIDVaTen() {
        System.out.format("%10s|", this.getIdBenhNhan());
        System.out.format("%20s|%n",this.getHoTen());
    }
}
