package ÍõÕßÈÙÒ«;

class Master {
	int attack,hp,level,x,y;
	char form;
	Master(){
		this.attack=0;
		this.hp=0;
		this.level=0;
		form='&';
		x=0;y=0;
	}
	public void setXY(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void setMaster(int level) {
		this.attack=level*5;
		this.hp=level*10;
		this.level=level;
	}
	public void setHp(int a) {
		hp-=a;
	}
}
