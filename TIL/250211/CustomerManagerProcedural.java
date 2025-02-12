import java.util.Scanner;

public class CustomerManagerProcedural {
	public static void main(String[] args) {
		final int MAX_CUSTOMERS = 100;
		String[][] customers = new String[MAX_CUSTOMERS][4];
		int count = 0;
		int index = -1;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n------------------------------------------");
			System.out.println("\n[고객관리프로그램] ver0.1");
			System.out.println("\n고객 정보를 관리하는 프로그램입니다.");
			System.out.println("원하는 메뉴를 입력해주세요.");
			System.out.println("(I) 입력, (P) 이전, (C) 현재, (N) 다음, (U) 수정, (D) 삭제, (Q) 종료");

			String input = sc.next().toUpperCase();

			switch (input) {
				case "I":
					if (count >= MAX_CUSTOMERS) {
						System.out.println("더 이상 고객을 추가할 수 없습니다.");
						break;
					}

					sc.nextLine();
					System.out.print("이름: ");
					customers[count][0] = sc.nextLine();

					System.out.print("성별 (M/F): ");
					String gender = sc.next().toUpperCase();
					while (!gender.equals("M") && !gender.equals("F")) {
						System.out.print("잘못된 입력입니다. 성별을 (M/F)로 입력하세요: ");
						gender = sc.next().toUpperCase();
					}
					customers[count][1] = gender;

					System.out.print("이메일: ");
					String email = sc.next();
					while (!email.contains("@")) {
						System.out.print("잘못된 이메일 형식입니다. '@'가 포함된 이메일을 입력하세요: ");
						email = sc.next();
					}
					customers[count][2] = email;

					System.out.print("출생 연도: ");
					while (!sc.hasNextInt()) {
						System.out.print("출생 연도는 숫자로 입력해주세요: ");
						sc.next();
					}
					customers[count][3] = String.valueOf(sc.nextInt());

					count++;
					index = count - 1;
					System.out.println("고객 정보가 저장되었습니다.");
					break;

				case "P":
					if (index > 0) {
						index--;
						System.out.println("<이전 고객의 정보>");
						System.out.println("이름: " + customers[index][0]);
						System.out.println("성별 (M/F): " + customers[index][1]);
						System.out.println("이메일: " + customers[index][2]);
						System.out.println("출생 연도: " + customers[index][3] + "\n");
					} else {
						System.out.println("이전 고객이 없습니다.");
					}
					break;

				case "C":
					if (index >= 0 && index < count) {
						System.out.println("<현재 고객의 정보>");
						System.out.println("이름: " + customers[index][0]);
						System.out.println("성별 (M/F): " + customers[index][1]);
						System.out.println("이메일: " + customers[index][2]);
						System.out.println("출생 연도: " + customers[index][3] + "\n");
					} else {
						System.out.println("현재 고객이 없습니다.");
					}
					break;

				case "N":
					if (index < count - 1) {
						index++;
						System.out.println("<다음 고객의 정보>");
						System.out.println("이름: " + customers[index][0]);
						System.out.println("성별 (M/F): " + customers[index][1]);
						System.out.println("이메일: " + customers[index][2]);
						System.out.println("출생 연도: " + customers[index][3] + "\n");
					} else {
						System.out.println("다음 고객이 없습니다.");
					}
					break;

				case "U":
					if (index >= 0 && index < count) {
						System.out.println("<현재 고객의 정보>");
						System.out.println("이름: " + customers[index][0]);
						System.out.println("성별 (M/F): " + customers[index][1]);
						System.out.println("이메일: " + customers[index][2]);
						System.out.println("출생 연도: " + customers[index][3] + "\n");

						System.out.println("\n수정하고자 하는 정보가 무엇인가요?\n1. 이름 2. 성별 3. 이메일 4. 출생 연도");
						while (!sc.hasNextInt()) {
							System.out.print("잘못된 입력입니다. 숫자를 입력하세요: ");
							sc.next();
						}
						int update = sc.nextInt();
						sc.nextLine();

						switch (update) {
							case 1:
								System.out.print("새 이름: ");
								customers[index][0] = sc.nextLine();
								break;

							case 2:
								System.out.print("새 성별 (M/F): ");
								String newGender = sc.next().toUpperCase();
								while (!newGender.equals("M") && !newGender.equals("F")) {
									System.out.print("잘못된 입력입니다. 성별을 (M/F)로 입력하세요: ");
									newGender = sc.next().toUpperCase();
								}
								customers[index][1] = newGender;
								break;

							case 3:
								System.out.print("새 이메일: ");
								String newEmail = sc.next();
								while (!newEmail.contains("@")) {
									System.out.print("잘못된 이메일 형식입니다. '@'가 포함된 이메일을 입력하세요: ");
									newEmail = sc.next();
								}
								customers[index][2] = newEmail;
								break;

							case 4:
								System.out.print("새 출생 연도: ");
								while (!sc.hasNextInt()) {
									System.out.print("출생 연도는 숫자로 입력해주세요: ");
									sc.next();
								}
								customers[index][3] = String.valueOf(sc.nextInt());
								break;

							default:
								System.out.println("잘못된 입력입니다.");
						}
						System.out.println("고객 정보가 수정되었습니다.");
					} else {
						System.out.println("수정할 고객 정보가 없습니다.");
					}
					break;

				case "D":
					if (index >= 0 && index < count) {
						System.out.println("<현재 고객의 정보>");
						System.out.println("이름: " + customers[index][0]);
						System.out.println("성별 (M/F): " + customers[index][1]);
						System.out.println("이메일: " + customers[index][2]);
						System.out.println("출생 연도: " + customers[index][3] + "\n");

						System.out.println();
						System.out.println("정말 삭제하시겠습니까? (Y/N)");
						String confirm = sc.next().toUpperCase();
						if (confirm.equals("Y")) {
							for (int i = index; i < count - 1; i++) {
								customers[i] = customers[i + 1];
							}
							customers[count - 1] = new String[4];
							count--;
							if (count == 0) {
								index = -1;
							} else if (index >= count) {
								index = count - 1;
							}
							System.out.println("고객 정보가 삭제되었습니다.");
						} else {
							System.out.println("삭제를 취소했습니다.");
						}
					} else {
						System.out.println("삭제할 고객 정보가 없습니다.");
					}
					break;

				case "Q":
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					System.exit(0);

				default:
					System.out.println("잘못된 메뉴입니다. 다시 입력해주세요.");
			}
		}
	}
}
