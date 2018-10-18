package 王者荣耀;
import java.util.*;
public class Main {
	public static void main(String []args){
		int n,m;
		int x,y;
		String action;
		Scanner reader=new Scanner(System.in);
		System.out.println("请输入战场规模：");
		n=reader.nextInt();
		m=reader.nextInt();
		Map gameBoard=new Map(n,m);
		gameBoard.showMap();
		gameBoard.setHero();
		gameBoard.setMap();
		System.out.println("全军出击");
		gameBoard.showMap();
		
		while(reader.hasNext()) {
			action=reader.next();
			if(action.equals("move")) {
				char form,direction;
				form=reader.next().charAt(0);
				direction=reader.next().charAt(0);
				gameBoard.Move(form, direction);
				gameBoard.showMap();
			}
			if(action.equals("attack")) {
				char attacker,defender;
				attacker=reader.next().charAt(0);
				defender=reader.next().charAt(0);
				gameBoard.attack(attacker, defender);
				gameBoard.showMap();
			}
			if(action.equals("skill")) {
				char form;
				form=reader.next().charAt(0);
				String skill;
				skill=reader.next();
				gameBoard.useSkill(form, skill);
				gameBoard.showMap();
			}
		}
	}
}
