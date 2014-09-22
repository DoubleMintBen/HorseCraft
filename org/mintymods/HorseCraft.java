package org.mintymods;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod; // not used in 1.7
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HorseCraft", name = "HorseCraft", version = "0.1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
// not used in 1.7
public class HorseCraft
{

	//Added items
	public static Item tannedLeather;
	public static Item stirrups;
	
	//Item id's
	public static int tannedLeatherID;
	public static int stirrupsID;
	

	// The instance of your mod that Forge uses.
	@Instance(value = "HorseCraft")
	public static HorseCraft instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = "org.mintymods.client.ClientProxy", serverSide = "org.mintymods.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//config
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		loadConfigs(config);
		
		//initialize items
		tannedLeather = new TannedLeather(tannedLeatherID).setTextureName("HorseCraft:tannedleather"); //smelting leather
		stirrups = new Stirrups(stirrupsID).setTextureName("HorseCraft:stirrup"); //crafted with 5 iron 2 strings
		GameRegistry.registerItem(tannedLeather, "Tanned Leather");
		GameRegistry.registerItem(stirrups, "Stirrups");
	}

	@EventHandler
	// used in 1.6.2
	public void load(FMLInitializationEvent event)
	{
		
		
		registerNames();
		
		proxy.registerRenderers();
		
		craftingRecipies();
	}

	@EventHandler
	// used in 1.6.2
	public void postInit(FMLPostInitializationEvent event)
	{
		// Stub Method
	}
	
	private void loadConfigs(Configuration config)
	{
		config.load();
		
		tannedLeatherID = config.get(Configuration.CATEGORY_ITEM, "TannedLeather", 5182).getInt();
		stirrupsID = config.get(Configuration.CATEGORY_ITEM, "Stirrups", 5183).getInt();
		
	}
	
	private void registerNames()
	{
		LanguageRegistry.addName(tannedLeather, "Tanned Leather");
		LanguageRegistry.addName(stirrups, "Stirrup");
	}
	
	private void craftingRecipies()
	{
		ItemStack ironStack = new ItemStack(Item.ingotIron);
		ItemStack stringStack = new ItemStack(Item.silk);
		ItemStack tlStack = new ItemStack(HorseCraft.tannedLeather);
		ItemStack stirrupStack = new ItemStack(HorseCraft.stirrups, 2);
		ItemStack saddleStack = new ItemStack(Item.saddle);
		ItemStack woolStack = new ItemStack(Block.cloth);
		ItemStack leatherStack = new ItemStack(Item.leather);
		
		//smelting rotten flesh
		GameRegistry.addSmelting(Item.rottenFlesh.itemID, leatherStack, .3f);
		
		//smelting leather
		GameRegistry.addSmelting(Item.leather.itemID, tlStack, .3f);
		
		//saddle recipe
		GameRegistry.addShapedRecipe(saddleStack, "TTT", "TWT", "U U",
				'T', tlStack, 'S', stringStack, 'U', stirrupStack, 'W', woolStack);
		
		//stirrup recipe
		GameRegistry.addShapedRecipe(stirrupStack, "SSS", "I I", "III",
				'S', stringStack, 'I', ironStack);
	}
}