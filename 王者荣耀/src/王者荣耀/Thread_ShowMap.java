package 王者荣耀;
/**
 * 
 * @author 陈建荣 201719038
 *     此线程用于打印地图
 */
class Thread_ShowMap extends Thread{
	Map temp;
	Thread_ShowMap(Map a){
		temp=a;
	}
	public void run() {
		while(true) {
			temp.showMap();
			System.out.println("1s后");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
