package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditDragAndDropTemplate;

public class EditDragAndDropTemplateTC extends EditDragAndDropTemplate{
	
	@Test
	void CatEditDragAndDropTemplate() throws Exception
	{
		editDragAndDropTemplate("dnd title", "yes", "Drag and Drop Without Flags", "test", "test1", "yes", "test", "test", "test11", "CAT1", "yes", "test", "test", "2", "test", "test", "test", "single", "test", "yes", "test", "test", "", "", "", "", "", "", "", "", "", "", "yes", "yes");
		addCategory("2", "test2", "yes", "test", "test");
		addLineItem("2", "test22", "CAT2", "yes", "test", "test");
	}

}
