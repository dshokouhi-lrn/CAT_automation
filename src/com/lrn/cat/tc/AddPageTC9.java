package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AddPage;

public class AddPageTC9 extends AddPage {
	
	@Test
	
	void CatAddPage() throws Exception
	{
		addPage("dnd");
	}

}
