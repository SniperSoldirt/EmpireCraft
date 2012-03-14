package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

public class EntityHumanVillager extends EntityCreature
{
    public EntityHumanVillager(World world)
    {
            super(world);
            texture = "/mob/char.png";
            moveSpeed = 0.5F;
            //attackStrength = 4; //take this line out if this class doesn't extend EntityMob.
    }
    
    public boolean interact(EntityPlayer player)
    {
    	
    	ItemStack itemstack = player.inventory.getCurrentItem();
    	
    	if (itemstack != null && itemstack.itemID == Block.planks.blockID)
        {
            
            EntityHumanGatherer humanGatherer = new EntityHumanGatherer(worldObj);
            humanGatherer.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
            worldObj.spawnEntityInWorld(humanGatherer);
            
            this.setEntityDead();
            
            itemstack.stackSize--;
            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            }
            
            return true;
            
        }
        else
        {
            return super.interact(player);
        }
        
    }

    public int getMaxHealth()
    {
            return 15;
    }

    protected String getLivingSound()
    {
            return "mob.villager.default";
    }

    protected String getHurtSound()
    {
            return "mob.villager.defaulthurt";
    }

    protected String getDeathSound()
    {
            return "mob.villager.defaultdeath";
    }

    protected int getDropItemId()
    {
            return Item.ingotIron.shiftedIndex;
    }
    
    protected boolean canDespawn()
    {
            return false;
    }
    
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

}
