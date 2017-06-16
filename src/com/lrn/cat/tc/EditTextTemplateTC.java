package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditTextTemplate;

public class EditTextTemplateTC extends EditTextTemplate{
	
	@Test
	
	static void CatEditTextTemplate() throws Exception
	{
		editTextTemplate("dir-rtl", "text title", "yes", "content", "yes", "yes", "yes", "test", "test");
	}

}
