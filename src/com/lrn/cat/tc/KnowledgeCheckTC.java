package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.KnowledgeCheck;

public class KnowledgeCheckTC extends KnowledgeCheck {
		

  	@Test
	void CATKnowledgeCheckTC () throws Exception
	{
			knowledgecheck("Q1","KC question text","Learners can select only one answer","ans1","ans2","Learners can select only one answer","Feedback","image des","alt text",1);
		
		
	}
	
	
}
