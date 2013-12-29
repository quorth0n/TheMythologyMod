package liam.myths;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLimestone extends Block{

	public BlockLimestone(int par1, Material par2Material) {
		super(par1, par2Material);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(10F);
		setUnlocalizedName("limeStone");
	}
	

}