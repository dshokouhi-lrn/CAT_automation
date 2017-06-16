package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.UnlockPage;

public class UnlockPageTC extends UnlockPage {
	
	@Test
	void CatLockPage() throws Exception
	{
		unlockPage("1", "1", "1");
	}

}