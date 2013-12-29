package liam.myths.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemKopesh extends ItemSword {

	public ItemKopesh(int id, EnumToolMaterial par2EnumToolMaterial) {
		super(id, par2EnumToolMaterial);
		
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("kopesh");
		func_111206_d("mythologymod:kopesh");
	}

}
