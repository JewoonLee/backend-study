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
		System.out.println("게임 참가자의 수를 입력하시오:(2~6명 사이)");
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		while(num<2 || num>=7) {
			System.out.println("입력이 잘못되었습니다. 다시 입력해주시요.");
		}
		person P[]=new person[num];
		for(int i=0; i<num;i++) {
			System.out.println(i+"번째 참가자 이름 입력:");
			String name=scanner.next();
			P[i]=new person(name);
			
		}
		System.out.println("***   지금부터 게임을 시작합니다.   ***");
		while(true) {
			System.out.println("game"+ game);
			game++;
			int rl;
			for(int i=0;i<num;i++) {
				System.out.println(P[i].name+" 차례입니다. 주사위를 던지려면 1을 입력하세요.");
				rl=scanner.nextInt();
				if(rl==1) {
					die1.roll();
					die2.roll();
					P[i].sum=die1.getfacevalue()+die2.getfacevalue();
				}
				System.out.println(P[i].name+": 첫번째 주사위 "+die1+" 두 번째 주사위 "+die2+" 두 주사위의 합: "+P[i].sum);
				
			}
			int sum_max=0;
			for(int i=0;i<num;i++) {
				if(sum_max<=P[i].sum) {
					sum_max=P[i].sum;
				}}
			for(int i=0;i<num;i++) {
				if(sum_max==P[i].sum) {
					System.out.println("이번 승자는 "+P[i].name+"입니다.");
					P[i].win++;
				}
			}
			System.out.println("게임을 계속 하시겠습니까?:(y/n)");
			String con=scanner.next();
			if(con.equals("y")) {
				continue;
				}
			else {
				break;}
			}
		System.out.println("전체 "+game+"게임 중");
		for(int i=0;i<num;i++) {
			System.out.print(P[i].name+ P[i].win+"승");
			System.out.print('\t');
			System.out.print(" 하였습니다.");
		}
	
	}
}
