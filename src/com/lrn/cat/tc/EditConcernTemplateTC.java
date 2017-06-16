package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditConcernTemplate;

public class EditConcernTemplateTC extends EditConcernTemplate{
	
	@Test
	void CatEditConcerntTemplateTC() throws Exception
	{
		editConcernTemplate("yes", "concern test", "Left to Right", "test", "test", "Check All", "yes", "test", "yes", "yes", "test", "test", "test", "yes", "Check All", "yes", "test", "yes", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "yes");
		addMeterAnswer("2", "no", "test2", "no", "", "test2", "test2");
		addAnswerOption("2", "no", "test3", "no", "", "test", "test");
	}

}
