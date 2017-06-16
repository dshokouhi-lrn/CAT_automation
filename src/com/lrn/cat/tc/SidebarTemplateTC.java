package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.SidebarTemplate;

public class SidebarTemplateTC extends SidebarTemplate {
	@Test
	void SidebarPageTC() throws Exception{
		
			
		sidebar("dir-rtl","sidebar title","yes","content","Custom","Custom config title","textforside bar","","Top1","yes","yes","yes","test","test","yammer","Bulletin Tilte","Content for bulletin");
		//sb config types Custom/FAQ/Top 10
	}
	
	
}


