package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditMultipleScenarioTemplate;

public class EditMultipleScenarioTemplateTC extends EditMultipleScenarioTemplate{
	
	@Test
	void CatEditMultipleScenarioTemplateTC() throws Exception
	{
		editMultipleScenarioTemplate("multiple test", "yes", "Top To Bottom", "test", "yes", "yes", "test", "test", "Random", "4", "5", "6", "7", "yes", "yes", "yes", "Text and Graphic", "yes", "test", "test", "yes", "yes", "test", "test", "yes", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "yes", "yes");
		addPageToScenario("2", "Saq", "yes", "test", "", "yes", "yes", "test", "test", "yes", "Check All", "test", "yes", "test", "", "", "", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "");
		addScenario(2, "1", "2", "8", "9", "", "", "", "Text and Graphic", "yes", "test", "test", "yes", "yes", "test", "test", "yes", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
	}

}
