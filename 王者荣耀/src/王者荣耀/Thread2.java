package 王者荣耀;

import java.io.BufferedReader;
import java.io.IOException;

class Thread2 implements Runnable{
	BufferedReader fcin;
	Map gameBoard;
	//Thread1 thread1;
	public Thread2(BufferedReader t,Map te) {
		fcin=t;
		gameBoard=te;
		//thread1=temp;
	}
	public void run(String action) throws Throwable {
		// TODO Auto-generated method stub
		action=fcin.readLine();
		System.out.print(action+" ");
		if(action.equals("move")) {//移动操作
			char form,direction; 
			form=fcin.readLine().charAt(0);
			direction=fcin.readLine().charAt(0);
			System.out.println(form+" "+direction);
			/*form=reader.next().charAt(0); //输入进行移动的英雄
			direction=reader.next().charAt(0); //输入移动的方向*/
			gameBoard.Move(form, direction); //进行移动
			//gameBoard.showMap(); //移动后输出
		}
		if(action.equals("attack")) {// 攻击操作
			char attacker,defender;
			attacker=fcin.readLine().charAt(0);
			defender=fcin.readLine().charAt(0);
			System.out.println(attacker+" "+defender);
			/*attacker=reader.next().charAt(0); //输入攻击英雄
			defender=reader.next().charAt(0); //输入被攻击英雄*/
			gameBoard.attack(attacker, defender); //攻击操作
			
			//gameBoard.showMap(); 
		}
		if(action.equals("skill")) {//使用技能
			char form;
			form=fcin.readLine().charAt(0);
			//form=reader.next().charAt(0); //输入使用技能的英雄
			String skill;
			//skill=reader.next(); //使用使用的技能
			skill=fcin.readLine();
			System.out.println(form+" "+skill);
			gameBoard.useSkill(form, skill); //使用技能
			//gameBoard.showMap();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
