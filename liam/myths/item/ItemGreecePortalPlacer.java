package liam.myths.item;
import liam.myths.Myths;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemGreecePortalPlacer extends Item
{
	public ItemGreecePortalPlacer(int par1)
	{
		super(par1);
		setCreativeTab(CreativeTabs.tabTools);
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int X, int Y, int Z, int par7, float par8, float par9, float par10)
	{
		if (!par3World.isRemote)
		{
			int direction = MathHelper.floor_double(par2EntityPlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
			if ((direction == 1) || (direction == 3))
			{
				for (int y = 1; y < 5; y++)
				{
					for (int z = -1; z < 2; z++)
					{
						if (par3World.getBlockId(X, Y + y, Z + z) != 0)
						{
							par2EntityPlayer.addChatMessage("No room for a portal.");
							return false;
						}
					}
				}
				par3World.setBlock(X, Y + 1, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 1, Y + 1, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X, Y + 2, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 1, Y + 2, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 2, Y + 2, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 1, Y + 2, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 3, Y + 3, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 2, Y + 3, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 2, Y + 3, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X - 1, Y + 3, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 3, Y + 4, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 2, Y + 4, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 2, Y + 4, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X - 1, Y + 4, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 3, Y + 5, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 2, Y + 5, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 2, Y + 5, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X - 1, Y + 5, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 2, Y + 6, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 1, Y + 6, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X, Y + 7, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 1, Y + 7, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X, Y + 6, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 1, Y + 6, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X, Y + 3, Z, Myths.TutorialFire.blockID);
			}
			else
			{
				for (int y = 1; y < 5; y++)
				{
					for (int x = -1; x < 2; x++)
					{
						if (par3World.getBlockId(X + x, Y + y, Z) != 0)
						{
							par2EntityPlayer.addChatMessage("No room for a portal.");
							return false;
						}
					}
				}
				par3World.setBlock(X, Y + 1, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 1, Y + 1, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X, Y + 2, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 1, Y + 2, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 2, Y + 2, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 1, Y + 2, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 3, Y + 3, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 2, Y + 3, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 2, Y + 3, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X - 1, Y + 3, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 3, Y + 4, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 2, Y + 4, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 2, Y + 4, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X - 1, Y + 4, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 3, Y + 5, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 2, Y + 5, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 2, Y + 5, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X - 1, Y + 5, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 2, Y + 6, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X - 1, Y + 6, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X, Y + 7, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X + 1, Y + 7, Z, Block.blockEmerald.blockID);
				par3World.setBlock(X, Y + 6, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X + 1, Y + 6, Z, Block.blockNetherQuartz.blockID);
				par3World.setBlock(X, Y + 3, Z, Myths.TutorialFire.blockID);
			}
			return true;
		}
		return true;
	}
}