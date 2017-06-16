package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditCarouselTemplate;

public class EditCarouselTemplateTC extends EditCarouselTemplate{
	
	@Test
	void CatEditCarouselTemplate() throws Exception
	{
		editCarouselTemplate("carousel title", "test1", "test2", "test3", "test4", "yes", "6", "yes", "yes", "test", "test", "yes", "yes");
		addCarouselScreen(2, "title2 carousel", "test11", "test22", "test33", "test44", "yes", "8", "yes", "yes", "test", "test");
	}

}
