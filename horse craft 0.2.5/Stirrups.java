package org.mintymods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Stirrups extends Item
{

	public Stirrups(int id)
	{
		super(id);
		setMaxStackSize(8);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("Stirrups");
	}

}
