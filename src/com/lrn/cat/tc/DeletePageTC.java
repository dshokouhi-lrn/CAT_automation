package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.DeletePage;

public class DeletePageTC extends DeletePage {
	
	@Test
	void CatDeletePage() throws Exception
	{
		deletePage("1", "1", "1");
	}

}