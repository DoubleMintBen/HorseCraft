package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TannedLeather extends Item
{

	public TannedLeather(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("TannedLeather");
	}

}
