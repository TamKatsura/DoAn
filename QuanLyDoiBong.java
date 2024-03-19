package DoAn;

import java.util.Scanner;

public class QuanLyDoiBong {
	public static final int MAX_CAUTHU = 100;
	public static String[] maCauThu = new String[MAX_CAUTHU];
	public static String[] tenCauThu = new String[MAX_CAUTHU];
	public static int[] tuoiCauThu = new int[MAX_CAUTHU];
	public static String[] viTri = new String[MAX_CAUTHU];
	public static String[] quocTich = new String[MAX_CAUTHU];
	public static String[] doiBong = new String[MAX_CAUTHU];
	public static int soLuongCauThu = 0;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int luaChon;
		do {
			System.out.println("===== QUẢN LÝ ĐỘI BÓNG =====");
			System.out.println("1. Thêm cầu thủ mới.");
			System.out.println("2. Hiển thị thông tin cầu thủ.");
			System.out.println("3. Tìm kiếm cầu thủ theo tên.");
			System.out.println("4. Xóa cầu thủ.");
			System.out.println("5. Sắp xếp cầu thủ theo tuổi.");
			System.out.println("6. Báo cáo tổng số cầu thủ.");
			System.out.println("0. Thoát.");
			System.out.print("Lựa chọn của bạn: ");
			luaChon = scanner.nextInt();
			switch (luaChon) {
			case 1:
				themCauThu();
				break;
			case 2:
				hienThiThongTinCauThu();
				break;
			case 3:
				timKiemCauThuTheoTen();
				break;
			case 4:
				xoaCauThu();
				break;
			case 5:
				sapXepCauThuTheoTuoi();
				break;
			case 6:
				baoCaoTongSoCauThu();
				break;
			}
		} while (luaChon != 0);
	}

	public static void themCauThu() {
	    System.out.println("Nhập thông tin cầu thủ mới:");
	    System.out.print("Mã cầu thủ: ");
	    maCauThu[soLuongCauThu] = scanner.next();
	    System.out.print("Tên cầu thủ: ");
	    tenCauThu[soLuongCauThu] = scanner.next();
	    System.out.print("Tuổi: ");
	    tuoiCauThu[soLuongCauThu] = scanner.nextInt();
	    scanner.nextLine(); 
	    System.out.print("Vị trí: ");
	    viTri[soLuongCauThu] = scanner.nextLine(); 
	    System.out.print("Quốc tịch: "); 
	    quocTich[soLuongCauThu] = scanner.nextLine();
	    System.out.print("Đội bóng: "); 
	    doiBong[soLuongCauThu] = scanner.nextLine();
	    soLuongCauThu++;
	    System.out.println("Đã thêm cầu thủ mới vào đội bóng!");
	}

	public static void hienThiThongTinCauThu() {
		System.out.println("Thông tin cầu thủ trong đội bóng:");
		for (int i = 0; i < soLuongCauThu; i++) {
			System.out.println("Mã cầu thủ: " + maCauThu[i]);
			System.out.println("Tên cầu thủ: " + tenCauThu[i]);
			System.out.println("Tuổi: " + tuoiCauThu[i]);
			System.out.println("Vị trí: " + viTri[i]);
			System.out.println("Quốc tịch: " + quocTich[i]);
			System.out.println("Đội bóng: " + doiBong[i]);
		}
	}

	public static void timKiemCauThuTheoTen() {
		System.out.print("Tìm kiếm cầu thủ theo tên: ");
		String tenCanTim = scanner.next();
		boolean timThay = false;
		for (int i = 0; i < soLuongCauThu; i++) {
			if (tenCauThu[i].equals(tenCanTim)) {
				System.out.println("Thông tin cầu thủ có tên " + tenCanTim + ":");
				System.out.println("Mã cầu thủ: " + maCauThu[i]);
				System.out.println("Tuổi: " + tuoiCauThu[i]);
				System.out.println("Vị trí: " + viTri[i]);
				System.out.println("Quốc tịch: " + quocTich[i]);
				System.out.println("Đội bóng: " + doiBong[i]);
				timThay = true;
			}
		}
		if (!timThay) {
			System.out.println("Không tìm thấy cầu thủ có tên " + tenCanTim);
		}
	}

	public static void xoaCauThu() {
		System.out.print("Nhập mã cầu thủ cần xóa: ");
		String maCanXoa = scanner.next();
		int viTriXoa = -1;
		for (int i = 0; i < soLuongCauThu; i++) {
			if (maCauThu[i].equals(maCanXoa)) {
				viTriXoa = i;
				break;
			}
		}
		if (viTriXoa != -1) {
			for (int i = viTriXoa; i < soLuongCauThu - 1; i++) {
				maCauThu[i] = maCauThu[i + 1];
				tenCauThu[i] = tenCauThu[i + 1];
				tuoiCauThu[i] = tuoiCauThu[i + 1];
				viTri[i] = viTri[i + 1];
				quocTich[i] = quocTich[i + 1];
				doiBong[i] = doiBong[i + 1];
			}
			soLuongCauThu--;
			System.out.println("Đã xóa cầu thủ thành công!");
		} else {
			System.out.println("Không tìm thấy cầu thủ có mã " + maCanXoa);
		}
	}

	public static void sapXepCauThuTheoTuoi() {
		for (int i = 0; i < soLuongCauThu - 1; i++) {
			for (int j = 0; j < soLuongCauThu - i - 1; j++) {
				if (tuoiCauThu[j] > tuoiCauThu[j + 1]) {
					// Hoán đổi thông tin của cầu thủ
					String tempMaCauThu = maCauThu[j];
					maCauThu[j] = maCauThu[j + 1];
					maCauThu[j + 1] = tempMaCauThu;

					String tempTenCauThu = tenCauThu[j];
					tenCauThu[j] = tenCauThu[j + 1];
					tenCauThu[j + 1] = tempTenCauThu;

					int tempTuoiCauThu = tuoiCauThu[j];
					tuoiCauThu[j] = tuoiCauThu[j + 1];
					tuoiCauThu[j + 1] = tempTuoiCauThu;

					String tempViTri = viTri[j];
					viTri[j] = viTri[j + 1];
					viTri[j + 1] = tempViTri;

					String tempQuocTich = quocTich[j];
					quocTich[j] = quocTich[j + 1];
					quocTich[j + 1] = tempQuocTich;

					String tempDoiBong = doiBong[j];
					doiBong[j] = doiBong[j + 1];
					doiBong[j + 1] = tempDoiBong;
				}
			}
		}

		System.out.println("Danh sách cầu thủ đã được sắp xếp theo tuổi từ bé đến lớn:");
		for (int i = 0; i < soLuongCauThu; i++) {
			System.out.println("Mã cầu thủ: " + maCauThu[i]);
			System.out.println("Tên cầu thủ: " + tenCauThu[i]);
			System.out.println("Tuổi: " + tuoiCauThu[i]);
			System.out.println("Vị trí: " + viTri[i]);
			System.out.println("Quốc tịch: " + quocTich[i]);
			System.out.println("Đội bóng: " + doiBong[i]);
		}
		System.out.println("Đã sắp xếp cầu thủ theo tuổi!");
	}

	public static void baoCaoTongSoCauThu() {
		System.out.println("Tổng số cầu thủ trong đội bóng: " + soLuongCauThu);
	}
}
