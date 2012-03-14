package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

public class EntityHumanGatherer extends EntityCreature
{
	
	private static String name = "";
	private static int id;
	
	
    public EntityHumanGatherer(World world)
    {
    	
            super(world);
            texture = "/mob/pigman.png";
            moveSpeed = 0.5F;
            id = mod_EmpireCraft.getVillagerId();
            ModLoader.getMinecraftInstance().thePlayer.addChatMessage("ID:" + String.valueOf(id));
            ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Stage:" + String.valueOf(mod_EmpireCraft.playerStage));
			//attackStrength = 4; //take this line out if this class doesn't extend EntityMob.
    }
    
    public String getName()
    {
		
    	Random rand = new Random();
    	
    	final String name = nameList[rand.nextInt(nameList.length)];
    	
    	return name;
    	
    }
    
    public ItemStack getHeldItem()
    {
    	
    	//ItemStack defaultHeldItem = null;
    	ItemStack stick = new ItemStack(Item.stick, 1);
    	
    	//if (mod_EmpireCraft.playerStage == 1)
    	//{
    		return stick;
    	//}else
    	//{
    		//return defaultHeldItem;
    	//}
        
    }
    
    public boolean interact(EntityPlayer player)
    {
    	
    	ItemStack itemstack = player.inventory.getCurrentItem();
    	
    	if (itemstack != null && itemstack.itemID == Item.appleGold.shiftedIndex)
        {
            
    		mod_EmpireCraft.playerStage++;
    		
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
            return 20;
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
    
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }
    
    protected boolean canDespawn()
    {
            return false;
    } 
    
    String[] nameList = 
		{
			"AARON", "ABE", "ABRAHAM", "ADAM", "ADRIAN"
		};
    
}
