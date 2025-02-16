import java.util.Scanner;

public class CustomerManagerStructured {
	private static final int MAX_CUSTOMER = 50;
	private static String[] name = new String[MAX_CUSTOMER];
	private static String[] gender = new String[MAX_CUSTOMER];
	private static String[] email = new String[MAX_CUSTOMER];
	private static int[] birthyear = new int[MAX_CUSTOMER];
	private static int index = -1;
	private static int count = 0;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n고객관리프로그램 ver0.1");
			System.out.println("(I) 입력, (P) 이전, (C) 현재, (N) 다음, (U) 수정, (D) 삭제, (Q) 종료");
			System.out.print("메뉴를 입력하세요: ");

			String menu = sc.next().toUpperCase();

			switch (menu) {
				case "I":
					insert();
					break;
				case "P":
					previous();
					break;
				case "C":
					current();
					break;
				case "N":
					next();
					break;
				case "U":
					update();
					break;
				case "D":
					delete();
					break;
				case "Q":
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
					break;
			}
		}
	}

	private static void insert() {
		if (count >= MAX_CUSTOMER) {
			System.out.println("저장 공간이 가득 찼습니다.");
			return;
		}
		index++;
		System.out.print("이름: ");
		name[index] = sc.next();

		String g;
		do {
			System.out.print("성별 (F 또는 M): ");
			g = sc.next().toUpperCase();
			if (!g.equals("F") && !g.equals("M")) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		} while (!g.equals("F") && !g.equals("M"));
		gender[index] = g;

		String em;
		do {
			System.out.print("이메일: ");
			em = sc.next();
			if (!em.contains("@")) {
				System.out.println("잘못된 이메일 형식입니다. '@'가 포함된 이메일을 입력하세요.");
			}
		} while (!em.contains("@"));
		email[index] = em;

		System.out.print("출생 연도: ");
		while (!sc.hasNextInt()) {
			System.out.print("출생 연도는 숫자로 입력해주세요: ");
			sc.next();
		}
		birthyear[index] = sc.nextInt();
		count++;
	}

	private static void previous() {
		if (index <= 0) {
			System.out.println("이전 정보가 없습니다.");
		} else {
			index--;
			displayCustomer("이전 고객 정보");
		}
	}

	private static void current() {
		if (count == 0 || index == -1) {
			System.out.println("입력된 정보가 없습니다.");
		} else {
			displayCustomer("현재 고객 정보");
		}
	}

	private static void next() {
		if (index >= count - 1) {
			System.out.println("다음 정보가 없습니다.");
		} else {
			index++;
			displayCustomer("다음 고객 정보");
		}
	}

	private static void update() {
		if (count == 0 || index == -1) {
			System.out.println("수정할 정보가 없습니다.");
			return;
		}
		System.out.print("새 이름: ");
		name[index] = sc.next();

		String g;
		do {
			System.out.print("새 성별 (F 또는 M): ");
			g = sc.next().toUpperCase();
			if (!g.equals("F") && !g.equals("M")) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		} while (!g.equals("F") && !g.equals("M"));
		gender[index] = g;

		String em;
		do {
			System.out.print("새 이메일: ");
			em = sc.next();
			if (!em.contains("@")) {
				System.out.println("잘못된 이메일 형식입니다. '@'가 포함된 이메일을 입력하세요.");
			}
		} while (!em.contains("@"));
		email[index] = em;

		System.out.print("새 출생 연도: ");
		while (!sc.hasNextInt()) {
			System.out.print("출생 연도는 숫자로 입력해주세요: ");
			sc.next();
		}
		birthyear[index] = sc.nextInt();
	}

	private static void delete() {
		if (count == 0 || index == -1) {
			System.out.println("삭제할 정보가 없습니다.");
			return;
		}
		for (int i = index; i < count - 1; i++) {
			name[i] = name[i + 1];
			gender[i] = gender[i + 1];
			email[i] = email[i + 1];
			birthyear[i] = birthyear[i + 1];
		}
		name[count - 1] = null;
		gender[count - 1] = null;
		email[count - 1] = null;
		birthyear[count - 1] = 0;
		count--;
		if (index >= count) {
			index = count - 1;
		}
		System.out.println("삭제되었습니다.");
	}

	private static void displayCustomer(String title) {
		System.out.println(title);
		System.out.println("이름: " + name[index]);
		System.out.println("성별: " + gender[index]);
		System.out.println("이메일: " + email[index]);
		System.out.println("출생 연도: " + birthyear[index]);
	}
}
