package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.ReorderNodes;

public class ReorderNodesTC extends ReorderNodes{
	
	@Test
	void CatReorderNodes() throws Exception
	{
		collapseLessons();
		
		dragAndDropLesson("4", "3");
	}

}
