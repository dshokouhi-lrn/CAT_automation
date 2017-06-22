package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.CreateTestOutLesson;

public class CreateTestOutLessonTC extends CreateTestOutLesson {
	
	@Test
	
	void CatCreateTestOutLesson() throws Exception
	{
		createTestOutLesson("1", "dir-rtl", "welcome title", "welcome content", "yes", "yes", "yes", "welcome test", "welcome test", "dir-rtl", "no", "yes", "yes", "yes", "pass test", "pass test", "no", "yes", "yes", "yes", "fail test", "fail test", "dir-rtl", "wrap up title", "wrap up content", "yes", "yes", "yes", "wrap up test", "wrap up test", "no");
		
		addTestOutQuestion("2", "test", "test", "single", "test1", "test2", "yes", "test", "test");
	}

}
