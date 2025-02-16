public class CustomerList {
	public static final int MAX_CUSTOMER = 50;
	private Customer[] customers;
	private int count;

	public CustomerList() {
		customers = new Customer[MAX_CUSTOMER];
		count = 0;
	}

	public void addCustomer(Customer customer) {
		if (count >= MAX_CUSTOMER) {
			System.out.println("저장 공간이 가득 찼습니다.");
			return;
		}
		customers[count++] = customer;
	}

	public Customer getCustomer(int index) {
		if (index >= 0 && index < count)
			return customers[index];
		return null;
	}

	public void updateCustomer(int index, Customer customer) {
		if (index >= 0 && index < count) {
			customers[index] = customer;
		}
	}

	public void deleteCustomer(int index) {
		if (index >= 0 && index < count) {
			for (int i = index; i < count - 1; i++) {
				customers[i] = customers[i + 1];
			}
			customers[count - 1] = null;
			count--;
		}
	}

	public int getCount() {
		return count;
	}
}
