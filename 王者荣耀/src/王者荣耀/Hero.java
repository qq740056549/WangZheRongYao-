package ������ҫ;
import java.util.*;
/**
 * 
 * @author �½��� 2017192038
 * @version ����4.0
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
	 * Ӣ�۳�ʼ��������������ĸ����Ը���Ӣ��
	 * @param hp Ѫ��
	 * @param mp ħ��ֵ
	 * @param exp ����ֵ
	 * @param n �ڵ�ͼ�����е���
	 * @param m �ڵ�ͼ�����е���
	 * @param form �ڵ�ͼ��ʾ������
	 * @param attack ������
	 * @param ad ��������
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
	 * ���ݸ��£��������ֵ����������Ҫ����ȼ���������ͬʱ������Ҳ������������
	 * ������������������������Ӣ������
	 */
	public void upDate() {
		if(exp>=level*10) {
			setMaxHp();
			setAttack();
			fullHp();
			setLevel();
			setExp();
			System.out.println(form+"������");
		}
	}
	/**
	 * �жϹ��������Ƿ��㹻�������Է�Ӣ�ۣ�������й����������򹥻�ʧ�ܣ��˷�һ�ι����Ļ���
	 * @param t ��������Ӣ��
	 * @return ���Թ�������1����֮����0
	 */
	public int IfCanAttack(Hero t) {
		int n1=this.getN(),m1=this.getM();
		int n2=t.getN(),m2=t.getM();
		int d1=(n1-n2)*(n1-n2)+(m1-m2)*(m1-m2);
		if(d1<=this.getAttackDistance()*this.getAttackDistance()) {
			System.out.println(form+"�Ĺ��������㹻����������"+t.getForm());
			return 1;
		}	
		else {
			System.out.println(form+"�Ĺ������벻���Թ���������"+t.getForm());
			return 0;
		}
}
	/**
	 * �жϹ��������Ƿ��㹻�������Է�Ұ�֣�������й����������򹥻�ʧ�ܣ��˷�һ�ι����Ļ���
	 * @param t ��������Ұ��
	 * @return ���Թ�������1����֮����0
	 */
	public int IfCanAttack(Master t) {
		int n1=this.getN(),m1=this.getM();
		int n2=t.x,m2=t.y;
		int d1=(n1-n2)*(n1-n2)+(m1-m2)*(m1-m2);
		if(d1<=this.getAttackDistance()*this.getAttackDistance()) {
			System.out.println(form+"�Ĺ��������㹻������Ұ��");
			return 1;
		}	
		else {
			System.out.println(form+"�Ĺ������벻���Թ�����Ұ��");
			return 0;
		}
}
	/**
	 * �ж�Ӣ���Ƿ�������hp<=0������
	 * @return ��������1����֮����0
	 */
	public int IsDie() {
		if(getHp()<=0) {
			System.out.println("Ӣ��"+getForm()+"����");
			return 1;
		}
		return 0;
	}
}