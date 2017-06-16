package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.UnhidePage;

public class UnhidePageTC extends UnhidePage {
	
	@Test
	void CatUnhidePage() throws Exception
	{
		unhidePage("1", "1", "1");
	}

}