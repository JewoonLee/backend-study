package lastdance;

class Shape{
	public Shape next;
	public Shape() {
		next=null;
	}
	public void paint() {
		System.out.println("Shape");
	}
}
class Line extends Shape{
	public void paint() {
		System.out.println("Line");
	}
}
class Rect extends Shape{
	public void paint() {
		System.out.println("Rect");
	}
}
public class allaplus {
	static void p(Shape a) {
		a.paint();
	}
	static void main(String [] args) {
		Shape sh=new Shape();
		p(sh);
		p(new Line());
		p(new Rect());
		
	}
}
