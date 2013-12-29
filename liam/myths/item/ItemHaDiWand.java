package liam.myths.item;

import java.util.Random;

import liam.myths.Myths;
import liam.myths.entity.item.EntityHaDi;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHaDiWand extends Item{

	Random rand = new Random();
	
	public ItemHaDiWand(int par1) {
		super(par1);

		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName("wandExplode");
		this.func_111206_d("mythologymod:wandExplode");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		// if (par3EntityPlayer.capabilities.isCreativeMode)
		// {
		//     return par1ItemStack;
		//  }
		//  else
		//   {
		//par3EntityPlayer.setEntityHealth(par3EntityPlayer.func_110143_aJ() - 2);
		par1ItemStack.damageItem(1, par3EntityPlayer);
		par2World.playSoundAtEntity(par3EntityPlayer, "ambient.weather.thunder", 1.0F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(new EntityHaDi(par2World, par3EntityPlayer));
		}

		return par1ItemStack;
	}

	/*@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		int  n = rand.nextInt(4) + 1;
		switch (n) {
		
		case 1: player.setEntityHealth(player.func_110143_aJ() - 20);
				player.addChatMessage("Set frowns apon you!");
				
		case 2: player.setEntityHealth(player.func_110143_aJ() - 10);
				player.addChatMessage("Set would never look " +
						"apon a mortal like you!");
				
		case 3: player.setEntityHealth(player.func_110143_aJ() - 5);
				player.addChatMessage("In time, mortal.");
		
		case 4: player.setEntityHealth(player.func_110143_aJ() + 2);
				player.addChatMessage("Set looks in favor apon you!");
		
		}
		
		return true;
		
	}*/

	 
	 /*public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		{
			if (par7 == 0)
			{
				par5--;
			}
			if (par7 == 1)
			{
				par5++;
			}
			if (par7 == 2)
			{
				par6--;
			}
			if (par7 == 3)
			{
				par6++;
			}
			if (par7 == 4)
			{
				par4--;
			}
			if (par7 == 5)
			{
				par4++;
			}
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			{
				return false;
			}
			
			int i1 = par3World.getBlockId(par4, par5, par6);
			if (i1 == 0)
			{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				/** replace with your fire block **/
				/*par3World.setBlock(par4, par5, par6, Myths.TutorialFire.blockID);
			}
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}*/

}
