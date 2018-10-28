package 王者荣耀;
import java.util.*;
public class Main {
	public static void main(String []args){
		int n,m; 
		int x,y;
		String action; //操作指令
		Scanner reader=new Scanner(System.in);
		System.out.println("战场初始化如下");
		Map gameBoard=new Map(10,10); //初始化战场（地图）
		gameBoard.showMap(); //初始化后输出
		gameBoard.setHero(); //初始化英雄
		gameBoard.setMap(); //将英雄形象更新到地图
		System.out.println("全军出击");
		gameBoard.showMap(); //英雄初始化后输出
		
		while(reader.hasNext()) {
			action=reader.next();//输入操作
			if(action.equals("move")) {//移动操作
				char form,direction; 
				form=reader.next().charAt(0); //输入进行移动的英雄
				direction=reader.next().charAt(0); //输入移动的方向
				gameBoard.Move(form, direction); //进行移动
				gameBoard.showMap(); //移动后输出
			}
			if(action.equals("attack")) {// 攻击操作
				char attacker,defender;
				attacker=reader.next().charAt(0); //输入攻击英雄
				defender=reader.next().charAt(0); //输入被攻击英雄
				gameBoard.attack(attacker, defender); //攻击操作
				gameBoard.showMap(); 
			}
			if(action.equals("skill")) {//使用技能
				char form;
				form=reader.next().charAt(0); //输入使用技能的英雄
				String skill;
				skill=reader.next(); //使用使用的技能
				gameBoard.useSkill(form, skill); //使用技能
				gameBoard.showMap();
			}
		}
	}
}
