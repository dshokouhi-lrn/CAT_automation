package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditConsentTemplate;

public class EditConsentTemplateTC extends EditConsentTemplate{
	
	@Test
	void CatEditConsentTemplate() throws Exception
	{
		editConsentTemplate("consent title", "yes", "yes", "content", "consent button", "yes", "yes", "test", "test", "test", "test", "yes", "yes");
	}

}
