package ������ҫ;
import java.util.*;
public class Main {
	public static void main(String []args){
		int n,m; 
		int x,y;
		String action; //����ָ��
		Scanner reader=new Scanner(System.in);
		System.out.println("ս����ʼ������");
		Map gameBoard=new Map(10,10); //��ʼ��ս������ͼ��
		gameBoard.showMap(); //��ʼ�������
		gameBoard.setHero(); //��ʼ��Ӣ��
		gameBoard.setMap(); //��Ӣ��������µ���ͼ
		System.out.println("ȫ������");
		gameBoard.showMap(); //Ӣ�۳�ʼ�������
		
		while(reader.hasNext()) {
			action=reader.next();//�������
			if(action.equals("move")) {//�ƶ�����
				char form,direction; 
				form=reader.next().charAt(0); //��������ƶ���Ӣ��
				direction=reader.next().charAt(0); //�����ƶ��ķ���
				gameBoard.Move(form, direction); //�����ƶ�
				gameBoard.showMap(); //�ƶ������
			}
			if(action.equals("attack")) {// ��������
				char attacker,defender;
				attacker=reader.next().charAt(0); //���빥��Ӣ��
				defender=reader.next().charAt(0); //���뱻����Ӣ��
				gameBoard.attack(attacker, defender); //��������
				gameBoard.showMap(); 
			}
			if(action.equals("skill")) {//ʹ�ü���
				char form;
				form=reader.next().charAt(0); //����ʹ�ü��ܵ�Ӣ��
				String skill;
				skill=reader.next(); //ʹ��ʹ�õļ���
				gameBoard.useSkill(form, skill); //ʹ�ü���
				gameBoard.showMap();
			}
		}
	}
}
