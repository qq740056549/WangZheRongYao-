package ������ҫ;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * 
 * @author �½��� 2017192038
 * ���߳����ڶ�ȡ���� 
 */
class Thread_Opereation extends Thread{
	BufferedReader fcin;
	Map gameBoard;
	Thread_ShowMap thread1;
	public Thread_Opereation(BufferedReader t,Map te,Thread_ShowMap temp) {
		fcin=t;
		gameBoard=te;
		thread1=temp;
	}
	public void run(String action) throws Throwable {
		thread1.stop();
		// TODO Auto-generated method stub
		action=fcin.readLine();
		System.out.print(action+" ");
		if(action.equals("move")) {
			char form,direction; 
			form=fcin.readLine().charAt(0);
			direction=fcin.readLine().charAt(0);
			System.out.println(form+" "+direction);
			/*form=reader.next().charAt(0); //��������ƶ���Ӣ��
			direction=reader.next().charAt(0); //�����ƶ��ķ���*/
			gameBoard.Move(form, direction); //�����ƶ�
			//gameBoard.showMap(); //�ƶ������
		}
		if(action.equals("attack")) {// ��������
			char attacker,defender;
			attacker=fcin.readLine().charAt(0);
			defender=fcin.readLine().charAt(0);
			System.out.println(attacker+" "+defender);
			/*attacker=reader.next().charAt(0); //���빥��Ӣ��
			defender=reader.next().charAt(0); //���뱻����Ӣ��*/
			gameBoard.attack(attacker, defender); //��������
			
			//gameBoard.showMap(); 
		}
		if(action.equals("skill")) {//ʹ�ü���
			char form;
			form=fcin.readLine().charAt(0);
			//form=reader.next().charAt(0); //����ʹ�ü��ܵ�Ӣ��
			String skill;
			//skill=reader.next(); //ʹ��ʹ�õļ���
			skill=fcin.readLine();
			System.out.println(form+" "+skill);
			gameBoard.useSkill(form, skill); //ʹ�ü���
			//gameBoard.showMap();
		}
		//gameBoard.showMap();
		Thread.sleep(3000);
	}

}
