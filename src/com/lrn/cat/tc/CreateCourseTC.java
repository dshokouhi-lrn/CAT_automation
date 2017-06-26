package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.CreateCourse;

public class CreateCourseTC extends CreateCourse{

	@Test
	
	void CatCreateCourseTC() throws Exception
	{
		//createCourse("test", "test", "DAN272", "Library", "Foundational", "", "HOW", "", "", "English - US", "YES", "YES", "YES", "5");
		createCourse("test", "test", "DAN781", "Custom", "Foundational", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");
	
		//createCourse("test", "test", "DAN774", "Custom", "Standalone Certification", "", "", "qacustomize07", "qacustomize07", "English", "YES", "YES", "YES", "6");
		//testing as another user
	}
}
