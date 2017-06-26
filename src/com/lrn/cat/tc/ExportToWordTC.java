package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.ExportToWord;

public class ExportToWordTC extends ExportToWord{
	
	@Test
	void CatExportToWord() throws Exception
	{
		exportToWordCourse("DAN781", "", "", "", "", "", "", "");
	}

}
