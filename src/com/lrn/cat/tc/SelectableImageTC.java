package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.SelectableImage;


public class SelectableImageTC extends SelectableImage {
	@Test
	void SelectableImagePageTC() throws Exception{
		
			
		selectableimage("dir-rtl","selectable title","yes","content","Random","DesktopSamrtphones","10","15","HS ImageTitle","HS ImageText","yes","yes","yes","test","test","yammer","Bulletin Tilte","Content for bulletin");
		
		/* Layout: dir-ltr Image right,dir-rtl image left,dir-btt Imagetop,dir-ttb Imagebottom,dir-fsg fullimage
		Selection order: Random & Sequential
		imagePlacement:DesktopSamrtphones,Place*/
	}

}
