package Õı’ﬂ»Ÿ“´;

class Thread_ShowMap extends Thread{
	Map temp;
	Thread_ShowMap(Map a){
		temp=a;
	}
	public void run() {
		//int n=10;
		while(true) {
			temp.showMap();
			System.out.println("1s∫Û");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
