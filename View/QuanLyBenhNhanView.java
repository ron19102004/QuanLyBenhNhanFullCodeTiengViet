package QuanLyBenhNhan.View;

import QuanLyBenhNhan.Controller.DanhSachBenhNhanController;
import QuanLyBenhNhan.Controller.SuaXoaBenhNhanController;
import java.io.IOException;
import java.util.Scanner;

public class QuanLyBenhNhanView {
    private final DanhSachBenhNhanController danhSachBenhNhanController = new DanhSachBenhNhanController();

    public QuanLyBenhNhanView() throws IOException, InterruptedException, ClassNotFoundException {
        this.init();
    }

    public void init() throws  InterruptedException {
        Scanner scan = new Scanner(System.in);

        while(true) {
            this.menu();
            int select = Integer.parseInt(scan.nextLine());
            this.danhSachBenhNhanController.drawLine();
            if (select == 0) {
                this.danhSachBenhNhanController.nhapThongTinBenhNhanVaoFileQuanLyBenhNhan();
                return;
            }

            switch (select) {
                case 1:
                    this.danhSachBenhNhanController.nhapThongTin();
                    break;
                case 2:
                    this.danhSachBenhNhanController.layThongTinBenhNhanTuFileQuanLyBenhNhan();
                    break;
                case 3:
                    if (this.danhSachBenhNhanController.getDanhSachBenhNhan().size() != 0) {
                        this.danhSachBenhNhanController.sapXepTheoTuoiGiam();
                    } else {
                        System.out.println("Danh sách rỗng. Vui lòng thêm bệnh nhân");
                        this.danhSachBenhNhanController.drawLine();
                    }
                    break;
                case 4:
                    if (this.danhSachBenhNhanController.getDanhSachBenhNhan().size() != 0) {
                        this.danhSachBenhNhanController.hienThiBenhNhanDuoiMuoiTuoi();
                    } else {
                        System.out.println("Danh sách rỗng. Vui lòng thêm bệnh nhân");
                        this.danhSachBenhNhanController.drawLine();
                    }
                    break;
                case 5:
                    if (this.danhSachBenhNhanController.getDanhSachBenhNhan().size() != 0) {
                        this.danhSachBenhNhanController.benhNhanCoVienPhiCaoNhat();
                    } else {
                        System.out.println("Danh sách rỗng. Vui lòng thêm bệnh nhân");
                        this.danhSachBenhNhanController.drawLine();
                    }
                    break;
                case 6:
                    if (this.danhSachBenhNhanController.getDanhSachBenhNhan().size() != 0) {
                        this.danhSachBenhNhanController.hienThiTatCaBenhNhan();
                    } else {
                        System.out.println("Danh sách rỗng. Vui lòng thêm bệnh nhân");
                        this.danhSachBenhNhanController.drawLine();
                    }
                    break;
                case 7:
                    if (this.danhSachBenhNhanController.getDanhSachBenhNhan().size() != 0) {
                        new SuaXoaBenhNhanController(this.danhSachBenhNhanController.getDanhSachBenhNhan());
                    } else {
                        System.out.println("Danh sách rỗng. Vui lòng thêm bệnh nhân");
                        this.danhSachBenhNhanController.drawLine();
                    }
                    break;
                default:
                    System.out.println("Sự lựa chọn không hợp lệ. Vui lòng chọn lại");
                    this.danhSachBenhNhanController.drawLine();
            }
        }
    }

    public void menu() {
        System.out.println("Hệ thống quản lý bệnh nhân.");
        if (this.danhSachBenhNhanController.getDanhSachBenhNhan().size() != 0) {
            System.out.println("Hiện tại hệ thống đang quản lý " +
                    this.danhSachBenhNhanController.getDanhSachBenhNhan().size() + " bệnh nhân.\n");
        } else {
            System.out.println("Hiện tại hệ thống chưa quản lý bệnh nhân nào.\n");
        }

        System.out.print("1- Nhập thông tin bệnh nhân." +
                "\n2- Nhập thông tin bệnh nhân từ dữ liệu(file)." +
                "\n3- Sắp xếp các bệnh nhân theo tuổi giảm dần." +
                "\n4- Hiển thị các bênh nhân dưới 10 tuổi." +
                "\n5- Các bệnh nhân có viện phí cao nhất." +
                "\n6- Hiển thị tất cả thông tin bệnh nhân." +
                "\n7- Sửa - xóa bệnh nhân." +
                "\n0- Thoát hệ thống(Thông tin bệnh nhân tự động lưu)." +
                "\n==>Chọn:");
    }
}
