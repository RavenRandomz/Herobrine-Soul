package soul.soulmod.routines;

import soul.soulmod.ModData;
import soul.soulmod.routines.IRoutine;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
public class ListenForKingRoutine implements IRoutine
{
	public ListenForKingRoutine()
	{
		activate();
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
		return "listenForKing";
	}

	@SubscribeEvent
	public void chatHandler(ServerChatEvent chatEvent)
	{
		String playerName = chatEvent.getUsername();
		if(ModData.getKings().hasKing(playerName))
		{

		}
	}
}
