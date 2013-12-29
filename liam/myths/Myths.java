package liam.myths;

import java.util.Random;
import net.minecraftforge.common.EnumHelper;
import liam.myths.dimension.egypt.BiomeGen;
import liam.myths.dimension.egypt.WorldProviderEgypt;
import liam.myths.entity.egypt.EntityMummy;
import liam.myths.item.*;
import liam.myths.server.CommonProxy;

//import com.Dimension.gen.MainOreGen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.src.WorldGenSpawn;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="TheMythologyMod", name="The Mythology Mod", version="0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Myths
{
	public Random ChunkGenRand;// = new Random();
	public int ChunkGenRandNum;// = ChunkGenRand.nextInt(4)+1;
	/** EnumToolMaterials **/
	public static EnumToolMaterial KOPESH= EnumHelper.addToolMaterial("KOPESH", 3, 1700, 11F, 2.5F, 12);
	
	/** Dimension ID **/
	public static final int DimID2 = 3;
	public static int DimID = 2;

	/** Blocks **/
	public static BlockTutorialFire TutorialFire = (BlockTutorialFire)new BlockTutorialFire(2008).setUnlocalizedName("Tuturial:Tutorialfire_0");
	public static BlockTutorialPortal TutorialPortal = (BlockTutorialPortal)new BlockTutorialPortal(2009).setUnlocalizedName("Tutorial:TutorialPortal");
	public static BlockGreecePortal GreecePortal = (BlockGreecePortal)new BlockGreecePortal(2010).setUnlocalizedName("Tutorial:GreecePortal");
	public static Block TutorialGrass = new BlockTutorialGrass(200).setUnlocalizedName("Tutorial:grassSide");
	public static Block TutorialDirt = new BlockTutorialDirt(201, Material.grass).setUnlocalizedName("Tutorial:Dirt");
	public static Block TutorialStone = new BlockTutorialStone(202, Material.rock);
	//public static Block Limestone = new BlockLimestone(203, Material.rock);
	/** Items **/
	public static Item ScarabGem = new ItemTutorialFlintAndSteel(3047).setUnlocalizedName("Tutorial:ScarabGem");
	public static Item TutorialPortalPlacer = new ItemPortalPlacer(3048).setUnlocalizedName("Tutorial:TutorialPortalPlacer");
	public static Item WandExplode = new ItemHaDiWand(3049);
	//public static Item WandLight = new ItemRaWand(3050);
	public static Item WandFire = new ItemFireWand(3051);
	public static Item WandLightning = new ItemThehenWand(3052);
	//public static Item WandUndead = new ItemAmentaWand(3053);
	public static Item SwordKopesh = new ItemKopesh(3054, KOPESH);

	/** Item Stacks **/
	ItemStack diamondStack = new ItemStack(Item.diamond);
	ItemStack stickStack = new ItemStack(Item.stick);
	ItemStack goldStack = new ItemStack(Item.ingotGold);
	ItemStack scarabStack = new ItemStack(Myths.ScarabGem);
	ItemStack lapisStack = new ItemStack(Item.dyePowder, 2, 4);
	ItemStack ironStack = new ItemStack(Item.ingotIron);

	/** Biomes **/
	public static final BiomeGenBase TutorialBiome = new BiomeGen(25);
	//public static final BiomeGenBase GreeceBiome = new BiomeGenGreece(26);
	
	@SidedProxy(clientSide="liam.myths.client.ClientProxy", serverSide="liam.myths.server.CommonProxy")
    public static CommonProxy proxy;
	
	 // The instance of your mod that Forge uses.
    @Instance(value = "TheMythologyMod")
    public static Myths instance;
    
    @EventHandler // used in 1.6.2
    //@PreInit    // used in 1.5.2
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }

	@Init
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new WorldGeneratorYourStructure());

		//MOBS
		proxy.registerRenderers();
		
		
		/** Creating the Recipes **/
		GameRegistry.addRecipe(new ItemStack(Myths.WandExplode), "gdg", "dsd",
				"jsj", 'g', goldStack, 'd', diamondStack, 's', stickStack, 'j',
				scarabStack);
		
		GameRegistry.addRecipe(new ItemStack(Myths.WandFire), "dgd", "gsg", "jsj",
				'g', goldStack, 'd', diamondStack, 's', stickStack, 'j', 
				scarabStack);
		
		GameRegistry.addRecipe(new ItemStack(Myths.WandLightning), "d d", " s ",
				"jsj", 'd', diamondStack, 's', stickStack, 'j', scarabStack);
		
		GameRegistry.addRecipe(scarabStack, "lgl", "lll", "g g", 'l', lapisStack, 
				'g', goldStack);
		
		GameRegistry.addRecipe(new ItemStack(Myths.SwordKopesh), "iii", "i i", 
				"  s", 'i', ironStack, 's', stickStack);

		/** Register Blocks **/
		GameRegistry.registerBlock(TutorialFire, "TutorialFire");
		GameRegistry.registerBlock(TutorialPortal, "TutorialPortal");
		GameRegistry.registerBlock(TutorialGrass, "ExtraGrass");
		GameRegistry.registerBlock(TutorialDirt, "ExtraDirt");
		GameRegistry.registerBlock(TutorialStone, "TutorialStone");
		/** Register Items **/
		GameRegistry.registerItem(ScarabGem, "TutorialFlintAndSteel");
		GameRegistry.registerItem(TutorialPortalPlacer, "TutorialPortalPlacer");
		GameRegistry.registerItem(WandExplode, "HaDiWand");
		//GameRegistry.registerItem(WandLight, "RaWand");
		GameRegistry.registerItem(WandFire, "AmatWand");
		GameRegistry.registerItem(WandLightning, "ThehenWand");
		//GameRegistry.registerItem(WandUndead, "AmentaWand");
		GameRegistry.registerItem(SwordKopesh, "KopeshSword");
		/** Add In-Game Names **/
		//LanguageRegistry.addName(TutorialGrass, "Tutorial Grass");
		//LanguageRegistry.addName(TutorialDirt, "Tutorial Dirt");
		LanguageRegistry.addName(TutorialStone, "Heiroglyphics");
		LanguageRegistry.addName(TutorialFire, "Scarab Fire");
		LanguageRegistry.addName(TutorialPortal, "Egypt Portal");
		LanguageRegistry.addName(ScarabGem, "Scarab Jewel");
		LanguageRegistry.addName(TutorialPortalPlacer, "Portal Placer");
		LanguageRegistry.addName(WandExplode, "Ha-Di Wand");
		//LanguageRegistry.addName(WandLight, "Ra Wand");
		LanguageRegistry.addName(WandFire, "A'max Wand");
		LanguageRegistry.addName(WandLightning, "Thehen Wand");
		//LanguageRegistry.addName(WandUndead, "Amenta Wand");
		LanguageRegistry.addName(SwordKopesh, "Khopesh");
		/**Register WorldProvider for Dimension **/
		DimensionManager.registerProviderType(DimID, WorldProviderEgypt.class, true);
		DimensionManager.registerDimension(DimID, DimID);
		
		//DimensionManager.registerProviderType(DimID2, WorldProviderGreece.class, true);
		//DimensionManager.registerDimension(DimID2, DimID2);
		//NPCs
		//Zeus
		//registerEntity(EntityMummy.class, "Mummy", 0xeaeae9, 0xc99a03);
		//LanguageRegistry.instance().addStringLocalization("entity.Mummy.name", "Mummy");

		//MULTIPLAYER ABILITY
		//NetworkRegistry.instance().registerGuiHandler(this, (IGuiHandler) proxy); //Registers the class that deals with GUI data

	}

	public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
		//int id = EntityRegistry.findGlobalUniqueEntityId();

		//EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
		//EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
	}

	public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0) {
			//EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
			//GameRegistry.registerWorldGenerator(new WorldGeneratorYourStructure());

			
		}
	}
}

		/*public void GenerateSurface(World world, Random rand, int i, int j){
		ChunkGenRand = new Random();
		ChunkGenRandNum = ChunkGenRand.nextInt(90)+1;

		if(ChunkGenRandNum==1) {
			for (int k = 0; k < 2; k++){
				int RandPosX = i + rand.nextInt(16);
				int RandPosZ = j + rand.nextInt(16);
				int j1 = world.getHeightValue(RandPosX, RandPosZ);
				(new WorldGenSpawn()).generate(world, rand, RandPosX, j1, RandPosZ);

			}

		}

	}
	}
}*/

/*package liam.myths; //The package your mod is in

import liam.myths.entity.egypt.EntityMummy;
import liam.myths.server.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
//import fisherman77.zeuscraft.common.mobs.olympus.EntityZeus;
//need to import render class too. already deleted it up here for organization -- woops

@NetworkMod(clientSideRequired=true,serverSideRequired=true)//, //Whether client side and server side are needed
//clientPacketHandlerSpec = @SidedPacketHandler(channels = {"Zeuscraft"}, packetHandler = ZeuscraftClientPacketHandler.class), //For clientside packet handling
//serverPacketHandlerSpec = @SidedPacketHandler(channels = {"Zeuscraft"}, packetHandler = ZeuscraftServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="Zeuscraft",name="Zeuscraft",version="Dev Build")

public class Myths {

@Instance("Zeuscraft") //The instance, this is very important later on
public static Myths instance = new Myths();

@SidedProxy(clientSide = "fisherman77.zeuscraft.client.ZeuscraftClientProxy", serverSide = "fisherman77.zeuscraft.common.ZeuscraftCommonProxy") //Tells Forge the location of your proxies
public static CommonProxy proxy;

@PreInit
public void PreInit(FMLPreInitializationEvent e){

}

@Init
public void InitZeuscraft(FMLInitializationEvent event){ //Your main initialization method

//MOBS
proxy.registerRenderers();

//NPCs
//Zeus
registerEntity(EntityMummy.class, "Zeus", 0xeaeae9, 0xc99a03);
LanguageRegistry.instance().addStringLocalization("entity.Zeus.name", "Zeus");

//MULTIPLAYER ABILITY
NetworkRegistry.instance().registerGuiHandler(this, (IGuiHandler) proxy); //Registers the class that deals with GUI data

}

public void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
int id = EntityRegistry.findGlobalUniqueEntityId();

EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id, bkEggColor, fgEggColor));
}

public void addSpawn(Class<? extends EntityLiving> entityClass, int spawnProb, int min, int max, BiomeGenBase[] biomes) {
if (spawnProb > 0) {
EntityRegistry.addSpawn(entityClass, spawnProb, min, max, EnumCreatureType.creature, biomes);
}
}
}*/