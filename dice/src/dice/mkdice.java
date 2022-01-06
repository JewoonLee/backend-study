package dice;
import java.util.Scanner;
class manager{
	
}
class mkdice {
	private final int max=6;
	private int facevalue;
	public mkdice() {
		facevalue=1;
	}
	public int roll() {
		facevalue=(int)(Math.random()*max)+1;
		return facevalue;
	}
	public void setfacevalue(int value) {
		facevalue=value;
	}
	public int getfacevalue() {
		return facevalue;
	}
	public String toString() {
		String result= Integer.toString(facevalue);
		return result;
	}

}
class person{
	String name;
	int win;
	int sum;
	public person(String name){
		win=0;
		this.name=name;
	}
}

public class dice{
	public static void main(String[] args){
		int num=0;
		int game=1;
		mkdice die1=new mkdice();
		mkdice die2=new mkdice();
		System.out.println("���� �������� ���� �Է��Ͻÿ�:(2~6�� ����)");
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		while(num<2 || num>=7) {
			System.out.println("�Է��� �߸��Ǿ����ϴ�. �ٽ� �Է����ֽÿ�.");
		}
		person P[]=new person[num];
		for(int i=0; i<num;i++) {
			System.out.println(i+"��° ������ �̸� �Է�:");
			String name=scanner.next();
			P[i]=new person(name);
			
		}
		System.out.println("***   ���ݺ��� ������ �����մϴ�.   ***");
		while(true) {
			System.out.println("game"+ game);
			game++;
			int rl;
			for(int i=0;i<num;i++) {
				System.out.println(P[i].name+" �����Դϴ�. �ֻ����� �������� 1�� �Է��ϼ���.");
				rl=scanner.nextInt();
				if(rl==1) {
					die1.roll();
					die2.roll();
					P[i].sum=die1.getfacevalue()+die2.getfacevalue();
				}
				System.out.println(P[i].name+": ù��° �ֻ��� "+die1+" �� ��° �ֻ��� "+die2+" �� �ֻ����� ��: "+P[i].sum);
				
			}
			int sum_max=0;
			for(int i=0;i<num;i++) {
				if(sum_max<=P[i].sum) {
					sum_max=P[i].sum;
				}}
			for(int i=0;i<num;i++) {
				if(sum_max==P[i].sum) {
					System.out.println("�̹� ���ڴ� "+P[i].name+"�Դϴ�.");
					P[i].win++;
				}
			}
			System.out.println("������ ��� �Ͻðڽ��ϱ�?:(y/n)");
			String con=scanner.next();
			if(con.equals("y")) {
				continue;
				}
			else {
				break;}
			}
		System.out.println("��ü "+game+"���� ��");
		for(int i=0;i<num;i++) {
			System.out.print(P[i].name+ P[i].win+"��");
			System.out.print('\t');
			System.out.print(" �Ͽ����ϴ�.");
		}
	
	}
}
