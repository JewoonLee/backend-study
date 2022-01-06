
public class Arraychange {
	public int getsum(int i,int j) {
		return i+j;
	}
	public int getsum(int i,int j,int k) {
		return i+j+k;
	}
	public double getsum(double i,double j) {
		return i+j;
	}
	public static void main(String args[]) {
		Arraychange a=new Arraychange();
		int i=a.getsum(1,2);
		int j=a.getsum(1,2,3);
		double k=a.getsum(1.1,2.2);
		System.out.print(i+"="+k+"= "+j);
	}
}

