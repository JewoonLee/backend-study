package 예제문제;
import java.awt.*;
import javax.swing.*;
public class java extends JFrame {
	public java() {
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container contentPane=getContentPane();
	JLabel jlabel=new JLabel("0",SwingConstants.RIGHT);
	contentPane.add(jlabel,BorderLayout.NORTH);
	
	JPanel jp=new JPanel();
	jp.setLayout(new GridLayout(4,4));
	jp.add(new JButton("1"));
	jp.add(new JButton("2"));
	jp.add(new JButton("3"));
	jp.add(new JButton("+"));
	jp.add(new JButton("4"));
	jp.add(new JButton("5"));
	jp.add(new JButton("6"));
	jp.add(new JButton("-"));
	jp.add(new JButton("7"));
	jp.add(new JButton("8"));
	jp.add(new JButton("9"));
	jp.add(new JButton("*"));
	jp.add(new JButton("0"));
	jp.add(new JButton("C"));
	jp.add(new JButton("="));
	jp.add(new JButton("/"));
	contentPane.add(jp,BorderLayout.CENTER);}
	public static void main(String[] args) {
		new java();}
	}
