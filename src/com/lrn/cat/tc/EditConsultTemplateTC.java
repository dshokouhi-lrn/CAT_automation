package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditConsult;

public class EditConsultTemplateTC extends EditConsult{
	
	
	@Test
	public void CatEditConsult() throws Exception
	{
		editConsult("yes", "consult test", "Left to Right", "test", "test", "test", "yes", "test", "test", "test", "yes", "One Correct Answer", "yes", "test", "yes", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "yes");
	
		addConsult(1, "test", "test", "yes", "test", "test");
		
		addAnswerOption("2", "", "test", "yes", "yes", "test", "test");
	
	}

}
