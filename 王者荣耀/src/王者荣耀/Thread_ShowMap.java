package ������ҫ;
/**
 * 
 * @author �½��� 201719038
 *     ���߳����ڴ�ӡ��ͼ
 */
class Thread_ShowMap extends Thread{
	Map temp;
	Thread_ShowMap(Map a){
		temp=a;
	}
	public void run() {
		while(true) {
			temp.showMap();
			System.out.println("1s��");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
