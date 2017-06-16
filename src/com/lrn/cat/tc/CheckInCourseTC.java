package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.CheckInCourse;

public class CheckInCourseTC extends CheckInCourse {
	
	
	@Test
	
	static void CatCheckInCourse() throws Exception
	{
		checkInCourse("test comments");
	}

}
