package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.ModuleManager;

public class ModuleManagerTC extends ModuleManager
{
	@Test
	public void searchModule() throws Exception
	{
		
		getModuleManager();
		getSearchModule("ADP028");
		editFluidxCourse();
	}
	
	
}
