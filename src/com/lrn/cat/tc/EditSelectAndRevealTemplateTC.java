package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditSelectAndRevealTemplate;

public class EditSelectAndRevealTemplateTC extends EditSelectAndRevealTemplate{
	
	@Test
	void CatEditSelectAndRevealTemplate() throws Exception
	{
		editSelectAndRevealTemplate("snr title", "yes", "Top To Bottom", "test", "Random", "test", "test", "yes", "test", "test", "yes", "yes", "yes");
		editRevealPanel(2, "test2", "test2", "yes", "test2", "test2", "yes");
		editRevealPanel(3, "test3", "test3", "yes", "test3", "test3", "yes");
		editRevealPanel(4, "test4", "test4", "yes", "test4", "test4", "yes");
	}

}
