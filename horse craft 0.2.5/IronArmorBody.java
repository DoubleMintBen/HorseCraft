package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronArmorBody extends Item
{

	public IronArmorBody(int id)
	{
		super(id);
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("IronArmorBody");
	}

}
