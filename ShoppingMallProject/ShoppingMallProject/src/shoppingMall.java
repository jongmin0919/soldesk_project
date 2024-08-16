
class Product{
	private String model;
	private int price;
	public Product() {}
	public Product(String model, int price) {
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public int getPrice() {
		return price;
	}
}
class Tv extends Product{
	public Tv(String model, int price) {
		super(model, price);
	}
}
class Computer extends Product{
	public Computer(String model, int price) {
		super(model, price);
	}
}
class Customer{
	private int money;			// üũ ī�� ����
	private int startMoney;		// �ʱ� �ݾ�
	private int numOfProduct; 	// �ε���
	private Product[] cart;		// ��ٱ���(Tv, Computer ��ü�� ��� �뵵)
	
	public Customer() {}
	public Customer(int money) {
		this.money = money;
		this.startMoney = money;
		cart = new Product[10];
	}
	public void buy(Product product) {
		// ���� �� �ܾ׺��� ���� �ݾ��� �� ũ�� ���� ����
		if(money < product.getPrice()) {
			System.out.println("���� �ݾ��� �����մϴ�.");
			return;
		}
		
		money -= product.getPrice();
		cart[numOfProduct] = product;	// ���� ����Ʈ�� �迭�� ����
		numOfProduct++;
	}
	public void output() {
//		���Ż�ǰ, �ݾ�/ó�� ���� �ݾ�/�� ���� �ݾ�/���� �ݾ� ���
		
		// 1. ���� ��ǰ : ��, ����
		for (int i = 0; i < numOfProduct; i++) {
			System.out.println("���� ��ǰ : " +
							cart[i].getModel() + "," + 
							cart[i].getPrice());
		}
		
		// 2. ó�� ���� �ݾ�
		System.out.println("ó�� ���� �ݾ� : " + startMoney);
		
		// 3. �� ���� �ݾ�
		System.out.println("�� ���� �ݾ� : " + (startMoney - money));
		
		// 4. ���� �ݾ�
		System.out.println("���� �ݾ� : " + money);
		
		
	}
	
}

public class shoppingMall {
	public static void main(String[] args) {
			
			Customer user = new Customer(10000);
			
			user.buy(new Tv("�Ｚ TV", 2000));
			user.buy(new Computer("LG Com", 3000));
			
			user.output();
		}
}
