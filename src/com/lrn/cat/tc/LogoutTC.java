package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.cat.page.LogoutPage;
import com.lrn.pp.utility.Log;

public class LogoutTC extends LogoutPage{
	@Test
	void CatLogicTC() throws Exception
	{

		logout();

	}
	
	
	

}