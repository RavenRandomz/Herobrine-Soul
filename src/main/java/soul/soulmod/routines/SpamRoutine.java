package soul.soulmod.routines;

import soul.util.wrapper.LocalPlayerWrapper;
import soul.soulmod.routines.IRoutine;
import soul.soulmod.ModData;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ServerChatEvent;


import java.util.concurrent.ScheduledExecutorService;
public class SpamRoutine implements IRoutine
{
	private class Spammer implements Runnable
	{
		@Override
		public void run()
		{
			LocalPlayerWrapper.sendChat("Spam");

		}
	}
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
		return "yee";
	}

	@SubscribeEvent
	public void onChat(ServerChatEvent chatEvent)
	{
		String playerName = chatEvent.getUsername();
		if(ModData.getKings().hasKing(playerName))
		{
			LocalPlayerWrapper.sendChat(Yee);
		}

	}


}
