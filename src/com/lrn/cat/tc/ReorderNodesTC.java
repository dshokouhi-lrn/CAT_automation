package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.ReorderNodes;

public class ReorderNodesTC extends ReorderNodes{
	
	@Test
	void CatReorderNodes() throws Exception
	{
		dragPageToDropLesson("1", "", "2", "4", "2", "");
		
		Thread.sleep(5000);
		
		dragPageToDropTopic("1", "2", "3", "3", "1", "");
		
		Thread.sleep(5000);
		
		dragTopicToDropLesson("1", "", "3", "2");
		
		Thread.sleep(5000);
		
		collapseLessons();
		
		dragAndDropLesson("4", "3");
	}

}
