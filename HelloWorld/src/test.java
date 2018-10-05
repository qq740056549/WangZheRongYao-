import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		Hello x=new Hello();
		Assert.assertEquals("hello world", x.re());
	}

}
