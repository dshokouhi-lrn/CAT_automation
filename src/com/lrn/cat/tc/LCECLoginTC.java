package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.LCECLogin;

public class LCECLoginTC extends LCECLogin {
	
	@Test
	public void login() throws Exception{
	getLoginLCEC("skumar/lrn","welcome1");
	}
}
