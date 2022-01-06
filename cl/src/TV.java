
public class TV{
	String type;
	int year;
	int in;
	public TV(String type,int year,int in) {
		this.type=type;
		this.year=year;
		this.in=in;}
	public void show() {
		System.out.println(type+"에서 만든 "+year+"년형 "+in+"인치 TV");
	}
	}