package Õı’ﬂ»Ÿ“´;
import java.util.*;
class Hero{
	private int hp;
	private int mp;
	private int exp;
	private int n,m;
	private char form;
	
	public void initHero(int hp,int mp,int exp,int n,int m,char form){
		this.hp=hp;
		this.mp=mp;
		this.exp=exp;
		this.n=n;
		this.m=m;
		this.form=form;
	}
	public Hero(){
		this.hp=0;
		this.mp=0;
		this.exp=0;
		this.n=0;
		this.m=0;
		this.form='0';
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
	
}