package com.varijon.tinies.MoveSkillPermissions.listener;


import com.pixelmonmod.pixelmon.api.events.moveskills.UseMoveSkillEvent;
import com.pixelmonmod.pixelmon.api.events.spawning.SpawnEvent;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.permission.PermissionAPI;

public class MoveSkillUseListener 
{
	public MoveSkillUseListener()
	{	
	}
	
	@SubscribeEvent
	public void onMoveSkillUse(UseMoveSkillEvent event)
	{	
		if(event.pixelmon.getPokemon().getOwnerPlayer() == null)
		{
			event.setCanceled(true);
			return;
		}
		ServerPlayerEntity player = event.pixelmon.getPokemon().getOwnerPlayer();
		if(!PermissionAPI.hasPermission(player, event.moveSkill.name))
		{
			event.setCanceled(true);
			return;
		}
	}
}