import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import java.util.*;
class buysauceTest {

	@Test
	void test() {
		buysauce car=new buysauce();
		Scanner a=new Scanner(System.in);
		int n;
		n=a.nextInt();
		Assert.assertEquals(5, car.re(n));
	}

}
