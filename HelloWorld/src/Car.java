
public class Car {
	private double speed=80.0,weight=1.3;
	void setSpeed(double s) {
		speed=s;
	}
	double getSpeed() {
		return speed;
	}
	void setWeight(double w) {
		weight=w;
	}
	double getWeight() {
		return weight;
	}
	public static void main(String [] args) {
		Car car=new Car();
		System.out.printf("Speed:%f mph,weght:%f ton.\n",car.getSpeed(),car.getWeight());
		car.setSpeed(120.0);
		car.setWeight(1.5);
		System.out.printf("NOw speed:%f mph,weight:%fton\n",car.getSpeed(),car.getWeight());
	}
}


