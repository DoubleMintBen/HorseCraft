package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IronArmorHead extends Item
{

	public IronArmorHead(int id)
	{
		super(id);
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("IronArmorHead");
	}

}
