package ÍõÕßÈÙÒ«;

class Thread1 implements Runnable{
	Map temp;
	Thread1(Map a){
		temp=a;
	}
	public void run() {
		temp.showMap();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
