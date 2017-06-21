package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.PublishCourse;

public class PublishCourseTC extends PublishCourse{
	
	@Test
	void CatPublishCourse() throws Exception
	{
		publishCourse();
	}
}
