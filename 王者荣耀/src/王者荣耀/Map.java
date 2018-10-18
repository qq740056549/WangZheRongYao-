package ������ҫ;

import java.util.*;


class Map{
	private char map[][];
	private int n,m;
	private int HeroNum;
	private Hero hero[];
	public Map(int n,int m){
		this.n=n;
		this.m=m;
		map=new char[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]='.';
	}
	public void showMap(){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	public void setHero() {
		Scanner reader=new Scanner(System.in);
		int hp,mp,exp,m,n;
		char form='a';
		System.out.println("������Ӣ�۸�����");
		HeroNum=reader.nextInt();
		System.out.println("����������Ӣ�۵�Ѫ����ħ��ֵ������ֵ��λ��nm������̬");
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
			hero[i].initHero(hp, mp, exp, n, m, form);
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
				map[hero[i].getN()][hero[i].getM()]='.';
				if(direction=='W')
					hero[i].setPosition(hero[i].getN()-1, hero[i].getM());
				else if(direction=='S')
					hero[i].setPosition(hero[i].getN()+1, hero[i].getM());
				else if(direction=='A')
					hero[i].setPosition(hero[i].getN(), hero[i].getM()-1);
				else 
					hero[i].setPosition(hero[i].getN(), hero[i].getM()+1);
				
				map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
				System.out.println("�ƶ��ɹ���");
				break;
			}
			
		}
	}
	public void attack(char attacker,char defender) {
		int i,attack=0,defend=0;
		for(i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==attacker)
				attack=i;
			if(hero[i].getForm()==defender)
				defend=i;		
		}
		System.out.println("������Ϊ�� "+hero[attack].getForm());
		System.out.println("���������ǣ� "+hero[defend].getForm()+"��������2��Ѫ");
		hero[defend].setHp(2);
				
	}
	void useSkill(char form,String skill) {
		for(int i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==form) {
				if(skill.equals("ZhiLiao")) {
					System.out.println(form+"ʹ�ü������ƣ��ָ�40������ֵ");
		}
				if(skill.equals("ShanXian")) {
					System.out.println("���������ֵķ���");
					char dir;
					dir=new Scanner(System.in).next().charAt(0);
					Move(form,dir);
					Move(form,dir);
					System.out.println(form+"ʹ�ü�������");
			
		}
			}
		}
		
	}
}