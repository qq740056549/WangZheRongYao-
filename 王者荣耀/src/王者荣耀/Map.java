package ������ҫ;
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
 * @author �½��� 2017192038
 * @version ����4.0
 */
class Map implements Operation{
	
	private static Logger logger = Logger.getLogger(Map.class);
	public char map[][];
	private int n,m;
	private int HeroNum;
	private Hero hero[];
	private Master master[];
	/**
	 * ��ͼ��ʼ������ͼ�á�.������ʾ���ϰ����á�|���͡���������ʾ��Ұ�������á�&������@���ȷ�������ʾ
	 * @param n ��ͼ���������
	 * @param m ��ͼ���������
	 */
	public Map(int n,int m){	
		n=10;
		m=10;
		this.n=n;
		this.m=m;
		map=new char[n][m];
		/**
		 * ��ͼ��ʼ��
		 */
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]='.';
		/**
		 * �ϰ����ʼ��
		 */
		map[1][1]='|';
		map[5][1]='|';
		map[3][5]='|';
		map[5][4]='|';
		map[6][6]='|';
		map[7][3]='|';
		map[1][4]='��';
		map[2][2]='��';
		map[4][3]='��';
		map[7][2]='��';
		map[7][5]='��';
		/**
		 * Ұ�ֳ�ʼ��
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
				if(map[i][j]!='.'&&map[i][j]!='|'&&map[i][j]!='��') {
					//master[k].setXY(i, j);
				}
			}
		for(int i=0;i<5;i++) {
			//master[1].setMaster(1);
		}
	}
	/**
	 * �����ͼ��չʾ��ͼ��ǰ��Ϣ�Լ�ս��
	 */
	public void showMap(){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("-------------------------");
		logger.info("��ͼ�ֽ��ߡ�������������������������������������������");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Ӣ�۳�ʼ������ҿ�����Ӣ�۸�����Ȼ������Ӣ�۵ĸ������ԣ���һ������Ҫ�ڵ�ͼ����ʾӢ�۵������确A����
	 * �ú����ὫӢ�۳�ʼ������ͼ����ʾ����
	 * @throws Throwable 
	 * 
	 */
	public void setHero() throws Throwable {
		File file=new File("Ӣ������.txt");
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
		 * ����Ӣ�۸���
		 */
		System.out.println("������Ӣ�۸�����");
		logger.info("������Ӣ�۸�����");
		//HeroNum=reader.nextInt();
	
		HeroNum=Integer.parseInt(fcin.readLine());
		System.out.println(HeroNum);
		
		System.out.println("����������Ӣ�۵�Ѫ����ħ��ֵ������ֵ��λ��nm����̬,�������͹�������");
		logger.info("����������Ӣ�۵�Ѫ����ħ��ֵ������ֵ��λ��nm����̬,�������͹�������");
		hero=new Hero[HeroNum];
		for(int i=0;i<HeroNum;i++)
			hero[i]=new Hero();
		/**
		 * ����Ӣ������
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
			if(map[n][m]=='|'||map[n][m]=='��') {
				System.out.println("Ӣ��λ����Ϣ��������������");
				logger.info("Ӣ��λ����Ϣ��������������");
				i--;
				continue;
			}
			/**
			 * ������ĸ����Ը���Ӣ��
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
	 * �ƶ�����������Ӣ���ڵ�ͼ�ϵ����������ƶ�����WSAD��ʾ����
	 */
	public void Move(char form,char direction) {
		for(int i=0;i<HeroNum;i++) {
			if(form==hero[i].getForm()) {
				
				if(direction=='W') {
					if(IsMoveEffevtive(hero[i].getN()-1, hero[i].getM())==1) {
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN()-1, hero[i].getM());
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("�ƶ��ɹ���");
						logger.info("�ƶ��ɹ���");
						}
				}
				else if(direction=='S') {
					if(IsMoveEffevtive(hero[i].getN()+1, hero[i].getM())==1) {
						
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN()+1, hero[i].getM());
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("�ƶ��ɹ���");
						logger.info("�ƶ��ɹ���");
					}
				}
				else if(direction=='A') {
					if(IsMoveEffevtive(hero[i].getN(), hero[i].getM()-1)==1) {
						
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN(), hero[i].getM()-1);
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("�ƶ��ɹ���");
						logger.info("�ƶ��ɹ���");
					}
					
				}
				else 
				{
					if(IsMoveEffevtive(hero[i].getN(), hero[i].getM()+1)==1) {
						map[hero[i].getN()][hero[i].getM()]='.';
						hero[i].setPosition(hero[i].getN(), hero[i].getM()+1);
						map[hero[i].getN()][hero[i].getM()]=hero[i].getForm();
						System.out.println("�ƶ��ɹ���");
						logger.info("�ƶ��ɹ���");
					}
					
				}
				
				break;
			}
			
		}
	}
	/**
	 * �ж��ƶ��Ƿ���Ч��ʵ�����ж������Ƿ���Ч����Ҫ�ƶ���λ�ô����ϰ����Ұ�ֵȾͲ����ƶ��ˣ���Ҫ���������ƶ�����
	 * @param n �ƶ�Ŀ�ĵ��ڵ�ͼ�����е���
	 * @param m �ƶ�Ŀ�ĵ��ڵ�ͼ�����е���
	 * @return ���жϿ����ƶ�����1����֮����0
	 */
	public int  IsMoveEffevtive(int n,int m) {
		/**
		 * �ж��Ƿ����ϰ���
		 */
		if(map[n][m]=='|'||map[n][m]=='��') {
			System.out.println("���ϰ����赲���ƶ�ʧ�ܣ�����������");
			return 0;
		}
		/**
		 * �ж��Ƿ񳬳���ͼ
		 */
		else if(n<0||n>9||m<0||m>9) {
			System.out.println("�����߽磬�ƶ�ʧ�ܣ�����������");
			return 0;
		}
		/**
		 * �ж��Ƿ���Ӣ�۵�ʬ��
		 */
		else if(map[n][m]=='*') {
			System.out.println("ǰ����ʬ�壬�ƶ�ʧ�ܣ�����������");
			return 0;
		}
		/**
		 * �ж��Ƿ���Ӣ�۴��ڸ�λ��
		 */
		else if(map[n][m]!='.') {
			System.out.println("ǰ��λ����Ӣ�ۣ�����������");
		}
		return 1;
	}
	/**
	 * �������������ڽ���Ӣ�ۼ�Ĺ�����������жϹ��������Ƿ���Ч�ĺ�����������ԣ�����й�����ͬʱ�ڵ�ͼ�ϻ���ʾ�ӵ���Ч
	 * ������������ж��Ƿ������ĺ��������������ڵ�ͼ�Ͼͱ�ɡ�*����ʬ�壩��ͬʱ����ɱ�����Ӿ����������ݸ��º�����������ֵ�Ƿ��㹻����
	 * @see Ӣ������жϺ���
	 */
	public void attack(char attacker,char defender) {
		int i,attack=0,defend=0;
		for(i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==attacker)
				attack=i;
			if(hero[i].getForm()==defender)
				defend=i;		
		}
		System.out.println("������Ϊ�� "+hero[attack].getForm());
		logger.info("������Ϊ�� "+hero[attack].getForm());
		System.out.println("���������ǣ� "+hero[defend].getForm());
		logger.info("���������ǣ� "+hero[defend].getForm());
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
	 * ʹ�ü���<pre>
	 * ���֣��ƶ��������루���������ƶ�������<pre>
	 * ���ƣ��ָ�����ֵ<pre>
	 * ��ը����ɷ�Χ�˺�ͬʱ�ڵ�ͼ��ʾ��ը��Ч
	 */
	public void useSkill(char form,String skill) {
		for(int i=0;i<HeroNum;i++) {
			if(hero[i].getForm()==form) {
				if(skill.equals("ZhiLiao")) {
					System.out.println(form+"ʹ�ü������ƣ��ָ�40������ֵ");
					logger.info(form+"ʹ�ü������ƣ��ָ�40������ֵ");
		}
				if(skill.equals("ShanXian")) {
					System.out.println("���������ֵķ���");
					logger.info("���������ֵķ���");
					char dir;
					dir=new Scanner(System.in).next().charAt(0);
					Move(form,dir);
					Move(form,dir);
					System.out.println(form+"ʹ�ü�������");
					logger.info(form+"ʹ�ü�������");
					
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
					System.out.println("�����뱬ը��Χ����������");
					logger.info("�����뱬ը��Χ����������");
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