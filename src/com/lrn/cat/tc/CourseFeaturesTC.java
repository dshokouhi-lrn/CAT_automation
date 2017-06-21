package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.CourseFeatures;

public class CourseFeaturesTC extends CourseFeatures{
	
	@Test
	void CatEditCourseFeatures() throws Exception
	{
		setupCourseFeatures("no", "no", "", "yes", "test", "test", "yes", "yes", "yes");
		setupTimer("yes", "Course Level", "", "");
		editFAQ("Yes", "test", "test", "test2", "test2");
		editTop10("Yes", "test1", "test1", "test2", "test2");
		editResources("Yes", "Link", "test1", "Document", "test2");
	}

}
