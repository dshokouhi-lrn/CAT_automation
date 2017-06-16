package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditSAQ;

public class EditSAQTC extends EditSAQ{
	
	@Test
	void CatEditSAQ() throws Exception
	{
		editSAQ("saq title", "yes", "Graphical SAQ", "Right To Left", "test", "Check All", "yes", "test", "yes", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "test", "test", "yes", "test", "test", "yes", "yes");
		addAnswerOption(1, "yes", "test", "yes", "yes", "test", "test");
	}

}
