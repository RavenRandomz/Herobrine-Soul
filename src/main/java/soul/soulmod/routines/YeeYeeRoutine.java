package soul.soulmod.routines;

import soul.util.wrapper.LocalPlayerWrapper;
import soul.soulmod.ModData;

import herobrinesoul.routines.Routine;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ServerChatEvent;


public class YeeYeeRoutine implements Routine
{
	private static String Yee = "Yee Yee!"; //This string name is illegal. But fuck you, I'm a rebel. Liberate the namez!!!
	@Override
	public void activate()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void activate(String[] args)
	{
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
