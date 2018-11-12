package 王者荣耀;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Text;
/**
 * 
 * @author 陈建荣 2017192038
 * @version 王者4.0
 */
class Map implements Operation{
	
	private static Logger logger = Logger.getLogger(Map.class);
	public char map[][];
	private int n,m;
	private int HeroNum;
	private Hero hero[];
	private Master master[];
	/**
	 * 地图初始化，地图用‘.’来表示，障碍物用‘|’和‘—’来表示，野怪则是用‘&’，‘@’等符号来表示
	 * @param n 地图矩阵的行数
	 * @param m 地图矩阵的列数
	 */
	public Map(int n,int m){	
		n=10;
		m=10;
		this.n=n;
		this.m=m;
		map=new char[n][m];
		/**
		 * 地图初始化
		 */
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]='.';
		/**
		 * 障碍物初始化
		 */
		map[1][1]='|';
		map[5][1]='|';
		map[3][5]='|';
		map[5][4]='|';
		map[6][6]='|';
		map[7][3]='|';
		map[1][4]='—';
		map[2][2]='—';
		map[4][3]='—';
		map[7][2]='—';
		map[7][5]='—';
		/**
		 * 野怪初始化
		 */
		map[0][1]='&'; 
		map[2][2]='$';
		map[7][4]='^';
		map[4][8]='#';
		map[9][9]='@';
		int k=0;
		master=new Master[5];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++) {
				if(map[i][j]!='.'&&map[i][j]!='|'&&map[i][j]!='—') {
					//master[k].setXY(i, j);
				}
			}
		for(int i=0;i<5;i++) {
			//master[1].setMaster(1);
		}
	}
	/**
	 * 输出地图，展示地图当前信息以及战况
	 */
	public void showMap(){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("-------------------------");
		logger.info("地图分界线——————————————————————");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 英雄初始化，玩家可输入英雄个数，然后输入英雄的各个属性，和一个你想要在地图上显示英雄的形象如‘A’，
	 * 该函数会将英雄初始化到地图上显示出来
	 * @throws Throwable 
	 * 
	 */
	public void setHero() throws Throwable {
		File file=new File("英雄属性.txt");
		BufferedReader fcin = null;
		try {
			fcin = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str=null;
		
		Scanner reader=new Scanner(System.in);
		
		/**
		 * 输入英雄个数
		 */
		System.out.println("请输入英雄个数：");
		logger.info("请输入英雄个数：");
		//HeroNum=reader.nextInt();
	
		HeroNum=Integer.parseInt(fcin.readLine());
		System.out.println(HeroNum);
		
		System.out.println("请依次输入英雄的血量，魔法值，经验值，位置nm，形态,攻击力和攻击距离");
		logger.info("请依次输入英雄的血量，魔法值，经验值，位置nm，形态,攻击力和攻击距离");
		hero=new Hero[HeroNum];
		for(int i=0;i<HeroNum;i++)
			hero[i]=new Hero();
		/**
		 * 输入英雄属性
		 */
		int hp=0,mp=0,exp=0,m=0,n=0,ad=0,attack=0;
		char form='a';
		for(int i=0;i<HeroNum;i++) {
			hp=Integer.parseInt(fcin.readLine());
			System.out.print(hp+" ");
			mp=Integer.parseInt(fcin.readLine());
			System.out.print(mp+" ");
			exp=Integer.parseInt(fcin.readLine());
			System.out.print(exp+" ");
			n=Integer.parseInt(fcin.readLine());
			System.out.print(n+" ");
			m=Integer.parseInt(fcin.readLine());
			System.out.print(m+" ");
			form=fcin.readLine().charAt(0);
			System.out.print(form+" ");
			attack=Integer.parseInt(fcin.readLine());
			System.out.print(attack+" ");
			ad=Integer.parseInt(fcin.readLine());
			System.out.println(ad);
			/*hp=reader.nextInt();
			mp=reader.nextInt();
			exp=reader.nextInt();
			n=reader.nextInt();
			m=reader.nextInt();
			form=reader.next().charAt(0);
			attack=reader.nextInt();
			ad=reader.nextInt();*/
			if(map[n][m]=='|'||map[n][m]=='—') {
				System.out.println("英雄位置信息错误，请重新输入");
				logger.info("英雄位置信息错误，请重新输入");
				i--;
				continue;
			}
			/**
			 * 将输入的各属性赋给英雄
			 */
			hero[i].initHero(hp, mp, exp, n, m, form,attack,ad);
		}
	}
	public void setMap(){
		for(int i=0;i<HeroNum;i++){
			map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
		}
	}
	/**
	 * 移动函数，用于英雄在地图上的上下左右移动（用WSAD表示方向）
	 */
	public void Move(char form,char direction) {
		for(int i=0;i<HeroNum;i++) {
			if(form==hero[i].getForm()) {
				
				if(direction=='W') {
					if(IsMoveEffevtive(hero[i].getN()-1, hero[i].getM())==1) {
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN()-1, hero[i].getM());
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
						logger.info("移动成功！");
						}
				}
				else if(direction=='S') {
					if(IsMoveEffevtive(hero[i].getN()+1, hero[i].getM())==1) {
						
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN()+1, hero[i].getM());
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
						logger.info("移动成功！");
					}
				}
				else if(direction=='A') {
					if(IsMoveEffevtive(hero[i].getN(), hero[i].getM()-1)==1) {
						
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN(), hero[i].getM()-1);
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
						logger.info("移动成功！");
					}
					
				}
				else 
				{
					if(IsMoveEffevtive(hero[i].getN(), hero[i].getM()+1)==1) {
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN(), hero[i].getM()+1);
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
						logger.info("移动成功！");
					}
					
				}
				
				break;
			}
			
		}
	}
	/**
	 * 判断移动是否有效，实际是判断输入是否有效，若要移动的位置存在障碍物或野怪等就不能移动了，需要重新输入移动方向
	 * @param n 移动目的地在地图矩阵中的行
	 * @param m 移动目的地在地图矩阵中的列
	 * @return 若判断可以移动返回1，反之返回0
	 */
	public int  IsMoveEffevtive(int n,int m) {
		/**
		 * 判断是否有障碍物
		 */
		if(map[n][m]=='|'||map[n][m]=='—') {
			System.out.println("有障碍物阻挡，移动失败，请重新输入");
			return 0;
		}
		/**
		 * 判断是否超出地图
		 */
		else if(n<0||n>9||m<0||m>9) {
			System.out.println("超出边界，移动失败，请重新输入");
			return 0;
		}
		/**
		 * 判断是否有英雄的尸体
		 */
		else if(map[n][m]=='*') {
			System.out.println("前方有尸体，移动失败，请重新输入");
			return 0;
		}
		/**
		 * 判断是否有英雄存在该位置
		 */
		else if(map[n][m]!='.') {
			System.out.println("前方位置有英雄，请重新输入");
		}
		return 1;
	}
	/**
	 * 攻击函数，用于进行英雄间的攻击，会调用判断攻击距离是否有效的函数，如果可以，则进行攻击，同时在地图上会显示子弹特效
	 * 攻击完后会调用判断是否死亡的函数，若死亡则在地图上就变成‘*’（尸体），同时给击杀者增加经验后调用数据更新函数，看经验值是否足够升级
	 * @see 英雄类的判断函数
	 */
	public void attack(char attacker,char defender) {
		int i,attack=0,defend=0;
		for(i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==attacker)
				attack=i;
			if(hero[i].getForm()==defender)
				defend=i;		
		}
		System.out.println("攻击者为： "+hero[attack].getForm());
		logger.info("攻击者为： "+hero[attack].getForm());
		System.out.println("被攻击者是： "+hero[defend].getForm());
		logger.info("被攻击者是： "+hero[defend].getForm());
		if(hero[attack].IfCanAttack(hero[defend])==1) {
			hero[defend].setHp(hero[attack].getAttack());
			int p,q,flag=0;
			if(hero[attack].getN()==hero[defend].getN()) {
				if(hero[defend].getM()<hero[attack].getN()) {
					for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
						if(map[p][q]!='.')
							flag++;
					}
					if(flag==0) {
						for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
						map[p][q]='~';
					showMap();
						}
					for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
						map[p][q]='.';
						//showMap();
							}
					}
					else
						flag=0;
				}
				else {
						for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
							if(map[p][q]!='.')
								flag++;
						}
						if(flag==0) {
							for(p=hero[attack].getN(),q=hero[attack].getM()-1;q<hero[defend].getM();q++) {
						map[p][q]='~';
						showMap();
							}
							for(p=hero[attack].getN(),q=hero[attack].getM()-1;q<hero[defend].getM();q++) {
						map[p][q]='.';
						//showMap();
						}
						}
						else 
							flag=0;
				}
			}
			if(hero[attack].getM()==hero[defend].getM()) {
				for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
					if(map[p][q]!='.')
						flag++;
				}
			}
			if(flag==0) {
				if(hero[attack].getN()<hero[defend].getN()) {
					for(p=hero[attack].getM(),q=hero[attack].getN()+1;q<hero[defend].getN();q++) {
						map[q][p]='~';
						showMap();
					}
					for(p=hero[attack].getM(),q=hero[attack].getN()+1;q<hero[defend].getN();q++) {
						map[q][p]='.';
					}
				}
				else {
					for(p=hero[attack].getM(),q=hero[attack].getN()-1;q>hero[defend].getN();q--) {
						map[q][p]='~';
						showMap();
					}
					for(p=hero[attack].getM(),q=hero[attack].getN()-1;q>hero[defend].getN();q--) {
						map[q][p]='.';
					}
				}
			}
		}
		int die1=hero[defend].IsDie(),die2=hero[attack].IsDie();
		if(die1==1) {
			map[hero[defend].getN()][hero[defend].getM()]='*';
		}
		if(die2==1) {
			map[hero[attack].getN()][hero[attack].getM()]='*';
		}
		if(die1==1&&die2==0) {
			hero[attack].setExp(hero[defend].getLevel());
			hero[attack].upDate();
		}	
		if(die2==1&&die1==0)
		{
			hero[defend].setExp(hero[attack].getLevel());
			hero[defend].upDate();
		}
}
	/**
	 * 使用技能<pre>
	 * 闪现：移动两个距离（调用两次移动函数）<pre>
	 * 治疗：恢复生命值<pre>
	 * 爆炸：造成范围伤害同时在地图显示爆炸特效
	 */
	public void useSkill(char form,String skill) {
		for(int i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==form) {
				if(skill.equals("ZhiLiao")) {
					System.out.println(form+"使用技能治疗，恢复40点生命值");
					logger.info(form+"使用技能治疗，恢复40点生命值");
		}
				if(skill.equals("ShanXian")) {
					System.out.println("请输入闪现的方向：");
					logger.info("请输入闪现的方向：");
					char dir;
					dir=new Scanner(System.in).next().charAt(0);
					Move(form,dir);
					Move(form,dir);
					System.out.println(form+"使用技能闪现");
					logger.info(form+"使用技能闪现");
					
				}
				if(skill.equals("BaoZa")) {
					int p,q;
					int n,m;
					char temp[][];
					temp=new char[10][10];
					for(p=0;p<10;p++) {
						for(q=0;q<10;q++) {
							temp[p][q]=map[p][q];
						}
					}
					System.out.println("请输入爆炸范围的左上坐标");
					logger.info("请输入爆炸范围的左上坐标");
					n=new Scanner(System.in).nextInt();
					m=new Scanner(System.in).nextInt();
					for(p=n;p<n+5;p++) {
						for(q=m;q<m+5;q++) {
							map[p][q]='X';
						}
					}
					showMap();
					for(p=0;p<10;p++) {
						for(q=0;q<10;q++) {
							map[p][q]=temp[p][q];
						}
					}
				}
			}
		}
		
	}
}