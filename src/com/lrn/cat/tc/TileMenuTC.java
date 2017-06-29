package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.TileMenu;

public class TileMenuTC extends TileMenu{
	
	@Test
	void CatTileMenu() throws Exception
	{
		configureTileMenu("yes", 4, "welcome test", "yes", "active test", "yes", "kc test", "yes", "cert test", "complete test", "exploratory", "no");
		tileConfiguration("2", "test", "solid", "", "", "", "light");
		tileConfiguration("4", "test", "fifty", "yes", "test", "test", "dark");
		tileConfiguration("6", "test", "full", "yes", "test", "test", "dark");
		tileConfiguration("8", "test", "solid", "", "", "", "dark");
		tileConfiguration("10", "test", "fifty", "yes", "test", "test", "light");
	}

}
