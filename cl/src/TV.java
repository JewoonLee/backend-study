
public class TV{
	String type;
	int year;
	int in;
	public TV(String type,int year,int in) {
		this.type=type;
		this.year=year;
		this.in=in;}
	public void show() {
		System.out.println(type+"���� ���� "+year+"���� "+in+"��ġ TV");
	}
	}