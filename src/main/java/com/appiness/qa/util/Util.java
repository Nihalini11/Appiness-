package com.appiness.qa.util;

import com.appiness.qa.base.TestBase;

public class Util extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_TIMEOUT=30;
	public void switchtoframe()
	{
		driver.switchTo().frame(0);
	}

}
