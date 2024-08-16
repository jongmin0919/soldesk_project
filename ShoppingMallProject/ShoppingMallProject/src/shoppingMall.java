
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
	private int money;			// 체크 카드 개념
	private int startMoney;		// 초기 금액
	private int numOfProduct; 	// 인덱스
	private Product[] cart;		// 장바구니(Tv, Computer 객체를 담는 용도)
	
	public Customer() {}
	public Customer(int money) {
		this.money = money;
		this.startMoney = money;
		cart = new Product[10];
	}
	public void buy(Product product) {
		// 현재 내 잔액보다 구매 금액이 더 크면 구매 실패
		if(money < product.getPrice()) {
			System.out.println("소지 금액이 부족합니다.");
			return;
		}
		
		money -= product.getPrice();
		cart[numOfProduct] = product;	// 물건 리스트를 배열에 저장
		numOfProduct++;
	}
	public void output() {
//		구매상품, 금액/처음 소지 금액/총 구매 금액/남은 금액 출력
		
		// 1. 구매 상품 : 모델, 가격
		for (int i = 0; i < numOfProduct; i++) {
			System.out.println("구매 상품 : " +
							cart[i].getModel() + "," + 
							cart[i].getPrice());
		}
		
		// 2. 처음 소지 금액
		System.out.println("처음 소지 금액 : " + startMoney);
		
		// 3. 총 구매 금액
		System.out.println("총 구매 금액 : " + (startMoney - money));
		
		// 4. 남은 금액
		System.out.println("남은 금액 : " + money);
		
		
	}
	
}

public class shoppingMall {
	public static void main(String[] args) {
			
			Customer user = new Customer(10000);
			
			user.buy(new Tv("삼성 TV", 2000));
			user.buy(new Computer("LG Com", 3000));
			
			user.output();
		}
}
