///*package net.minecraft.src;
//
//import java.util.Random;
//
//import cpw.mods.fml.common.IWorldGenerator;
//
//import net.minecraft.block.Block;
//import net.minecraft.world.World;
//import net.minecraft.world.chunk.IChunkProvider;
//import net.minecraft.world.gen.feature.WorldGenerator;
//
//public class WorldGenSpawn extends WorldGenerator{
//	
//	//The variables for beneath the pyramid
//	public boolean UnderBlock;
//	public int HeightCounter = 1;
//	
//	//Layer of the pyramid that is generating
//	public int LayerCounter = 0;
//	
//	public WorldGenSpawn(boolean par1){
//		super(par1);
//		
//	}
//
//
//	@Override
//	public boolean generate(World world, Random random, int i, int j, int k) {
//		//int blockPyramidIsOn = world.getBlockId(i, j, k);
//		//int l = blockPyramidIsOn;
//		
//		*//**The Pyramid can't spawn on lava or water, and can't spawn in air**//*
//		if (world.getBlockId(i, j, k) == Block.lavaMoving.blockID || 
//				world.getBlockId(i, j, k) == Block.lavaStill.blockID ||
//				world.getBlockId(i, j, k) == Block.waterMoving.blockID ||
//				world.getBlockId(i, j, k) == Block.waterStill.blockID ||
//				world.getBlockId(i, j + 1, k) != 0) {
//			
//			return false;
//		}
//		
//		*//**The Pyramid can only spawn on grass, sand, or dirt**//*
//		if (world.getBlockId(i, j, k) != Block.grass.blockID && 
//				world.getBlockId(i, j, k) != Block.sand.blockID && 
//				world.getBlockId(i, j, k) != Block.dirt.blockID) {
//			
//			return false;
//		}
//		
//		*//**Declaring the main block of the pyramid for easy use later on**//*
//		int block = Block.cobblestoneMossy.blockID;
//		
//		*//**3 for loops to create the Pyramid shape**//*
//		for (int q3 = 1; q3 <= 3; q3++){
//			
//			int w1 = LayerCounter * 2;
//			int w2 = LayerCounter - w1;
//			
//			for (int q1 = 1; q1 <= w2; q1++){
//				
//				for (int q2 = 1; q2 <= w2; q2++){
//					
//					int w3 = q1 + LayerCounter;
//					int w4 = q2 + LayerCounter;
//					
//					*//**Sets the depth counter**//*
//					HeightCounter = 1;
//					
//					*//**Check block under starting block when it's ready to place**//*
//					if (world.getBlockId(i + w3, j - 1, k = w4) != 0){
//						*//**Sets to true if block under starting Block is NOT air**//*
//						UnderBlock = true;
//					}
//					
//					if (world.getBlockId(i + w3, j - 1, k = w4) == 0){
//						*//**Sets to true if block under starting Block is NOT air**//*
//						UnderBlock = false;
//					}
//					
//					while (UnderBlock == false){
//						
//						*//**Place the block**//*
//						world.setBlock(i + w3, j - HeightCounter, k + w4, block);
//						
//						HeightCounter++;
//						
//						if (world.getBlockId(i + w3, j - HeightCounter, k = w4) != 0){
//							
//							UnderBlock = true;
//						}
//						
//					} //End while loop
//					
//					world.setBlock(i + w3, j, k+w4, block);
//					
//				} //End for loop 1
//				
//			} //End for loop 2
//			
//			j++;
//			LayerCounter++;
//			
//		}
//		
//		return true;
//	}
//}*/
//
//package net.minecraft.src;
//import java.util.Random;
//
//import liam.myths.Myths;
////import com.Brett.Dimension.blocks.BlockTutorialSapling;
////import com.Brett.Dimension.main.Main;
//import cpw.mods.fml.common.IWorldGenerator;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockSapling;
//import net.minecraft.util.Direction;
//import net.minecraft.world.World;
//import net.minecraft.world.chunk.IChunkProvider;
//import net.minecraft.world.gen.feature.WorldGenMinable;
//import net.minecraft.world.gen.feature.WorldGenerator;
//import net.minecraftforge.common.ForgeDirection;
//import net.minecraftforge.common.IPlantable;
//public class WorldGenSpawn extends WorldGenerator implements IWorldGenerator
//{
//	
//	//The variables for beneath the pyramid
//		public boolean UnderBlock;
//		public int HeightCounter = 1;
//		
//		//Layer of the pyramid that is generating
//		public int LayerCounter = 0;
//	/** The minimum height of a generated tree. */
//	private final int minTreeHeight;
//	/** True if this tree should grow Vines. */
//	private final boolean vinesGrow;
//	/** The metadata value of the wood to use in tree generation. */
//	private final int metaWood;
//	/** The metadata value of the leaves to use in tree generation. */
//	private final int metaLeaves;
//	public WorldGenSpawn(boolean par1)
//	{
//		this(par1, 8, 0, 0, false);
//	}
//	public WorldGenSpawn(boolean par1, int par2, int par3, int par4, boolean par5)
//	{
//		super(par1);
//		this.minTreeHeight = par2;
//		this.metaWood = par3;
//		this.metaLeaves = par4;
//		this.vinesGrow = par5;
//	}
//	/* (non-Javadoc)
//	 * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, int, int, int)
//	 */
//	public boolean generate(World world, Random par2Random, int i, int j, int k)
//	{
//		//**The Pyramid can't spawn on lava or water, and can't spawn in air**//*
//		if (world.getBlockId(i, j, k) == Block.lavaMoving.blockID || 
//				world.getBlockId(i, j, k) == Block.lavaStill.blockID ||
//				world.getBlockId(i, j, k) == Block.waterMoving.blockID ||
//				world.getBlockId(i, j, k) == Block.waterStill.blockID ||
//				world.getBlockId(i, j + 1, k) != 0) {
//			
//			return false;
//		}
//		
//		//**The Pyramid can only spawn on grass, sand, or dirt**//*
//		if (world.getBlockId(i, j, k) != Myths.TutorialGrass.blockID && 
//				world.getBlockId(i, j, k) != Myths.TutorialStone.blockID && 
//				world.getBlockId(i, j, k) != Myths.TutorialDirt.blockID) {
//			
//			return false;
//		}
//		
//		//**Declaring the main block of the pyramid for easy use later on**//*
//		int block = Block.cobblestoneMossy.blockID;
//		
//		//**3 for loops to create the Pyramid shape**//*
//		for (int q3 = 1; q3 <= 3; q3++){
//			
//			int w1 = LayerCounter * 2;
//			int w2 = LayerCounter - w1;
//			
//			for (int q1 = 1; q1 <= w2; q1++){
//				
//				for (int q2 = 1; q2 <= w2; q2++){
//					
//					int w3 = q1 + LayerCounter;
//					int w4 = q2 + LayerCounter;
//					
//					//**Sets the depth counter**//*
//					HeightCounter = 1;
//					
//					//**Check block under starting block when it's ready to place**//*
//					if (world.getBlockId(i + w3, j - 1, k = w4) != 0){
//						//**Sets to true if block under starting Block is NOT air**//*
//						UnderBlock = true;
//					}
//					
//					if (world.getBlockId(i + w3, j - 1, k = w4) == 0){
//						//**Sets to true if block under starting Block is NOT air**//*
//						UnderBlock = false;
//					}
//					
//					while (UnderBlock == false){
//						
//						//**Place the block**//*
//						world.setBlock(i + w3, j - HeightCounter, k + w4, block);
//						
//						HeightCounter++;
//						
//						if (world.getBlockId(i + w3, j - HeightCounter, k = w4) != 0){
//							
//							UnderBlock = true;
//						}
//						
//					} //End while loop
//					
//					world.setBlock(i + w3, j, k+w4, block);
//					
//				} //End for loop 1
//				
//			} //End for loop 2
//			
//			j++;
//			LayerCounter++;
//			
//		}
//		
//		return true;
//	}
//		/*int l = par2Random.nextInt(3) + this.minTreeHeight;
//		boolean flag = true;
//		if (par4 >= 1 && par4 + l + 1 <= 256)
//		{
//			int i1;
//			byte b0;
//			int j1;
//			int k1;
//			for (i1 = par4; i1 <= par4 + 1 + l; ++i1)
//			{
//				b0 = 1;
//				if (i1 == par4)
//				{
//					b0 = 0;
//				}
//				if (i1 >= par4 + 1 + l - 2)
//				{
//					b0 = 2;
//				}
//				for (int l1 = par3 - b0; l1 <= par3 + b0 && flag; ++l1)
//				{
//					for (j1 = par5 - b0; j1 <= par5 + b0 && flag; ++j1)
//					{
//						if (i1 >= 0 && i1 < 256)
//						{
//							k1 = par1World.getBlockId(l1, i1 -1, j1);
//							*//** Custom grass block **//*
//							Block block = Myths.TutorialGrass;
//							if (k1 != 0 && !block.isLeaves(par1World, l1, i1, j1)
//
//									*//** Custom grass block **//*
//									&& k1 != Myths.TutorialGrass.blockID
//									&& k1 != Block.dirt.blockID
//									&& !block.isWood(par1World, l1, i1, j1))
//							{
//								flag = false;
//							}
//						}
//						else
//						{
//							flag = false;
//						}
//					}
//				}
//			}
//			if (!flag)
//			{
//				return false;
//			}
//			else
//			{
//				i1 = par1World.getBlockId(par3, par4 - 1, par5);
//
//				*//** Custom grass block **//*
//				Block soil = Myths.TutorialGrass;
//
//				*//** Custom Sapling block **//*
//				boolean isSoil = false;//(soil != null && soil.canSustainPlant(par1World, par3, par4 - 1, par5, ForgeDirection.UP, (IPlantable)Myths.TutorialSapling));
//				if (isSoil && par4 < 256 - l - 1)
//				{
//					soil.onPlantGrow(par1World, par3, par4 - 1, par5, par3, par4, par5);
//					b0 = 3;
//					byte b1 = 0;
//					int i2;
//					int j2;
//					int k2;
//					for (j1 = par4 - b0 + l; j1 <= par4 + l; ++j1)
//					{
//						k1 = j1 - (par4 + l);
//						i2 = b1 + 1 - k1 / 2;
//						for (j2 = par3 - i2; j2 <= par3 + i2; ++j2)
//						{
//							k2 = j2 - par3;
//							for (int l2 = par5 - i2; l2 <= par5 + i2; ++l2)
//							{
//								int i3 = l2 - par5;
//								if (Math.abs(k2) != i2 || Math.abs(i3) != i2 || par2Random.nextInt(2) != 0 && k1 != 0)
//								{
//									int j3 = par1World.getBlockId(j2, j1, l2);
//									Block block = Block.blocksList[j3];
//									if (block == null || block.canBeReplacedByLeaves(par1World, j2, j1, l2))
//									{
//										*//** Custom leaf block **//*
//										this.setBlockAndMetadata(par1World, j2, j1, l2, Myths.TutorialLeaf.blockID, this.metaLeaves);
//									}
//								}
//							}
//						}
//					}
//					for (j1 = 0; j1 < l; ++j1)
//					{
//						k1 = par1World.getBlockId(par3, par4 + j1, par5);
//						Block block = Block.blocksList[k1];
//						if (k1 == 0 || block == null || block.isLeaves(par1World, par3, par4 + j1, par5))
//						{
//							*//** Custom Log block **//*
//							this.setBlockAndMetadata(par1World, par3, par4 + j1, par5, Myths.TutorialLog.blockID, this.metaWood);
//						}
//					}
//					if (par2Random.nextInt(5) == 0 && l > 5)
//					{
//						for (j1 = 0; j1 < 2; ++j1)
//						{
//							for (k1 = 0; k1 < 4; ++k1)
//							{
//								if (par2Random.nextInt(4 - j1) == 0)
//								{
//									i2 = par2Random.nextInt(3);
//									this.setBlockAndMetadata(par1World, par3 + Direction.offsetX[Direction.rotateOpposite[k1]], par4 + l - 5 + j1, par5 + Direction.offsetZ[Direction.rotateOpposite[k1]], Block.cocoaPlant.blockID, i2 << 2 | k1);
//								}
//							}
//						}
//					}
//				}
//				return true;
//			}
//		}
//		return flag;*/
//	
//	@Override
//	public void generate(Random random, int chunkX, int chunkZ, World world,
//			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
//	{
//		for(int i = 0; i < 10; i++)
//		{
//			int xCoord = chunkX + random.nextInt(16);
//			int yCoord = random.nextInt(16);
//			int zCoord = chunkZ + random.nextInt(16);
//
//			/** Custom WorldGenTutorialTree block **/
//			(new WorldGenSpawn(false, 9, 0, 0, false)).generate(world, random, xCoord, yCoord, zCoord);
//		}
//	}
//}