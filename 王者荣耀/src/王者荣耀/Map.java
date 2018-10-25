package 王者荣耀;

import java.util.*;


class Map{
	public char map[][];
	private int n,m;
	private int HeroNum;
	private Hero hero[];
	public Map(int n,int m){
		n=10;
		m=10;
		this.n=n;
		this.m=m;
		map=new char[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]='.';
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
	}
	public void showMap(){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("-------------------------");
	}
	public void setHero() {
		Scanner reader=new Scanner(System.in);
		int hp,mp,exp,m,n,ad,attack;
		char form='a';
		System.out.println("请输入英雄个数：");
		HeroNum=reader.nextInt();
		System.out.println("请依次输入英雄的血量，魔法值，经验值，位置nm，形态,攻击力和攻击距离");
		hero=new Hero[HeroNum];
		for(int i=0;i<HeroNum;i++)
			hero[i]=new Hero();
		for(int i=0;i<HeroNum;i++) {
			hp=reader.nextInt();
			mp=reader.nextInt();
			exp=reader.nextInt();
			n=reader.nextInt();
			m=reader.nextInt();
			form=reader.next().charAt(0);
			attack=reader.nextInt();
			ad=reader.nextInt();
			if(map[n][m]=='|'||map[n][m]=='—') {
				System.out.println("英雄位置信息错误，请重新输入");
				i--;
				continue;
			}
			hero[i].initHero(hp, mp, exp, n, m, form,attack,ad);
		}
	}
	public void setMap(){
		for(int i=0;i<HeroNum;i++){
			map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
		}
	}
	public void Move(char form,char direction) {
		for(int i=0;i<HeroNum;i++) {
			if(form==hero[i].getForm()) {
				
				if(direction=='W') {
					if(IsMoveEffevtive(hero[i].getN()-1, hero[i].getM())==1) {
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN()-1, hero[i].getM());
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
						}
				}
				else if(direction=='S') {
					if(IsMoveEffevtive(hero[i].getN()+1, hero[i].getM())==1) {
						
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN()+1, hero[i].getM());
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
					}
				}
				else if(direction=='A') {
					if(IsMoveEffevtive(hero[i].getN(), hero[i].getM()-1)==1) {
						
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN(), hero[i].getM()-1);
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
					}
					
				}
				else 
				{
					if(IsMoveEffevtive(hero[i].getN(), hero[i].getM()+1)==1) {
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN(), hero[i].getM()+1);
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("移动成功！");
					}
					
				}
				
				break;
			}
			
		}
	}
	public int  IsMoveEffevtive(int n,int m) {
		if(map[n][m]=='|'||map[n][m]=='—') {
			System.out.println("有障碍物阻挡，移动失败，请重新输入");
			return 0;
		}
		else if(n<0||n>9||m<0||m>9) {
			System.out.println("超出边界，移动失败，请重新输入");
			return 0;
		}
		else if(map[n][m]=='*') {
			System.out.println("前方有尸体，移动失败，请重新输入");
			return 0;
		}
		else if(map[n][m]!='.') {
			System.out.println("前方位置有英雄，请重新输入");
		}
		return 1;
	}
	public void attack(char attacker,char defender) {
		int i,attack=0,defend=0;
		for(i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==attacker)
				attack=i;
			if(hero[i].getForm()==defender)
				defend=i;		
		}
		System.out.println("攻击者为： "+hero[attack].getForm());
		System.out.println("被攻击者是： "+hero[defend].getForm());
		if(hero[attack].IfCanAttack(hero[defend])==1) {
			hero[defend].setHp(hero[attack].getAttack());
			int p,q;
			for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
				map[p][q]='~';
				showMap();
				}
			for(p=hero[attack].getN(),q=hero[attack].getM()-1;q>hero[defend].getM();q--) {
				map[p][q]='.';
				//showMap();
				}
			if(hero[defend].IfCanAttack(hero[attack])==1) {
				hero[attack].setHp(hero[defend].getAttack());
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
	public void useSkill(char form,String skill) {
		for(int i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==form) {
				if(skill.equals("ZhiLiao")) {
					System.out.println(form+"使用技能治疗，恢复40点生命值");
		}
				if(skill.equals("ShanXian")) {
					System.out.println("请输入闪现的方向：");
					char dir;
					dir=new Scanner(System.in).next().charAt(0);
					Move(form,dir);
					Move(form,dir);
					System.out.println(form+"使用技能闪现");
					
				}
			}
		}
		
	}
}