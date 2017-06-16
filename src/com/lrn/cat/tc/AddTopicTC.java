package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AddTopic;

public class AddTopicTC extends AddTopic {

	@Test
	
	void CatAddTopic() throws Exception
	{
		addTopic("topic");
	}
}
