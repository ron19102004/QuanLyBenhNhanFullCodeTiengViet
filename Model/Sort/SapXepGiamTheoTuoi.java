package QuanLyBenhNhan.Model.Sort;

import QuanLyBenhNhan.Model.BenhNhanModel;
import java.util.Comparator;

public class SapXepGiamTheoTuoi implements Comparator<BenhNhanModel> {
    public SapXepGiamTheoTuoi() {
    }

    public int compare(BenhNhanModel o1, BenhNhanModel o2) {
        return o1.getTuoi() > o2.getTuoi() ? -1 : 1;
    }
}