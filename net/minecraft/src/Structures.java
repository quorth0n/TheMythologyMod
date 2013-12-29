/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package net.minecraft.src;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Structures extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			Block.sand.blockID,
			Block.dirt.blockID,
			Block.grass.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 0){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public Structures() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 8, j, k) || !LocationIsValidSpawn(world, i + 8, j, k + 7) || !LocationIsValidSpawn(world, i, j, k + 7))
		{
			return false;
		}

		//world.setBlockMetadataWithNotify(i + 0, j + 0, k + 0, -128, 2);
		//world.setBlock(i + 0, j + 0, k + 1, -128);
		//world.setBlock(i + 0, j + 0, k + 2, -128);
		//world.setBlock(i + 0, j + 0, k + 3, -128);
		//world.setBlock(i + 0, j + 0, k + 4, -128);
		//world.setBlock(i + 0, j + 0, k + 5, -128);
		//world.setBlock(i + 0, j + 0, k + 6, -128);
		//world.setBlock(i + 0, j + 0, k + 7, -128);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 0, j + 9, k + 7, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 1, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 2, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 3, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 4, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 5, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 0, k + 6, Block.sandStone.blockID, 2);
		//world.setBlockMetadataWithNotify(i + 1, j + 0, k + 7, -128, 3);
		world.setBlock(i + 1, j + 1, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 1, k + 5, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 1, j + 1, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 2, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 1, j + 3, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 3, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 3, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 3, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 3, k + 5, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 1, j + 3, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 4, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 4, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 4, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 4, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 4, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 4, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 1, j + 5, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 5, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 5, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 5, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 5, k + 5, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 1, j + 6, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 1, j + 6, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 6, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 6, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 6, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 6, k + 6, Block.sandStone.blockID, 2);
		world.setBlock(i + 1, j + 7, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 7, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 7, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 7, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 7, k + 5, Block.sandStone.blockID);
		world.setBlock(i + 1, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 1, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 10, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 10, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 10, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 10, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 10, k + 6, Block.sandStone.blockID, 1);
	//	world.setBlockMetadataWithNotify(i + 2, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 2, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 3, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 4, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 5, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 0, k + 6, Block.sandStone.blockID, 2);
	//	world.setBlockMetadataWithNotify(i + 2, j + 0, k + 7, -128, 3);
		world.setBlock(i + 2, j + 1, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 2, j + 1, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 2, j + 1, k + 3, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 5, Block.chest.blockID, 5);
		world.setBlockMetadataWithNotify(i + 2, j + 1, k + 6, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 1, Block.sandStone.blockID, 1);
	//	world.setBlockMetadataWithNotify(i + 2, j + 2, k + 2, -128, 1);
		world.setBlock(i + 2, j + 2, k + 3, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 2, j + 2, k + 6, Block.sandStone.blockID, 2);
		world.setBlock(i + 2, j + 3, k + 1, Block.sandStone.blockID);
		//world.setBlockMetadataWithNotify(i + 2, j + 3, k + 3, -128, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 3, k + 6, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 2, j + 4, k + 1, Block.sandStone.blockID, 1);
		world.setBlock(i + 2, j + 4, k + 6, Block.sandStone.blockID);
		world.setBlock(i + 2, j + 5, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 2, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 2, j + 6, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 6, k + 2, Block.sandStone.blockID, 1);
		//world.setBlock(i + 2, j + 6, k + 5, -123);
		world.setBlockMetadataWithNotify(i + 2, j + 6, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 2, j + 7, k + 1, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 2, j + 7, k + 5, Block.chest.blockID, 2);
		world.setBlock(i + 2, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 2, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 10, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 11, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 11, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 11, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 2, j + 11, k + 5, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 3, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 2, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 3, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 4, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 5, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 0, k + 6, Block.sandStone.blockID, 2);
		//world.setBlockMetadataWithNotify(i + 3, j + 0, k + 7, -128, 3);
		world.setBlock(i + 3, j + 1, k + 1, Block.sandStone.blockID);
		//world.setBlockMetadataWithNotify(i + 3, j + 1, k + 2, -128, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 1, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 2, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 3, j + 3, k + 1, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 3, j + 3, k + 6, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 4, k + 1, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 3, j + 4, k + 5, -128, 2);
		world.setBlockMetadataWithNotify(i + 3, j + 4, k + 6, Block.sandStone.blockID, 2);
		world.setBlock(i + 3, j + 5, k + 1, Block.sandStone.blockID);
		//world.setBlockMetadataWithNotify(i + 3, j + 5, k + 2, -128, 3);
		world.setBlock(i + 3, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 3, j + 6, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 6, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 3, j + 7, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 3, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 3, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 10, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 11, k + 2, Block.sandStone.blockID, 1);
		world.setBlock(i + 3, j + 11, k + 3, Block.glowStone.blockID);
		world.setBlock(i + 3, j + 11, k + 4, Block.glowStone.blockID);
		world.setBlockMetadataWithNotify(i + 3, j + 11, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 12, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 3, j + 12, k + 4, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 4, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 4, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlock(i + 4, j + 0, k + 2, Block.glowStone.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.glowStone.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.glowStone.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.glowStone.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.glowStone.blockID);
		//world.setBlockMetadataWithNotify(i + 4, j + 0, k + 7, -128, 3);
		world.setBlock(i + 4, j + 1, k + 1, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 4, j + 2, k + 1, Block.sandStone.blockID, 1);
		world.setBlock(i + 4, j + 3, k + 1, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 4, j + 3, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 4, k + 1, Block.sandStone.blockID, 1);
		world.setBlock(i + 4, j + 4, k + 5, Block.glowStone.blockID);
		world.setBlockMetadataWithNotify(i + 4, j + 4, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 4, j + 5, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 4, j + 5, k + 2, Block.glowStone.blockID);
		world.setBlock(i + 4, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 4, j + 6, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 6, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 4, j + 7, k + 1, Block.sandStone.blockID);
		//world.setBlock(i + 4, j + 7, k + 5, -123);
		world.setBlock(i + 4, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 4, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 8, k + 5, Block.cloth.blockID, 6);
		world.setBlockMetadataWithNotify(i + 4, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 10, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 11, k + 2, Block.sandStone.blockID, 1);
		world.setBlock(i + 4, j + 11, k + 3, Block.glowStone.blockID);
		world.setBlock(i + 4, j + 11, k + 4, Block.glowStone.blockID);
		world.setBlockMetadataWithNotify(i + 4, j + 11, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 12, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 12, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 13, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 4, j + 13, k + 4, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 5, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 2, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 3, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 4, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 5, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 0, k + 6, Block.sandStone.blockID, 2);
		//world.setBlockMetadataWithNotify(i + 5, j + 0, k + 7, -128, 3);
		world.setBlock(i + 5, j + 1, k + 1, Block.sandStone.blockID);
		//world.setBlock(i + 5, j + 1, k + 2, -128);
		world.setBlockMetadataWithNotify(i + 5, j + 1, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 2, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 2, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 5, j + 3, k + 1, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 5, j + 3, k + 6, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 4, k + 1, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 5, j + 4, k + 5, -128, 2);
		world.setBlockMetadataWithNotify(i + 5, j + 4, k + 6, Block.sandStone.blockID, 2);
		world.setBlock(i + 5, j + 5, k + 1, Block.sandStone.blockID);
		//world.setBlockMetadataWithNotify(i + 5, j + 5, k + 2, -128, 3);
		world.setBlock(i + 5, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 5, j + 6, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 6, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 5, j + 7, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 5, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 5, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 10, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 11, k + 2, Block.sandStone.blockID, 1);
		world.setBlock(i + 5, j + 11, k + 3, Block.glowStone.blockID);
		world.setBlock(i + 5, j + 11, k + 4, Block.glowStone.blockID);
		world.setBlockMetadataWithNotify(i + 5, j + 11, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 12, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 5, j + 12, k + 4, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 6, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 2, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 3, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 4, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 5, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 0, k + 6, Block.sandStone.blockID, 2);
		//world.setBlockMetadataWithNotify(i + 6, j + 0, k + 7, -128, 3);
		world.setBlock(i + 6, j + 1, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 6, j + 1, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 6, j + 1, k + 3, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 6, j + 1, k + 5, Block.chest.blockID, 4);
		world.setBlockMetadataWithNotify(i + 6, j + 1, k + 6, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 1, Block.sandStone.blockID, 1);
		//world.setBlock(i + 6, j + 2, k + 2, -128);
		world.setBlock(i + 6, j + 2, k + 3, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 6, j + 2, k + 6, Block.sandStone.blockID, 2);
		world.setBlock(i + 6, j + 3, k + 1, Block.sandStone.blockID);
		//world.setBlockMetadataWithNotify(i + 6, j + 3, k + 3, -128, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 3, k + 6, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 6, j + 4, k + 1, Block.sandStone.blockID, 1);
		world.setBlock(i + 6, j + 4, k + 6, Block.sandStone.blockID);
		world.setBlock(i + 6, j + 5, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 6, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 6, j + 6, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 6, k + 2, Block.sandStone.blockID, 1);
		//world.setBlock(i + 6, j + 6, k + 5, -123);
		world.setBlockMetadataWithNotify(i + 6, j + 6, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 6, j + 7, k + 1, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 6, j + 7, k + 5, Block.chest.blockID, 2);
		world.setBlock(i + 6, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 6, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 10, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 11, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 11, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 11, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 6, j + 11, k + 5, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 7, j + 0, k + 0, -128, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 2, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 3, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 4, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 5, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 0, k + 6, Block.sandStone.blockID, 2);
		//world.setBlockMetadataWithNotify(i + 7, j + 0, k + 7, -128, 3);
		world.setBlock(i + 7, j + 1, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 1, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 1, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 1, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 1, k + 5, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 7, j + 1, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 2, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 2, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 2, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 2, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 2, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 2, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 7, j + 3, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 3, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 3, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 3, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 3, k + 5, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 7, j + 3, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 4, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 4, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 4, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 4, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 4, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 4, k + 6, Block.sandStone.blockID, 1);
		world.setBlock(i + 7, j + 5, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 5, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 5, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 5, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 5, k + 5, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 5, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 7, j + 6, k + 1, Block.sandStone.blockID, 2);
		world.setBlockMetadataWithNotify(i + 7, j + 6, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 6, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 6, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 6, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 6, k + 6, Block.sandStone.blockID, 2);
		world.setBlock(i + 7, j + 7, k + 1, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 7, k + 2, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 7, k + 3, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 7, k + 4, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 7, k + 5, Block.sandStone.blockID);
		world.setBlock(i + 7, j + 7, k + 6, Block.sandStone.blockID);
		world.setBlockMetadataWithNotify(i + 7, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 10, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 10, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 10, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 10, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 10, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 7, j + 10, k + 6, Block.sandStone.blockID, 1);
		//world.setBlockMetadataWithNotify(i + 8, j + 0, k + 0, -128, 2);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 1, -128, 1);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 2, -128, 1);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 3, -128, 1);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 4, -128, 1);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 5, -128, 1);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 6, -128, 1);
//		world.setBlockMetadataWithNotify(i + 8, j + 0, k + 7, -128, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 8, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 0, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 1, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 2, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 3, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 4, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 5, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 6, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 8, j + 9, k + 7, Block.sandStone.blockID, 1);
		world.setBlockMetadataWithNotify(i + 1, j + 9, k + 1, Block.torchWood.blockID, 3);
		world.setBlockMetadataWithNotify(i + 1, j + 9, k + 6, Block.torchWood.blockID, 4);
		world.setBlockMetadataWithNotify(i + 4, j + 9, k + 1, Block.torchWood.blockID, 3);
		world.setBlockMetadataWithNotify(i + 4, j + 9, k + 6, Block.torchWood.blockID, 4);
		world.setBlockMetadataWithNotify(i + 7, j + 9, k + 1, Block.torchWood.blockID, 3);
		world.setBlockMetadataWithNotify(i + 7, j + 9, k + 6, Block.torchWood.blockID, 4);

		return true;
	}
}