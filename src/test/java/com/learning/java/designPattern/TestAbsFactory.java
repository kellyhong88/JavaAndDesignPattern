package com.learning.java.designPattern;

import com.learning.java.designPattern.abstractFactory.*;
import org.junit.Test;

public class TestAbsFactory {

	@Test
	public void test() {
		PersonFactory factory = new ChristmasFactory();
		Boy boy1 = factory.createBoy();
		boy1.drawBoy();
		Girl girl1 = factory.createGirl();
		girl1.drawGirl();

		factory = new NewYearFactory();
		Boy boy2 = factory.createBoy();
		boy2.drawBoy();
		Girl girl2 = factory.createGirl();
		girl2.drawGirl();
	}

}
