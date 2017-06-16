package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditBinaryTemplate;

public class EditBinaryTemplateTC extends EditBinaryTemplate{
	
	@Test
	void CatEditBinaryTemplate() throws Exception
	{
		editBinaryTemplate("yes", "binary test", "test", "test", "test", "yes", "test", "test", "yes", "test", "test", "yes", "yes");
		edit2binaryPanels("2", "test", "Choice 1", "0", "test2", "Choice 2", "1");
		addBinaryCategory(3, "test1");
	}

}
