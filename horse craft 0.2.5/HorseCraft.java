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

@Mod(modid = "HorseCraft", name = "HorseCraft", version = "0.2.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
// not used in 1.7
public class HorseCraft
{

	//Added items
	public static Item tannedLeather;
	public static Item stirrups;
	public static Item diamondArmorBody;
	public static Item diamondArmorHead;
	public static Item goldArmorBody;
	public static Item goldArmorHead;
	public static Item ironArmorBody;
	public static Item ironArmorHead;
	
	//Item id's
	public static int tannedLeatherID;
	public static int stirrupsID;
	public static int diamondArmorBodyID;
	public static int diamondArmorHeadID;
	public static int goldArmorBodyID;
	public static int goldArmorHeadID;
	public static int ironArmorBodyID;
	public static int ironArmorHeadID;
	

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
		tannedLeather = new TannedLeather(tannedLeatherID).setTextureName("HorseCraft:tannedleather");
		stirrups = new Stirrups(stirrupsID).setTextureName("HorseCraft:stirrup");
		diamondArmorBody = new DiamondArmorBody(diamondArmorBodyID);
		diamondArmorHead = new DiamondArmorHead(diamondArmorHeadID);
		goldArmorBody = new GoldArmorBody(goldArmorBodyID);
		goldArmorHead = new GoldArmorHead(goldArmorHeadID);
		ironArmorBody = new IronArmorBody(ironArmorBodyID);
		ironArmorHead = new IronArmorHead(ironArmorHeadID);
		
		//register items
		GameRegistry.registerItem(tannedLeather, "Tanned Leather");
		GameRegistry.registerItem(stirrups, "Stirrups");
		GameRegistry.registerItem(diamondArmorBody, "Diamond Horse Armor Body");
		GameRegistry.registerItem(diamondArmorHead, "Diamond Horse Armor Head");
		GameRegistry.registerItem(goldArmorBody, "Gold Horse Armor Body");
		GameRegistry.registerItem(goldArmorHead, "Gold Horse Armor Head");
		GameRegistry.registerItem(ironArmorBody, "Iron Horse Armor Body");
		GameRegistry.registerItem(ironArmorHead, "Iron Horse Armor Head");
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
		
		//declare item ID's and save to config
		tannedLeatherID = config.get(Configuration.CATEGORY_ITEM, "TannedLeather", 5182).getInt();
		stirrupsID = config.get(Configuration.CATEGORY_ITEM, "Stirrups", 5183).getInt();
		diamondArmorBodyID = config.get(Configuration.CATEGORY_ITEM, "DiamondArmorBody", 5184).getInt();
		diamondArmorHeadID = config.get(Configuration.CATEGORY_ITEM, "DiamondArmorHead", 5185).getInt();
		goldArmorBodyID = config.get(Configuration.CATEGORY_ITEM, "GoldArmorBody", 5186).getInt();
		goldArmorHeadID = config.get(Configuration.CATEGORY_ITEM, "GoldArmorHead", 5187).getInt();
		ironArmorBodyID = config.get(Configuration.CATEGORY_ITEM, "IronArmorBody", 5188).getInt();
		ironArmorHeadID = config.get(Configuration.CATEGORY_ITEM, "IronArmorHead", 5189).getInt();
		
		config.save();
		
	}
	
	private void registerNames()
	{
		LanguageRegistry.addName(tannedLeather, "Tanned Leather");
		LanguageRegistry.addName(stirrups, "Stirrup");
		LanguageRegistry.addName(diamondArmorBody, "Diamond Horse Armor Body");
		LanguageRegistry.addName(diamondArmorHead, "Diamond Horse Armor Head");
		LanguageRegistry.addName(goldArmorBody, "Gold Horse Armor Body");
		LanguageRegistry.addName(goldArmorHead, "Gold Horse Armor Head");
		LanguageRegistry.addName(ironArmorBody, "Iron Horse Armor Body");
		LanguageRegistry.addName(ironArmorHead, "Iron Horse Armor Head");
	}
	
	private void craftingRecipies()
	{
		//Item/Block item stacks
		ItemStack ironStack = new ItemStack(Item.ingotIron);
		ItemStack goldStack = new ItemStack(Item.ingotGold);
		ItemStack stringStack = new ItemStack(Item.silk);
		ItemStack saddleStack = new ItemStack(Item.saddle);
		ItemStack leatherStack = new ItemStack(Item.leather);
		ItemStack signStack = new ItemStack(Item.sign);
		ItemStack ntStack = new ItemStack(Item.nameTag);
		ItemStack diamondStack = new ItemStack(Item.diamond);
		ItemStack woolStack = new ItemStack(Block.cloth);
		ItemStack diamondHA = new ItemStack(Item.horseArmorDiamond);
		ItemStack goldHA = new ItemStack(Item.horseArmorGold);
		ItemStack ironHA = new ItemStack(Item.horseArmorIron);
		
		
		//HorseCraft item stacks
		ItemStack tlStack = new ItemStack(HorseCraft.tannedLeather);
		ItemStack stirrupStack = new ItemStack(HorseCraft.stirrups, 2);
		ItemStack dab = new ItemStack(HorseCraft.diamondArmorBody);
		ItemStack dah = new ItemStack(HorseCraft.diamondArmorHead);
		ItemStack gab = new ItemStack(HorseCraft.goldArmorBody);
		ItemStack gah = new ItemStack(HorseCraft.goldArmorHead);
		ItemStack iab = new ItemStack(HorseCraft.ironArmorBody);
		ItemStack iah = new ItemStack(HorseCraft.ironArmorHead);
		
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
		
		//nametag recipe
		GameRegistry.addShapedRecipe(ntStack, "SSS", " I ", " T ",
				'S', stringStack, 'I', ironStack, 'T', signStack);
		
		//DIAMOND
		//horse body armor
		GameRegistry.addShapedRecipe(dab, "DDD", "DWD", "DDD",
				'D', diamondStack, 'W', woolStack);
		//horse head armor
		GameRegistry.addShapedRecipe(dah, "SDD", "DDD", "DDS",
				'S', stringStack, 'D', diamondStack);		
		//horse armor
		GameRegistry.addShapelessRecipe(diamondHA, dab, dah);
		//END DIAMOND
		
		//GOLD
		//body armor
		GameRegistry.addShapedRecipe(gab, "GGG", "GWG", "GGG",
				'G', goldStack, 'W', woolStack);
		//head armor
		GameRegistry.addShapedRecipe(gah, "SGG", "GGG", "GGS",
				'S', stringStack, 'G', goldStack);
		//armor
		GameRegistry.addShapelessRecipe(goldHA, gab, gah);		
		
		//END GOLD
		
		//IRON
		//body armor
		GameRegistry.addShapedRecipe(iab, "III", "IWI", "III",
				'I', ironStack, 'W', woolStack);
		//head armor
		GameRegistry.addShapedRecipe(iah, "SII", "III", "IIS",
				'S', stringStack, 'I', ironStack);
		//armor
		GameRegistry.addShapelessRecipe(ironHA, iab, iah);
		
		
		//END IRON
		
		
		
		
	}
}