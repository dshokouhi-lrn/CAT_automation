package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.LockPage;

public class LockPageTC extends LockPage {
	
	@Test
	void CatLockPage() throws Exception
	{
		lockPage("1", "1", "1");
	}

}
