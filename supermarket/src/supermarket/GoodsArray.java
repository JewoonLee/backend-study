package supermarket;
import java.util.Scanner;
class Goods {
	private String name;//�̸�
	private int price;//����
	private int numberOfStock;// ���
	private int sold;// �� ����

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
        System.out.print("���ۿ��� ����ϴ� ��ǰ�� ������ �Է��Ͻÿ�.>>> ");
		int gd=s.nextInt();// ��ǰ�� ����
		
		goodsArray = new Goods [gd];
		for(int i=0; i<goodsArray.length; i++) {
			System.out.print((i+1)+"��° ��ǰ�� �̸�, ����, ����� �Է��Ͻÿ�>>>");
			String name = s.next();
			int price = s.nextInt();
			int n = s.nextInt();
			goodsArray[i] = new Goods(name, price, n);
			System.out.println();
		}
		
	while(true) {
		int type;// ������ ������ ����
		int sellprice=0;//�Ǹ� �Ѿ�
		int goodstype;
		
		System.out.println("1)�Ǹ�	2)����	3)��ȸ	4)����");
		System.out.print(">>>");
		type=s.nextInt();
		
		if(type==1) {//�Ǹ��ϴ� ���
			sellprice=0;
			while(true) {
				for(int i=0;i<goodsArray.length;i++) {goodsArray[i].soldzero();}
				for(int i=0;i<goodsArray.length;i++) {
					System.out.print((i+1)+")"+goodsArray[i].getName()+"\t");
				}
				System.out.println((goodsArray.length+1)+")���");
				System.out.print(">>>");
				goodstype=s.nextInt();
				if(goodstype==(goodsArray.length+1)) {
					System.out.println("�Ǹ� ���� �Ѿ�:"+sellprice);
					System.out.print("���� �ݾ��� �Է��Ͻÿ�>>>");
					int getprice=s.nextInt();//���� �� �Է�
					System.out.println("###	������	###");
					System.out.println("==============================");
					for(int i=0;i<goodsArray.length;i++) {
						if(goodsArray[i].getSold()!=0) {
							System.out.println(goodsArray[i].getName()+"	"+goodsArray[i].getPrice()+"X"+goodsArray[i].getSold()+"	"+sellprice);
						}
					}
					System.out.println("==============================");
					System.out.println("�Ѿ�		"+sellprice);
					System.out.println("���� �ݾ�		"+getprice);
					System.out.println("==============================");
					System.out.println("�Ž�����		"+(getprice-sellprice));
					break;
				}
				else {
					goodsArray[(goodstype-1)].addsold();
					goodsArray[(goodstype-1)].ChangeNumberOfStock(-1);
					sellprice+=(goodsArray[(goodstype-1)].getPrice()*goodsArray[(goodstype-1)].getSold());// �ѱݾ� ���
					continue;
			}
		}
	}
		else if(type==2) {// �����ϴ� ���
			int gdstype;// ��ǰ ���� ����
			while(true) {
				for(int i=0;i<goodsArray.length;i++) {
					System.out.print((i+1)+")"+goodsArray[i].getName()+"	");
				}
				System.out.println((goodsArray.length+1)+") ���� ����");
				System.out.print(">>>");
				gdstype=s.nextInt();
				if(gdstype!=goodsArray.length+1) {
					int gdstypenum;
					System.out.print("���� ������ �Է��Ͻÿ�>>>");
					gdstypenum=s.nextInt();
					goodsArray[(gdstype-1)].ChangeNumberOfStock(gdstypenum);
					System.out.println("##"+goodsArray[(gdstype-1)].getName()+"�� ����� "+goodsArray[(gdstype-1)].getNumberOfStock()+"���� ������");
					continue;
				}
				else {break;}
				}
			
		}
		else if(type==3) {// ��ȸ
			System.out.println("###	��ǰ�� ���	###");
			System.out.println("==============================");
			for(int i=0;i<goodsArray.length;i++) {
				System.out.println(goodsArray[i].getName()+"	"+goodsArray[i].getNumberOfStock());
			}
			System.out.println("==============================");
		}
		else{// ����
			
			break;
		}
	}
}
	}


