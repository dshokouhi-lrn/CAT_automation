package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;

public class LCECLogin extends  CATAppCommon{
	private String userIDlocater="User";
    //user password locater 
    private String passwordLocater="Password";
    //user login button  locater
    private String loginLocater="//input[@name='SignOn']";
    //user after log in locater for validation 
  //  private String verifyLocater="//a[contains(text(),'Logout')]";
    String dueDate_xpath="//a[text()='Due:']";
    public  void getLoginLCEC(String username,String password) throws Exception
    {

           typeTextById(userIDlocater,username);
           //LogerData.info( "send user name in to user name text box");
           //LogerData.info("user name is :"+username);
           typeTextById(passwordLocater,password);
           //logger.log(LogStatus.INFO, "send password to password text box");
           //LogerData.info("password name is :"+password);
           clickIdentifierXpath(loginLocater);
           //logger.log(LogStatus.INFO, "log in browser successfully");
           //logger.log(LogStatus.PASS, "Locater user name is displaying");
    }


}
