package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.PasteNode;


public class PasteNodeTC extends PasteNode {
	
	@Test
	void CatPasteNode() throws Exception
	{
		pasteNode("1", "1");
	}

}
