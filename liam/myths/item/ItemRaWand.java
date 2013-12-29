package liam.myths.item;

import liam.myths.entity.item.EntityHaDi;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRaWand extends Item{
	private boolean isOn = false;

	public ItemRaWand(int par1) {
		super(par1);
		
		this.maxStackSize = 1;
		//this.setMaxDamage(100);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName("wandLight");
	}
	
	/*public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode)
        {
            return par1ItemStack;
        }
        else
        {
            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityHaDi(par2World, par3EntityPlayer));
            }
            
            return par1ItemStack;
        }

    }*/
	
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		isOn = true;
		world.setBlock(x, y, z, Block.glowStone.blockID);
		return true;
    }
}


