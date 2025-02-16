import java.util.Scanner;

public class CustomerConsole {
	private Scanner sc = new Scanner(System.in);
	private CustomerList list = new CustomerList();
	private int index = -1;

	public void printMenu() {
		System.out.println("\n고객관리프로그램 ver0.1");
		System.out.println("(I) 입력, (P) 이전, (C) 현재, (N) 다음, (U) 수정, (D) 삭제, (Q) 종료");
		System.out.print("메뉴를 입력하세요: ");
	}

	void insert() {
		if (list.getCount() >= CustomerList.MAX_CUSTOMER) {
			System.out.println("저장 공간이 가득 찼습니다.");
			return;
		}

		System.out.print("이름: ");
		String name = sc.next();

		String gender;
		do {
			System.out.print("성별 (F 또는 M): ");
			gender = sc.next().toUpperCase();
			if (!gender.equals("F") && !gender.equals("M")) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		} while (!gender.equals("F") && !gender.equals("M"));

		String email;
		do {
			System.out.print("이메일: ");
			email = sc.next();
			if (!email.contains("@")) {
				System.out.println("잘못된 이메일 형식입니다. '@'가 포함된 이메일을 입력하세요.");
			}
		} while (!email.contains("@"));

		int birthYear;
		do {
			System.out.print("출생 연도: ");
			while (!sc.hasNextInt()) {
				System.out.println("잘못된 출생 연도입니다. 숫자로 입력해주세요.");
				sc.next();
			}
			birthYear = sc.nextInt();
			sc.nextLine();
			if (birthYear <= 0) {
				System.out.println("출생 연도는 0보다 커야 합니다. 다시 입력하세요.");
			}
		} while (birthYear <= 0);

		Customer customer = new Customer(name, gender, email, birthYear);
		list.addCustomer(customer);
		index = list.getCount() - 1;
		System.out.println("고객 정보가 추가되었습니다.");
	}

	void previous() {
		if (index <= 0) {
			System.out.println("이전 정보가 없습니다.");
		} else {
			index--;
			displayCustomer("이전 고객 정보");
		}
	}

	void current() {
		if (list.getCount() == 0 || index == -1) {
			System.out.println("입력된 정보가 없습니다.");
		} else {
			displayCustomer("현재 고객 정보");
		}
	}

	void next() {
		if (index >= list.getCount() - 1) {
			System.out.println("다음 정보가 없습니다.");
		} else {
			index++;
			displayCustomer("다음 고객 정보");
		}
	}

	void update() {
		if (list.getCount() == 0 || index == -1) {
			System.out.println("수정할 정보가 없습니다.");
			return;
		}

		System.out.print("새 이름: ");
		String name = sc.next();

		String gender;
		do {
			System.out.print("새 성별 (F 또는 M): ");
			gender = sc.next().toUpperCase();
			if (!gender.equals("F") && !gender.equals("M")) {
				System.out.println("잘못된 입력입니다. F 또는 M만 입력 가능합니다.");
			}
		} while (!gender.equals("F") && !gender.equals("M"));

		String email;
		do {
			System.out.print("새 이메일: ");
			email = sc.next();
			if (!email.contains("@")) {
				System.out.println("잘못된 이메일 형식입니다. '@'가 포함된 이메일을 입력하세요.");
			}
		} while (!email.contains("@"));

		int birthYear;
		do {
			System.out.print("새 출생 연도: ");
			while (!sc.hasNextInt()) {
				System.out.println("잘못된 출생 연도입니다. 숫자로 입력해주세요.");
				sc.next();
			}
			birthYear = sc.nextInt();
			sc.nextLine();
			if (birthYear <= 0) {
				System.out.println("출생 연도는 0보다 커야 합니다. 다시 입력하세요.");
			}
		} while (birthYear <= 0);

		Customer customer = new Customer(name, gender, email, birthYear);
		list.updateCustomer(index, customer);
		System.out.println("고객 정보가 수정되었습니다.");

	}

	void delete() {
		if (list.getCount() == 0 || index == -1) {
			System.out.println("삭제할 정보가 없습니다.");
			return;
		}

		list.deleteCustomer(index);
		if (list.getCount() == 0) {
			index = -1;
		} else if (index >= list.getCount()) {
			index = list.getCount() - 1;
		}
		System.out.println("삭제되었습니다.");
	}

	private void displayCustomer(String title) {
		if (index < 0 || index >= list.getCount()) {
			System.out.println("출력할 고객 정보가 없습니다.");
			return;
		}

		Customer customer = list.getCustomer(index);
		System.out.println(title);
		System.out.println("이름: " + customer.getName());
		System.out.println("성별: " + customer.getGender());
		System.out.println("이메일: " + customer.getEmail());
		System.out.println("출생 연도: " + customer.getBirthYear());
	}
}
