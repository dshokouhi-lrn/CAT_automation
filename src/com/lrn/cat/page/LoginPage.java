package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class LoginPage extends CATAppCommon{
	
	
	static public void login(String userName,String passWord) throws Exception
    {
           try
           {
                  Log.startTestCase("Verify CAT Login ");
                  typeTextByName("userName", userName);
                  typeTextByName("passWord", passWord);
                  clickIdentifierXpath("//div[@class='loginBtnWrapper']/input");
                  softAssertEquals("//div[@class='iconsTopContainer']/a[1]/p/span", "Create a Course");
                  softA.assertAll();
                  Thread.sleep(300);
                  //     Assert.assertTrue(waitForElementPresentByLinkText("log out"));
                  Log.pass("Logged-in Successfully!!");

           }
           catch(Exception e){  
                  Log.fail("Failed to login into Application");
                  e.printStackTrace();
                  throw e;                                        
           } catch(AssertionError e){
                  Log.fail("Failed to login into Application");
                  e.printStackTrace();
                  throw e;

           }
    }


}
