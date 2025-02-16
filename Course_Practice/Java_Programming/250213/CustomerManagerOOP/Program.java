import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomerConsole console = new CustomerConsole();
		boolean running = true;

		while (running) {
			console.printMenu();
			String menu = scan.next().toUpperCase();

			switch (menu) {
				case "I":
					console.insert();
					break;
				case "P":
					console.previous();
					break;
				case "C":
					console.current();
					break;
				case "N":
					console.next();
					break;
				case "U":
					console.update();
					break;
				case "D":
					console.delete();
					break;
				case "Q":
					System.out.println("프로그램을 종료합니다.");
					scan.close();
					System.exit(0);
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
					break;
			}
		}
	}
}
