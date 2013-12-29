package liam.myths.item;

import liam.myths.entity.item.EntityAmenta;
import liam.myths.entity.item.EntityHaDi;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmentaWand extends Item {

	public ItemAmentaWand(int par1) {
		super(par1);
		
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("wandUndead");
		this.func_111206_d("mythologymod:wandUndead");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par1ItemStack.damageItem(1, par3EntityPlayer);
		par2World.playSoundAtEntity(par3EntityPlayer, "ambient.weather.thunder", 1.0F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(new EntityAmenta(par2World, par3EntityPlayer));
		}

		return par1ItemStack;
	}
}
