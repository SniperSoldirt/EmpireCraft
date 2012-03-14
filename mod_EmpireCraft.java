package net.minecraft.src;

import java.util.Map;

public class mod_EmpireCraft extends BaseMod
{

	static int highestVillagerId = -1;
	static int playerStage;
	
	@Override
	public void load()
    {       
            ModLoader.registerEntityID(EntityHumanVillager.class, "Human", ModLoader.getUniqueEntityId());
            ModLoader.addSpawn(EntityHumanVillager.class, 12, 14, 18, EnumCreatureType.creature);
    }
	
	public void addRenderer(Map map)
    {
            map.put(EntityHumanVillager.class, new RenderBiped(new ModelBiped(), 0.5F));
    }

	public static int getVillagerId()
	{
		
		highestVillagerId++;
		
		return highestVillagerId;
		
	}
	
	public static void upgradePlayerStage()
	{
		playerStage++;
	}

	@Override
	public String getVersion()
    {
            return "1.2.3";
    }
	
}
