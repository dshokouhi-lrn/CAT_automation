package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AddLesson;

public class AddLessonTC extends AddLesson {

	@Test
	
	void CatAddLesson() throws Exception
	{
		addLesson("lesson");
	}
}
