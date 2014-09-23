package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GoldArmorBody extends Item
{

	public GoldArmorBody(int id)
	{
		super(id);
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("GoldArmorBody");
	}

}
