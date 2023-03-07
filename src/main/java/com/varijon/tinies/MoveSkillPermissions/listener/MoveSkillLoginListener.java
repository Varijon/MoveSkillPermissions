package com.varijon.tinies.MoveSkillPermissions.listener;

import java.util.ArrayList;
import java.util.UUID;

import com.pixelmonmod.pixelmon.api.moveskills.MoveSkill;
import com.pixelmonmod.pixelmon.battles.controller.BattleController;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.permission.PermissionAPI;

public class MoveSkillLoginListener 
{	
	public MoveSkillLoginListener()
	{
	}
	
	@SubscribeEvent
	public void onPlayerLogin (PlayerLoggedInEvent event)
	{
		for(MoveSkill moveSkill : MoveSkill.moveSkills)
		{
			if(!PermissionAPI.hasPermission(event.getPlayer(), moveSkill.name))
			{
				moveSkill.unregister((ServerPlayerEntity) event.getPlayer());
				continue;
			}
		}
	}
}
