package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditVideoTemplate1;

public class EditVideoTemplateTC extends EditVideoTemplate1{
	
	@Test
	void CatEditVideoTemplate() throws Exception
	{
		//editVideoTemplate();
		
		editVideoTemplate("video title", "yes", "video content", "no", "yes", "yes", "yes", "", "panel content", "yes", "yes", "yes", "test", "test");
		addVideoPanel(2, "test", "yes", "yes", "yes", "test", "test");
		editNewBulletin("yes", "yes", "yes", "ouch", "bulletin title", "bulletin text");
	}

}
