package soul.soulmod.routines;

import soul.util.wrapper.LocalPlayerWrapper;
import soul.soulmod.SoulClientMod;
import soul.soulmod.routines.IRoutine;
import soul.soulmod.ModData;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ServerChatEvent;


public class EchoRoutine implements IRoutine
{
	@Override
	public void activate()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void deactivate()
	{
		MinecraftForge.EVENT_BUS.unregister(this);
	}

	@Override
	public String getName()
	{
		return "hail";
	}

	@SubscribeEvent
	public void onChat(ServerChatEvent chatEvent)
	{
		String playerName = chatEvent.getUsername();
		if(ModData.getKings().hasKing(playerName))
		{
			LocalPlayerWrapper.sendChat(chatEvent.getMessage());
		}

	}


}
