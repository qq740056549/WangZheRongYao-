package ������ҫ;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import javax.swing.*;
public class Main {
	private Object test;

	public static void main(String []args) throws Throwable{
		JFrame frame=new JFrame("wangzhe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
	
		JLabel lable=new JLabel();
		frame.add(lable);
		JButton atk=new JButton("attak");
		JButton move=new JButton("move");
		frame.add(atk,BorderLayout.BEFORE_FIRST_LINE);
		frame.add(move,BorderLayout.BEFORE_LINE_BEGINS);
		MouseAdapter listen=new MouseAdapter() {
			
		};
		frame.setVisible(false);
		
		
		
		File file=new File("����.txt");
		BufferedReader fcin=new BufferedReader(new FileReader(file));
		
		
		int n,m; 
		int x,y;
		String action = null; //����ָ��
		Scanner reader=new Scanner(System.in);
		System.out.println("ս����ʼ������");
		Map gameBoard=new Map(10,10); //��ʼ��ս������ͼ��
		gameBoard.showMap(); //��ʼ�������
		gameBoard.setHero(); //��ʼ��Ӣ��
		gameBoard.setMap(); //��Ӣ��������µ���ͼ
		System.out.println("ȫ������");
		gameBoard.showMap(); //Ӣ�۳�ʼ�������
		Thread1 thread1=new Thread1(gameBoard);
		Thread2 thread2=new Thread2(fcin,gameBoard);
		while(fcin.readLine()!=null) {
			thread2.run(action);
			thread1.run();
		}
	}
}


