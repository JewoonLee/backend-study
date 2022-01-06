package cl;
import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {

		cl[] c;
		c=new cl[5];
		for(int i=0;i<c.length;i++) {
			c[i]=new cl(i);
	}
		for(int j=0;j<c.length;j++) {
			System.out.print((int)c[j].getArea()+" ");
	}}}



