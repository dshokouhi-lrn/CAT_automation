package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.HidePage;

public class HidePageTC extends HidePage {
	
	@Test
	void CatHidePage() throws Exception
	{
		hidePage("1", "1", "1");
	}

}