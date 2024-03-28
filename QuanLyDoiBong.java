package DoAn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
			hienThiMenu();
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
			case 7:
				thongKeSoLuongCauThuTheoQuocTich();
				break;
			case 8:
				docTuFile("danhsachcauthu.txt");
				break;
			case 9:
				ghiRaFile("danhsachcauthu.txt");
				break;
			case 10:
				chinhSuaThongTinCauThu();
				break;
			}
		} while (luaChon != 0);
	}

	public static void hienThiMenu() {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║          QUẢN LÝ ĐỘI BÓNG              ║");
		System.out.println("╠══════╦═════════════════════════════════╣");
		System.out.println("║  1.  ║ Thêm cầu thủ mới.               ║");
		System.out.println("║  2.  ║ Hiển thị thông tin cầu thủ.     ║");
		System.out.println("║  3.  ║ Tìm kiếm cầu thủ theo tên.      ║");
		System.out.println("║  4.  ║ Xóa cầu thủ.                    ║");
		System.out.println("║  5.  ║ Sắp xếp cầu thủ theo tuổi.      ║");
		System.out.println("║  6.  ║ Báo cáo tổng số cầu thủ.        ║");
		System.out.println("║  7.  ║ Thống kê cầu thủ theo quốc tịch.║");
		System.out.println("║  8.  ║ Đọc từ file.                    ║");
		System.out.println("║  9.  ║ Ghi ra file.                   ║");
		System.out.println("║ 10.  ║ Chỉnh sửa thông tin cầu thủ.    ║");
		System.out.println("║  0.  ║ Thoát.                          ║");
		System.out.println("╚══════╩═════════════════════════════════╝");
		System.out.print("Lựa chọn của bạn: ");
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
		System.out.println("============ THÔNG TIN CẦU THỦ ===============");
		System.out.println("+--------------------------------------------------------------------+");
		System.out.println("|" + String.format("%-10s", "MÃ CẦU THỦ") + "|" + String.format("%-30s", "TÊN CẦU THỦ")
				+ "|" + String.format("%-5s", "TUỔI") + "|" + String.format("%-10s", "VỊ TRÍ") + "|"
				+ String.format("%-15s", "QUỐC TỊCH") + "|" + String.format("%-10s", "ĐỘI BÓNG") + "|");
		System.out.println("+--------------------------------------------------------------------+");
		for (int i = 0; i < soLuongCauThu; i++) {
			System.out.println("| " + String.format("%-10s", maCauThu[i]) + "|" + String.format("%-30s", tenCauThu[i])
					+ "|" + String.format("%-5d", tuoiCauThu[i]) + "|" + String.format("%-10s", viTri[i]) + "|"
					+ String.format("%-15s", quocTich[i]) + "|" + String.format("%-10s", doiBong[i]) + "|");
		}
		System.out.println("+--------------------------------------------------------------------+");
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
					// Hoán đổi thông tin giữa hai cầu thủ
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

	public static void thongKeSoLuongCauThuTheoQuocTich() {
		int[] demCauThuTheoQuocTich = new int[soLuongCauThu];

		for (int i = 0; i < soLuongCauThu; i++) {
			boolean daTonTaiQuocTich = false;
			for (int j = 0; j < i; j++) {
				if (quocTich[i].equals(quocTich[j])) {
					demCauThuTheoQuocTich[j]++;
					daTonTaiQuocTich = true;
					break;
				}
			}
			if (!daTonTaiQuocTich) {
				demCauThuTheoQuocTich[i] = 1;
			}
		}

		System.out.println("Thống kê số lượng cầu thủ theo quốc tịch:");
		for (int i = 0; i < soLuongCauThu; i++) {
			if (demCauThuTheoQuocTich[i] > 0) {
				System.out.println(quocTich[i] + ": " + demCauThuTheoQuocTich[i]);
			}
		}
	}

	public static void chinhSuaThongTinCauThu() {
		System.out.print("Nhập mã cầu thủ cần chỉnh sửa thông tin: ");
		String maCanChinhSua = scanner.next();
		int viTriChinhSua = -1;
		for (int i = 0; i < soLuongCauThu; i++) {
			if (maCauThu[i].equals(maCanChinhSua)) {
				viTriChinhSua = i;
				break;
			}
		}
		if (viTriChinhSua != -1) {
			System.out.println("Nhập thông tin mới cho cầu thủ:");
			System.out.print("Tên cầu thủ: ");
			tenCauThu[viTriChinhSua] = scanner.next();
			System.out.print("Tuổi: ");
			tuoiCauThu[viTriChinhSua] = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Vị trí: ");
			viTri[viTriChinhSua] = scanner.nextLine();
			System.out.print("Quốc tịch: ");
			quocTich[viTriChinhSua] = scanner.nextLine();
			System.out.print("Đội bóng: ");
			doiBong[viTriChinhSua] = scanner.nextLine();
			System.out.println("Đã chỉnh sửa thông tin của cầu thủ thành công!");
		} else {
			System.out.println("Không tìm thấy cầu thủ có mã " + maCanChinhSua);
		}
	}

	public static void themCauThu(CauThu cauThu) {
		if (soLuongCauThu < MAX_CAUTHU) {
			maCauThu[soLuongCauThu] = cauThu.maCauThu;
			tenCauThu[soLuongCauThu] = cauThu.tenCauThu;
			tuoiCauThu[soLuongCauThu] = cauThu.tuoi;
			viTri[soLuongCauThu] = cauThu.viTri;
			quocTich[soLuongCauThu] = cauThu.quocTich;
			doiBong[soLuongCauThu] = cauThu.doiBong;
			soLuongCauThu++;
			System.out.println("Đã thêm cầu thủ mới vào đội bóng!");
		} else {
			System.out.println("Danh sách cầu thủ đã đầy, không thể thêm mới.");
		}
	}

	static void docTuFile(String file) {
		try {
			Path path = Paths.get(file);
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				String[] cauThuInfo = line.split(",");
				if (cauThuInfo.length == 6) {
					String maCauThu = cauThuInfo[0].trim();
					String tenCauThu = cauThuInfo[1].trim();
					int tuoi = Integer.parseInt(cauThuInfo[2].trim());
					String viTri = cauThuInfo[3].trim();
					String quocTich = cauThuInfo[4].trim();
					String doiBong = cauThuInfo[5].trim();
					CauThu cauThu = new CauThu(maCauThu, tenCauThu, tuoi, viTri, quocTich, doiBong);
					themCauThu(cauThu);
				} else {
					System.out.println("Dòng dữ liệu không hợp lệ: " + line);
				}
			}

			System.out.println("Đọc file thành công.");
		} catch (IOException e) {
			System.out.println("Có lỗi khi đọc file: " + e.getMessage());
		}
	}

	static void ghiRaFile(String file) {
		try {
			Path path = Paths.get(file);
			List<String> lines = new ArrayList<>();
			for (int i = 0; i < soLuongCauThu; i++) {
				String line = maCauThu[i] + "," + tenCauThu[i] + "," + tuoiCauThu[i] + "," + viTri[i] + ","
						+ quocTich[i] + "," + doiBong[i];
				lines.add(line);
			}
			Files.write(path, lines);
			System.out.println("Ghi file thành công.");
		} catch (IOException e) {
			System.out.println("Có lỗi khi ghi file: " + e.getMessage());
		}
	}

	static class CauThu {
		String maCauThu;
		String tenCauThu;
		int tuoi;
		String viTri;
		String quocTich;
		String doiBong;

		public CauThu(String maCauThu, String tenCauThu, int tuoi, String viTri, String quocTich, String doiBong) {
			this.maCauThu = maCauThu;
			this.tenCauThu = tenCauThu;
			this.tuoi = tuoi;
			this.viTri = viTri;
			this.quocTich = quocTich;
			this.doiBong = doiBong;
		}
	}
}