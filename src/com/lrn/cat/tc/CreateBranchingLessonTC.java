package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.CreateBranchingLesson;

public class CreateBranchingLessonTC extends CreateBranchingLesson{
	
	@Test
	void CatCreateBranchingLesson() throws Exception
	{
		createBranchingLesson("2", 4, "yes", "test", "test", "yes", "yes", "2");
		configureTopic("2", "1", "test", "Fifty fifty", "yes");
		configureTopic("2", "2", "test", "Solid", "");
	}

}
