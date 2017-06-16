package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.cat.page.LoginPage;
import com.lrn.pp.utility.Log;

public class LoginTC extends LoginPage{


	@Test
	void CatLogicTC() throws Exception
	{

		login("admin", "admin");

	}
	
	
	
}


