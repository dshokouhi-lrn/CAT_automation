package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditGetStarted;

public class EditGetStartedTC extends EditGetStarted{

	@Test
	
	void CatEditGetStarted() throws Exception
	{
		editGetStartedPage("", "", "", "", "", "");
	}
}
