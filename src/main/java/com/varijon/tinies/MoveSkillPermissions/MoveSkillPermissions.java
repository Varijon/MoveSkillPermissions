package com.varijon.tinies.MoveSkillPermissions;

import org.apache.logging.log4j.Logger;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.varijon.tinies.MoveSkillPermissions.listener.MoveSkillLoginListener;
import com.varijon.tinies.MoveSkillPermissions.listener.MoveSkillUseListener;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("moveskillpermissions")
public class MoveSkillPermissions
{
	public static String MODID = "modid";
	public static String VERSION = "version";
	public static Logger logger;
	
	public MoveSkillPermissions()
	{
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
	}
	
	@SubscribeEvent
    public void setup(FMLCommonSetupEvent event) 
    {
		MinecraftForge.EVENT_BUS.register(new MoveSkillLoginListener());
		Pixelmon.EVENT_BUS.register(new MoveSkillUseListener());
	}
	
	@SubscribeEvent
	public void serverStarting(FMLServerStartingEvent event)
	{
	}

	@SubscribeEvent
	public void registerCommands(RegisterCommandsEvent event)
	{
	}
}