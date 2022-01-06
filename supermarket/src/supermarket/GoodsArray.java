package supermarket;
import java.util.Scanner;
class Goods {
	private String name;//이름
	private int price;//가격
	private int numberOfStock;// 재고량
	private int sold;// 판 개수

	Goods(String name, int price, int numberOfStock) {
		this.name = name;
		this.price = price;
		this.numberOfStock = numberOfStock;
		this.sold = 0;
	}
	public void ChangeNumberOfStock(int a) {
		this.numberOfStock+=a;
	}
	public void addsold() {
		this.sold++;
	}

	String getName() {return name;} 
	int getPrice() {return price;}
	int getNumberOfStock() {return numberOfStock;}
	int getSold() {return sold;}
	void soldzero() {this.sold=0;}
}

public class GoodsArray {

	public static void main(String[] args) {
		Goods [] goodsArray;
        Scanner s = new Scanner(System.in);
        System.out.print("슈퍼에서 취급하는 상품의 개수를 입력하시오.>>> ");
		int gd=s.nextInt();// 상품의 개수
		
		goodsArray = new Goods [gd];
		for(int i=0; i<goodsArray.length; i++) {
			System.out.print((i+1)+"번째 상품의 이름, 가격, 재고량을 입력하시오>>>");
			String name = s.next();
			int price = s.nextInt();
			int n = s.nextInt();
			goodsArray[i] = new Goods(name, price, n);
			System.out.println();
		}
		
	while(true) {
		int type;// 편의점 물건의 종류
		int sellprice=0;//판매 총액
		int goodstype;
		
		System.out.println("1)판매	2)구매	3)조회	4)종료");
		System.out.print(">>>");
		type=s.nextInt();
		
		if(type==1) {//판매하는 경우
			sellprice=0;
			while(true) {
				for(int i=0;i<goodsArray.length;i++) {goodsArray[i].soldzero();}
				for(int i=0;i<goodsArray.length;i++) {
					System.out.print((i+1)+")"+goodsArray[i].getName()+"\t");
				}
				System.out.println((goodsArray.length+1)+")계산");
				System.out.print(">>>");
				goodstype=s.nextInt();
				if(goodstype==(goodsArray.length+1)) {
					System.out.println("판매 가격 총액:"+sellprice);
					System.out.print("받은 금액을 입력하시오>>>");
					int getprice=s.nextInt();//받은 돈 입력
					System.out.println("###	영수증	###");
					System.out.println("==============================");
					for(int i=0;i<goodsArray.length;i++) {
						if(goodsArray[i].getSold()!=0) {
							System.out.println(goodsArray[i].getName()+"	"+goodsArray[i].getPrice()+"X"+goodsArray[i].getSold()+"	"+sellprice);
						}
					}
					System.out.println("==============================");
					System.out.println("총액		"+sellprice);
					System.out.println("받은 금액		"+getprice);
					System.out.println("==============================");
					System.out.println("거스름돈		"+(getprice-sellprice));
					break;
				}
				else {
					goodsArray[(goodstype-1)].addsold();
					goodsArray[(goodstype-1)].ChangeNumberOfStock(-1);
					sellprice+=(goodsArray[(goodstype-1)].getPrice()*goodsArray[(goodstype-1)].getSold());// 총금액 계산
					continue;
			}
		}
	}
		else if(type==2) {// 구매하는 경우
			int gdstype;// 상품 구매 종류
			while(true) {
				for(int i=0;i<goodsArray.length;i++) {
					System.out.print((i+1)+")"+goodsArray[i].getName()+"	");
				}
				System.out.println((goodsArray.length+1)+") 구매 종료");
				System.out.print(">>>");
				gdstype=s.nextInt();
				if(gdstype!=goodsArray.length+1) {
					int gdstypenum;
					System.out.print("구매 수량을 입력하시오>>>");
					gdstypenum=s.nextInt();
					goodsArray[(gdstype-1)].ChangeNumberOfStock(gdstypenum);
					System.out.println("##"+goodsArray[(gdstype-1)].getName()+"의 재고량이 "+goodsArray[(gdstype-1)].getNumberOfStock()+"으로 증가함");
					continue;
				}
				else {break;}
				}
			
		}
		else if(type==3) {// 조회
			System.out.println("###	상품명 재고량	###");
			System.out.println("==============================");
			for(int i=0;i<goodsArray.length;i++) {
				System.out.println(goodsArray[i].getName()+"	"+goodsArray[i].getNumberOfStock());
			}
			System.out.println("==============================");
		}
		else{// 종료
			
			break;
		}
	}
}
	}


