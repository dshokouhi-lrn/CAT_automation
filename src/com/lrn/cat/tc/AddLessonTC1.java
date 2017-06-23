package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AddLesson;

public class AddLessonTC1 extends AddLesson {

	@Test
	
	void CatAddLesson() throws Exception
	{
		addLesson("lesson branching");
	}
}
