package QuanLyBenhNhan.Controller;

import QuanLyBenhNhan.Model.BenhAnModel;
import QuanLyBenhNhan.Model.BenhNhanModel;
import QuanLyBenhNhan.Model.Sort.SapXepGiamTheoTuoi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachBenhNhanController {
    private final ArrayList<BenhNhanModel> danhSachBenhNhan = new ArrayList();
    private KetNoiFileDanhSachBenhNhanController ketNoiFileDanhSachBenhNhanController;

    public DanhSachBenhNhanController() throws IOException, InterruptedException {
        this.ketNoiFileDanhSachBenhNhanController = new KetNoiFileDanhSachBenhNhanController(this.danhSachBenhNhan);
    }

    public ArrayList<BenhNhanModel> getDanhSachBenhNhan() {
        return this.danhSachBenhNhan;
    }

    public void nhapThongTinBenhNhanVaoFileQuanLyBenhNhan() throws InterruptedException {
        this.ketNoiFileDanhSachBenhNhanController.nhapThongTinBenhNhanVaoFileQuanLyBenhNhan();
        this.ketNoiFileDanhSachBenhNhanController.hieuUngCho("Hoàn tất !!!");
    }

    public void layThongTinBenhNhanTuFileQuanLyBenhNhan() {
        this.ketNoiFileDanhSachBenhNhanController.layThongTinBenhNhanTuFileQuanLyBenhNhan();
    }

    public void nhapThongTin() {
        Scanner scan = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Bạn muốn nhập bao nhiêu bệnh nhân: ");
            String nStr = scan.nextLine();
            if(!nStr.isBlank()&&this.isNumeric(nStr)&&isNotSpecialSymbols(nStr)){
                n = Integer.parseInt(nStr);
                break;
            } else {
                this.drawLine();
                System.out.println("Lỗi nhập số lượng bệnh nhân !!!. Vui lòng nhập lại.");
                this.drawLine();
            }
        }
        this.drawLine();

        for (int i = 0; i < n; ++i) {
            BenhNhanModel benhNhan = new BenhAnModel(this.danhSachBenhNhan);
            this.danhSachBenhNhan.add(benhNhan);
            this.drawLine();
        }
    }
    public void sapXepTheoTuoiGiam() {
        this.danhSachBenhNhan.sort(new SapXepGiamTheoTuoi());
        for(BenhNhanModel benhNhanModel : this.danhSachBenhNhan){
            ((BenhAnModel)benhNhanModel).xuatThongTin();
            this.drawLine();
        }
    }

    public void hienThiBenhNhanDuoiMuoiTuoi() {
        for(BenhNhanModel BNM : this.danhSachBenhNhan){
            if (BNM.getTuoi() <= 10) {
                ((BenhAnModel)BNM).xuatThongTin();
                this.drawLine();
            }
        }
    }

    public void benhNhanCoVienPhiCaoNhat() {
        double max = 0.0;
        for(BenhNhanModel benhNhanModel : this.danhSachBenhNhan){
            if (((BenhAnModel)benhNhanModel).getTienVienPhi() > max) {
                max = ((BenhAnModel)benhNhanModel).getTienVienPhi();
            }
        }
        for(int i = 0; i < this.danhSachBenhNhan.size(); ++i) {
            double tienVienPhiTungBenhNhan = ((BenhAnModel)this.danhSachBenhNhan.get(i)).getTienVienPhi();
            if (tienVienPhiTungBenhNhan == max) {
                ((BenhAnModel)this.danhSachBenhNhan.get(i)).xuatThongTin();
                this.drawLine();
            }
        }

    }

    public void hienThiTatCaBenhNhan() {
       for(BenhNhanModel benhNhanModel : this.danhSachBenhNhan){
            ((BenhAnModel)benhNhanModel).xuatThongTin();
            this.drawLine();
        }
    }

    public void drawLine() {
        for(int i = 0; i <= 50; ++i) {
            System.out.print("-");
        }

        System.out.println("-");
    }
    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public boolean isNotSpecialSymbols(String str) {
        return !str.matches("\\p{Punct}");
    }
}
