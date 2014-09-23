package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DiamondArmorHead extends Item
{

	public DiamondArmorHead(int id)
	{
		super(id);
		setMaxStackSize(16);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("DiamondArmorHead");
	}

}
