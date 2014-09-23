package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DiamondArmorBody extends Item
{

	public DiamondArmorBody(int id)
	{
		super(id);
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("DiamondArmorBody");
	}

}
