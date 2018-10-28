package 王者荣耀;
import java.util.*;
/**
 * 
 * @author 陈建荣 2017192038
 * @version 王者4.0
 *
 */
class Hero {
	private int hp;
	private int mp;
	private int exp;
	public int getExp() {
		return exp;
	}
	public void setExp() {
		this.exp = getExp()-(getLevel()-1)*10;
	}
	public void setExp(int lt) {
		exp+=lt*8;
	}
	private int n,m;
	private int level;
	public void setLevel() {
		this.level = getLevel()+1;
	}
	public int getLevel() {
		return level;
	}
	private char form;
	private int maxHp;
	private int attack,attackDistance;
	
	public int getAttackDistance() {
		return attackDistance;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack() {
		this.attack = getAttack()+3;
	}
	/**
	 * 英雄初始化函数，将输入的各属性赋给英雄
	 * @param hp 血量
	 * @param mp 魔法值
	 * @param exp 经验值
	 * @param n 在地图矩阵中的行
	 * @param m 在地图矩阵中的列
	 * @param form 在地图显示的形象
	 * @param attack 攻击力
	 * @param ad 攻击距离
	 */
	public void initHero(int hp,int mp,int exp,int n,int m,char form,int attack,int ad){
		this.hp=hp;
		this.mp=mp;
		this.exp=exp;
		this.n=n;
		this.m=m;
		this.form=form;
		this.level=1;
		this.maxHp=hp;
		this.attackDistance=ad;
		this.attack=attack;
	}
	public Hero(){
		this.level=1;
		this.hp=0;
		this.mp=0;
		this.exp=0;
		this.n=0;
		this.m=0;
		this.form='0';
		this.maxHp=0;
		this.attackDistance=0;
	}
	public void setPosition(int n,int m){
		this.n=n;
		this.m=m;
	}
	public void setForm(char form){
		this.form=form;
	}
	int getN(){
		return n;
	}
	int getM(){
		return m;
	}
	char getForm(){
		return form;
	}
	void setHp(int at) {
		hp-=at;
	}
	int getHp() {
		return hp;
	}
	void fullHp() {
		hp=getMaxHp();
	}
	int getMaxHp() {
		return maxHp;
	}
	void setMaxHp() {
		maxHp=getMaxHp()+5;
	}
	/**
	 * 数据更新，如果经验值满足升级的要求，则等级会提升，同时各属性也会有所提升。
	 * 这个函数就用来更新升级后的英雄属性
	 */
	public void upDate() {
		if(exp>=level*10) {
			setMaxHp();
			setAttack();
			fullHp();
			setLevel();
			setExp();
			System.out.println(form+"已升级");
		}
	}
	/**
	 * 判断攻击距离是否足够攻击到对方英雄，够则进行攻击，不够则攻击失败，浪费一次攻击的机会
	 * @param t 被攻击的英雄
	 * @return 可以攻击返回1，反之返回0
	 */
	public int IfCanAttack(Hero t) {
		int n1=this.getN(),m1=this.getM();
		int n2=t.getN(),m2=t.getM();
		int d1=(n1-n2)*(n1-n2)+(m1-m2)*(m1-m2);
		if(d1<=this.getAttackDistance()*this.getAttackDistance()) {
			System.out.println(form+"的攻击距离足够攻击到对手"+t.getForm());
			return 1;
		}	
		else {
			System.out.println(form+"的攻击距离不足以攻击到对手"+t.getForm());
			return 0;
		}
}
	/**
	 * 判断攻击距离是否足够攻击到对方野怪，够则进行攻击，不够则攻击失败，浪费一次攻击的机会
	 * @param t 被攻击的野怪
	 * @return 可以攻击返回1，反之返回0
	 */
	public int IfCanAttack(Master t) {
		int n1=this.getN(),m1=this.getM();
		int n2=t.x,m2=t.y;
		int d1=(n1-n2)*(n1-n2)+(m1-m2)*(m1-m2);
		if(d1<=this.getAttackDistance()*this.getAttackDistance()) {
			System.out.println(form+"的攻击距离足够攻击到野怪");
			return 1;
		}	
		else {
			System.out.println(form+"的攻击距离不足以攻击到野怪");
			return 0;
		}
}
	/**
	 * 判断英雄是否死亡，hp<=0则死亡
	 * @return 死亡返回1，反之返回0
	 */
	public int IsDie() {
		if(getHp()<=0) {
			System.out.println("英雄"+getForm()+"死亡");
			return 1;
		}
		return 0;
	}
}