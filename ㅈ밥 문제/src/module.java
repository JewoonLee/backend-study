import java.util.Scanner;
public class module {
	public static void main(String args[]) {
		Scanner a=new Scanner(System.in);
		int n;
		int i;
		int j;
		n=a.nextInt();
		if(n>=2) {
			System.out.println(2);
			
		}
		for(i=3;i<n;i++) {
			for(j=2;j<i;j++) {
				
				if(i%j==0) {
					break;
				}
				else {
					continue;
				}
			}
			if(i==j) {
				System.out.println(i);
			}
		}
	}
}
