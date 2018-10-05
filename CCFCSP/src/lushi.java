import java.util.*;
/**
 * 
 * @author 陈建荣 2017192038
 * @version  2018-09 (4.9.0)
 */
public class lushi {
	public static void main(String []argd) {
		Player man[];
		man=new Player[2];
		man[0]=new Player();
		man[1]=new Player();
		Scanner reader=new Scanner(System.in);
		
		int n,position,attack,health;
		int now=0,next=1,winner=0;
		int attackPosition,defendPosition;
		String action;
		
		n=reader.nextInt();
		
		for(int j=0;j<n;j++) {
			action=reader.next();
			//System.out.println(action);
			if(action.equals("summon")) {
				position=reader.nextInt();
				attack=reader.nextInt();
				health=reader.nextInt();
				man[now].summon(position, attack, health);
				//System.out.println("man["+now+"]  "+man[now].followNum);
			}
			else if(action.equals("attack")) {
				attackPosition=reader.nextInt();
				defendPosition=reader.nextInt();
				man[now].master[attackPosition-1].attack(man[next],defendPosition);
				if(man[now].master[attackPosition-1].health<=0) {
					man[now].followDie(attackPosition);
				}
				if(defendPosition!=0) {
					if(man[next].master[defendPosition-1].health<=0) {
						man[next].followDie(defendPosition);
				}
				}
				else {
					if(man[next].health<=0) {
					if(now==0) {
						winner=1;
					}
					else {
						winner=-1;
					}
						
				}
			}
				}
				
			else if(action.equals("end")){
				int temp=now;
				now=next;
				next=temp;
				if(winner!=0)
				break;
			}
			
		}
		
		System.out.println(winner);
		System.out.println(man[0].health);
		if(man[0].followNum==0) {
			System.out.println(0);
		}
		else {
			System.out.print(man[0].followNum+" ");
			for(int i=0;i<7;i++) {
			if(man[0].master[i].health!=0) {
				System.out.print(man[0].master[i].health);
				man[0].followNum--;
				if(man[0].followNum!=0) {
					System.out.print(" ");
				}
			}
		}
			System.out.println();
		}
	
		System.out.println(man[1].health);
		if(man[1].followNum==0) {
			System.out.print(0);
		}
		else {
			System.out.print(man[1].followNum+" ");
			for(int i=0;i<7;i++) {
			if(man[1].master[i].health!=0) {
				System.out.print(man[1].master[i].health);
				man[1].followNum--;
				if(man[1].followNum!=0)
					System.out.print(" ");
			}
			if(man[1].followNum==0) {
				break;
			}
		}
		}
	}
}
/**
 * 随从类
 */
class Follow{
	int health,attack,position;
	/**
	 * 随从缺省构造函数
	 */
	Follow(){
		health=0;
		attack=0;
		position=0;
	}
	/**
	 * 重置随从属性
	 */
	public void reSet() {
		health=0;
		attack=0;
		position=0;
	}
	/**
	 * 随从构造函数
	 * 召唤随从会调用该方法
	 * @param p 随从编号
	 * @param a	随从攻击力
	 * @param h 随从生命值
	 */
	Follow(int p,int a,int h){
		position=p;
		attack=a;
		health=h;
	}
	/**
	 * 随从攻击方法
	 * @param t 玩家
	 * @param defendPosition 被攻击的位置（0-7）
	 */
	public void attack(Player t,int defendPosition) {
		if(defendPosition!=0) {
			t.master[defendPosition-1].health-=attack;
			health-=t.master[defendPosition-1].attack;		
		}
		else {
			t.health-=attack;
		}
	}
}
/**
 * 玩家类
 * 内含一个随从数组	
 */
class Player{
	int health,attack;
	int followNum;
	Follow master[];
	/**
	 * 玩家类缺省构造函数
	 */
	Player(){
		health=30;
		attack=0;
		followNum=0;
		master=new Follow[7];
		for(int i=0;i<7;i++) {
			master[i]=new Follow();
					}
	}
	/**
	 * 随从召唤方法
	 * 会调用随从类中的随从构造函数Follow()
	 * @param p	随从编号
	 * @param a	随从攻击力
	 * @param h	随从生命值
	 */
	public void summon(int p,int a,int h) {
		followNum++;
		for(int i=5;i>=p-1;i--) {
			if(master[i].position!=0) {
				master[i].position++;
			}
			master[i+1].attack=master[i].attack;
			master[i+1].health=master[i].health;
			master[i+1].position=master[i].position;
		}
		master[p-1].reSet();
		master[p-1].position=p;
		master[p-1].attack=a;
		master[p-1].health=h;
	}
	/**
	 * 随从死亡方法
	 * 若有随从死亡，则在其右边的随从编号减一
	 * 会调用reSet（）
	 * @param diePosition 死亡随从的编号
	 */
	public void followDie(int diePosition) {
			followNum--;
		for(int i=diePosition;i<7;i++) {
			if(master[i].position!=0) {
				master[i].position--;
			}
			master[i-1].attack=master[i].attack;
			master[i-1].health=master[i].health;
			master[i-1].position=master[i].position;
		}
		master[6].reSet();
	}
}