package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.LandingPage;

public class LandingPageTC extends LandingPage{
	
	@Test
	void CatLandingPage() throws Exception
	{
		addLandingPage("yes", "yes", "yes", "", "", "", "", "", "", "test", "", "", "", "", "", "", "");
	}

}
