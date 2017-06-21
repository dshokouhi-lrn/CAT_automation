package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.EditCertification;

public class EditCertificationTC extends EditCertification{
	
	@Test
	void CatEditCertificationTC() throws Exception
	{
		editCertification("Yes", "test", "test", "test", "no", "test", "test", "test", "test");
		addCertificationQuestion("no", "test", "Learners can select only one answer", "yes", "test", "yes", "test1", "yes", "test2", "no");
		addFollowUp("1", "", "1", "no", "test", "Learners can select one answer from dropdown", "no", "", "", "test1", "yes", "test2", "no");
		addFollowUp("1", "2", "1", "no", "test", "Learners can select one or more answers", "yes", "test", "no", "test1", "no", "test2", "no");
		addCertificationQuestion("no", "test", "Learners can enter a number", "", "", "", "", "", "", "");
		addCertificationQuestion("no", "test", "Learners can select a date", "", "", "", "", "", "", "");
		addCertificationQuestion("no", "test", "Learners can enter text", "", "", "", "", "", "", "");
	}

}
