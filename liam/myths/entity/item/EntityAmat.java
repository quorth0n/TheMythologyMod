package liam.myths.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityAmat extends EntityThrowable {

	public EntityAmat(World par1World)
    {
        super(par1World);
    }

    public EntityAmat(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    @SideOnly(Side.CLIENT)
    public EntityAmat(World par1World, double par2, double par4, double par6)
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
                        
                        explodeIntoFlames();
                
                        //EntityLightningBolt var11 = new EntityLightningBolt(worldObj, this.posX, this.posY, this.posZ);
                        //strikeWithLightning();
                    }
                }
            }

            this.setDead();
        }
    }

	private void explodeIntoFlames() {
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 0.3F, true);
		
		//Thing in the middle~
		this.worldObj.setBlock(((int)posX), ((int)posY), ((int)posZ), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 1), ((int)posY), ((int)posZ - 1), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 1), ((int)posY), ((int)posZ - 1), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 1), ((int)posY), ((int)posZ + 1), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 1), ((int)posY), ((int)posZ + 1), Block.fire.blockID);
		
		//Left Eye
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ - 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ - 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ - 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ - 3), Block.fire.blockID);
		
		//Right Eye
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ - 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ - 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ - 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ - 3), Block.fire.blockID);
		
		//Mouth
	//	this.worldObj.setBlock(((int)posX + 5), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
	//	this.worldObj.setBlock(((int)posX + 4), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
	//	this.worldObj.setBlock(((int)posX + 5), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
	//	this.worldObj.setBlock(((int)posX + 4), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 1), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 1), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ + 4), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ + 5), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 3), ((int)posY), ((int)posZ + 6), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ + 4), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ + 5), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX + 2), ((int)posY), ((int)posZ + 6), Block.fire.blockID);
		
		this.worldObj.setBlock(((int)posX), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 1), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 1), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		//this.worldObj.setBlock(((int)posX - 4), ((int)posY), ((int)posZ + 2), Block.fire.blockID);
		//this.worldObj.setBlock(((int)posX - 4), ((int)posY), ((int)posZ + 3), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ + 4), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ + 5), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 3), ((int)posY), ((int)posZ + 6), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ + 4), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ + 5), Block.fire.blockID);
		this.worldObj.setBlock(((int)posX - 2), ((int)posY), ((int)posZ + 6), Block.fire.blockID);
		
		//**Marker**
		
	}

	
}
