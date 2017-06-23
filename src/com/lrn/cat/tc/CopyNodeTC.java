package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.CopyNode;


public class CopyNodeTC extends CopyNode {
	
	@Test
	void CatCopyNode() throws Exception
	{
		copyNode("1", "1", "1");
	}

}
