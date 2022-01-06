/* ���� 3�� ���� �߰��� ����:
 �ϴ� ���� ���� class�� �ֻ��� Ŭ����, ��� Ŭ����, ���� Ŭ������ �ִ�.
 �ֻ��� Ŭ�������� �ֻ��� ���� �ʵ尡 �ְ�, �ֻ����� ������ �޼ҵ�, �ֻ������� �־��ִ� �޼ҵ�, �ֻ��� ���� �ٸ� package���� ���ų� �Է����� �� �ִ� �޼ҵ� ������ �ִ�.
 ��� Ŭ�������� �̸�, ��� �̰����, �Ѱ��ӿ� �� �ֻ����� �������� ���� ������ �ʵ尡 �ִ�.
 �̷��� Ŭ������ �����, ���� Ŭ�������� ������ �����ϴµ�, �Ѱ��Ӵ� 2���� �ֻ����� ������, ���� ���� ���� ����� �̱�� ������ ����ȴ�. 
 ���� ���� Ŭ������ ��� Ŭ������ �迭�� �����(2~6�� ����), �ֻ��� 2���� �����Ѵ�. 
 �׸��� �� ���Ӵ� �� ����� 2���� �ֻ����� ���� ���� ���� ����� �� ������ �̱�� �¼��� �ϳ� �÷��ش�. 
 �̷��� �����ڰ� ������ ���⶧���� ������ ����ȴ�.
 */
package RollingDice;
import java.util.Scanner;
class manager{
	
}
class mkdice {// �ֻ����� ����� ��
	private final int max=6; //�ֻ����� 1~6���� �ֱ⶧���� �ִ밪�� 6���� ��
	private int facevalue;// �ֻ����� ��
	public mkdice() {//�ֻ��� ������
		facevalue=1;
	}
	public int roll() {// �ֻ����� ������ �Ϳ� �ش�Ǵ� �޼ҵ�
		facevalue=(int)(Math.random()*max)+1;//random�� �̿��ؼ� ������ �ֻ��� ���� ����
		return facevalue;
	}
	public void setfacevalue(int value) {//facevalue�� private���� �����߱� ������ �ٸ� class�� �ٸ� package���� facevalue�� �������ַ��� �̷��� public �޼ҵ带 ��������
		facevalue=value;
	}
	public int getfacevalue() {//���� �Ȱ��� facevalue�� private�̱⶧���� �ٸ� class�� package���� facevalue�� ���� �ʹٸ� �̷��� publoc�� �̿��ؾ���
		return facevalue;
	}
	public String toString() {// class�� �̸��� �������ָ� facevalue�� ���� string���� ��ȯ�ϰ� return����
		String result= Integer.toString(facevalue);
		return result;
	}

}
class person{//��� class
	String name;//�̸� �ʵ�
	int win;// �ֻ��� ���ӿ��� �̱� ��
	int sum;// �ֻ��� 2���� �������� �� �� �ֻ����� ��
	public person(String name){//��� class ������
		win=0;
		this.name=name;
	}
}

public class RollingDice{
	public static void main(String[] args){
		int num=0;//���� �������� ��
		int game=0;//���� �ϴ� Ƚ��
		mkdice die1=new mkdice();//�ֻ��� 1 ����
		mkdice die2=new mkdice();//�ֻ��� 2 ����
		System.out.println("���� �������� ���� �Է��Ͻÿ�:(2~6�� ����)");
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		while(num<2 || num>=7) {// ���� �����ڴ� 2~6����
			System.out.println("�Է��� �߸��Ǿ����ϴ�. �ٽ� �Է����ֽÿ�.");
			num=scanner.nextInt();
			if(num>=2 || num<=6) break;
		}
		person P[]=new person[num];
		for(int i=0; i<num;i++) {
			System.out.println((i+1)+"��° ������ �̸� �Է�:");//�̸� �Է�
			String name=scanner.next();
			P[i]=new person(name);
			
		}
		System.out.println("***   ���ݺ��� ������ �����մϴ�.   ***");
		while(true) {
			System.out.println("game"+ (game+1));
			int rl;
			game++;
			for(int i=0;i<num;i++) {
				System.out.println(P[i].name+" �����Դϴ�. �ֻ����� �������� 1�� �Է��ϼ���.");
				rl=scanner.nextInt();
				if(rl==1) {
					die1.roll();//�ֻ��� 1 ������
					die2.roll();//�ֻ��� 2 ������
					P[i].sum=die1.getfacevalue()+die2.getfacevalue();// �� �ֻ����� ���Ѱ� P[i].sum�� �־��ֱ�
				}
				System.out.println(P[i].name+": ù��° �ֻ��� "+die1+" �� ��° �ֻ��� "+die2+" �� �ֻ����� ��: "+P[i].sum);
				
			}
			int sum_max=0;//�����ڵ��� �� �ֻ����� ���� �� ū �� ã��
			for(int i=0;i<num;i++) {
				if(sum_max<=P[i].sum) {
					sum_max=P[i].sum;
				}}
			for(int i=0;i<num;i++) {// �������� �̹����� ���� ã��
				if(sum_max==P[i].sum) {
					System.out.println("�̹� ���ڴ� "+P[i].name+"�Դϴ�.");
					P[i].win++;
				}
			}
			System.out.println("������ ��� �Ͻðڽ��ϱ�?:(y/n)");
			String con=scanner.next();
			if(con.equals("y")) {// y������ ���, n������ ���� ����
				continue;
				}
			else {
				break;}
			}
		System.out.println("��ü "+game+"���� ��");
		for(int i=0;i<num;i++) {
			System.out.print(P[i].name+ P[i].win+"��");
			System.out.print('\t');
		}	
		System.out.print(" �Ͽ����ϴ�.");
	}
}
