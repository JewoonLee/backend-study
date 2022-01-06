/* 과제 3에 대한 추가적 설명:
 일단 내가 만든 class는 주사위 클레스, 사람 클레스, 메인 클레스가 있다.
 주사위 클레스에는 주사위 면의 필드가 있고, 주사위를 굴리는 메소드, 주사위면을 넣어주는 메소드, 주사위 면을 다른 package에서 갖거나 입력해줄 수 있는 메소드 정도가 있다.
 사람 클레스에는 이름, 몇번 이겼는지, 한게임에 두 주사위를 굴렸을때 합을 가지는 필드가 있다.
 이렇게 클레스를 만들고, 메인 클레스에는 게임을 진행하는데, 한게임당 2번씩 주사위를 굴리고, 그중 합이 높은 사람이 이기는 게임이 진행된다. 
 먼제 메인 클레스에 사람 클레스의 배열을 만들고(2~6명 사이), 주사위 2개를 생성한다. 
 그리고 한 게임당 한 사람이 2번의 주사위를 굴려 합이 높은 사람이 그 게임을 이기고 승수를 하나 올려준다. 
 이렇게 진행자가 게임을 멈출때까지 게임은 진행된다.
 */
package RollingDice;
import java.util.Scanner;
class manager{
	
}
class mkdice {// 주사위를 만드는 것
	private final int max=6; //주사위는 1~6까지 있기때문에 최대값을 6으로 둠
	private int facevalue;// 주사위의 면
	public mkdice() {//주사의 생성자
		facevalue=1;
	}
	public int roll() {// 주사위를 굴리는 것에 해당되는 메소드
		facevalue=(int)(Math.random()*max)+1;//random을 이용해서 임의의 주사위 값을 받음
		return facevalue;
	}
	public void setfacevalue(int value) {//facevalue가 private으로 선언했기 때문에 다른 class나 다른 package에서 facevalue를 선언해주려면 이렇게 public 메소드를 만들어야함
		facevalue=value;
	}
	public int getfacevalue() {//위랑 똑같이 facevalue가 private이기때문에 다른 class나 package에서 facevalue를 쓰고 싶다면 이렇게 publoc을 이용해야함
		return facevalue;
	}
	public String toString() {// class의 이름을 선언해주면 facevalue의 값을 string으로 변환하고 return해줌
		String result= Integer.toString(facevalue);
		return result;
	}

}
class person{//사람 class
	String name;//이름 필드
	int win;// 주사위 게임에서 이긴 수
	int sum;// 주사위 2개를 굴렸을때 그 두 주사위의 합
	public person(String name){//사람 class 생성자
		win=0;
		this.name=name;
	}
}

public class RollingDice{
	public static void main(String[] args){
		int num=0;//게임 참여자의 수
		int game=0;//게임 하는 횟수
		mkdice die1=new mkdice();//주사위 1 생성
		mkdice die2=new mkdice();//주사위 2 생성
		System.out.println("게임 참가자의 수를 입력하시오:(2~6명 사이)");
		Scanner scanner=new Scanner(System.in);
		num=scanner.nextInt();
		while(num<2 || num>=7) {// 게임 참가자는 2~6사이
			System.out.println("입력이 잘못되었습니다. 다시 입력해주시요.");
			num=scanner.nextInt();
			if(num>=2 || num<=6) break;
		}
		person P[]=new person[num];
		for(int i=0; i<num;i++) {
			System.out.println((i+1)+"번째 참가자 이름 입력:");//이름 입력
			String name=scanner.next();
			P[i]=new person(name);
			
		}
		System.out.println("***   지금부터 게임을 시작합니다.   ***");
		while(true) {
			System.out.println("game"+ (game+1));
			int rl;
			game++;
			for(int i=0;i<num;i++) {
				System.out.println(P[i].name+" 차례입니다. 주사위를 던지려면 1을 입력하세요.");
				rl=scanner.nextInt();
				if(rl==1) {
					die1.roll();//주사위 1 굴리기
					die2.roll();//주사위 2 굴리기
					P[i].sum=die1.getfacevalue()+die2.getfacevalue();// 두 주사위의 더한값 P[i].sum에 넣어주기
				}
				System.out.println(P[i].name+": 첫번째 주사위 "+die1+" 두 번째 주사위 "+die2+" 두 주사위의 합: "+P[i].sum);
				
			}
			int sum_max=0;//참여자들중 두 주사위의 합이 젤 큰 수 찾기
			for(int i=0;i<num;i++) {
				if(sum_max<=P[i].sum) {
					sum_max=P[i].sum;
				}}
			for(int i=0;i<num;i++) {// 참여자중 이번게임 승자 찾기
				if(sum_max==P[i].sum) {
					System.out.println("이번 승자는 "+P[i].name+"입니다.");
					P[i].win++;
				}
			}
			System.out.println("게임을 계속 하시겠습니까?:(y/n)");
			String con=scanner.next();
			if(con.equals("y")) {// y나오면 계속, n나오면 게임 중지
				continue;
				}
			else {
				break;}
			}
		System.out.println("전체 "+game+"게임 중");
		for(int i=0;i<num;i++) {
			System.out.print(P[i].name+ P[i].win+"승");
			System.out.print('\t');
		}	
		System.out.print(" 하였습니다.");
	}
}
