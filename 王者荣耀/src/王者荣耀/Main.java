package 王者荣耀;
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
		
		
		
		File file=new File("操作.txt");
		BufferedReader fcin=new BufferedReader(new FileReader(file));
		
		
		int n,m; 
		int x,y;
		String action = null; //操作指令
		Scanner reader=new Scanner(System.in);
		System.out.println("战场初始化如下");
		Map gameBoard=new Map(10,10); //初始化战场（地图）
		gameBoard.showMap(); //初始化后输出
		gameBoard.setHero(); //初始化英雄
		gameBoard.setMap(); //将英雄形象更新到地图
		System.out.println("全军出击");
		gameBoard.showMap(); //英雄初始化后输出
		Thread1 thread1=new Thread1(gameBoard);
		Thread2 thread2=new Thread2(fcin,gameBoard);
		while(fcin.readLine()!=null) {
			thread2.run(action);
			thread1.run();
		}
	}
}


