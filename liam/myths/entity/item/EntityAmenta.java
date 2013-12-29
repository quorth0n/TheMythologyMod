package liam.myths.entity.item;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityAmenta extends EntityThrowable {
	
	public EntityAmenta(World par1World)
    {
        super(par1World);
    }

    public EntityAmenta(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    @SideOnly(Side.CLIENT)
    public EntityAmenta(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        for (int i = 0; i < 32; ++i)
        {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if (!this.worldObj.isRemote)
        {
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.getThrower();

                if (!entityplayermp.playerNetServerHandler.connectionClosed && entityplayermp.worldObj == this.worldObj)
                {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!MinecraftForge.EVENT_BUS.post(event))
                    {
                        if (this.getThrower().isRiding())
                        {
                            this.getThrower().mountEntity((Entity)null);
                        }
    
                        spawnUndead();
                    }
                }
            }

            this.setDead();
        }
    }

	private void spawnUndead() {
		boolean spawnZombies = false;
		boolean spawnSkeletons = false;
		boolean spawnWitherSkeletons = false;
		boolean spawnCreepers = false;
		boolean spawnPigZombies = false;
		boolean spawnWither = false;
		Random rand = new Random();
		
		//10% chance to spawn a zombie
		if (90 > rand.nextInt(100) + 1){
			worldObj.spawnEntityInWorld(new EntityZombie(worldObj));
		}
		
		//15% chance to spawn a skeleton
		if (85 > rand.nextInt(100) + 1){
			worldObj.spawnEntityInWorld(new EntitySkeleton(worldObj));
		}
		
		//25% chance to spawn a creeper
		if (75 > rand.nextInt(100) + 1){
			worldObj.spawnEntityInWorld(new EntityCreeper(worldObj));
		}
		//5% chance to spawn a wither skeleton
		if (95 > rand.nextInt(100) + 1){
			worldObj.spawnEntityInWorld(new EntityWither(worldObj));
		}
	}
}

