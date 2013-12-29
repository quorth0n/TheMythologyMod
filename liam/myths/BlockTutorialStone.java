package liam.myths;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockTutorialStone extends Block{

	public BlockTutorialStone(int par1, Material par2Material) {
		super(par1, par2Material);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(10F);
		setUnlocalizedName("tutStone");
		func_111022_d("mythologymod:heiroglyphics");
	}
	

}
