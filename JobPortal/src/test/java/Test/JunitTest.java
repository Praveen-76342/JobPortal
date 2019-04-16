package Test;

import static org.junit.Assert.*;


import org.junit.Test;

public class JunitTest {

	@Test
	public void test() {
		int a = 1;
		int b = 2;
		assertTrue(a+b==3);
	}

}
