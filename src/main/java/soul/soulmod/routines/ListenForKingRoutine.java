package soul.soulmod.routines;

import soul.soulmod.ModData;
import soul.soulmod.routines.IRoutine;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
public class ListenForKingRoutine implements IRoutine
{
	private static String kingPrefix = "My subjects, ";

	public ListenForKingRoutine()
	{
		activate();
	}

	@Override
	public void activate(String[] args)
	{
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
		System.out.println("Testing for commands");
		String playerName = chatEvent.getUsername();
		String message = chatEvent.getMessage();
		if(!ModData.getKings().hasKing(playerName))
		{
			return;
		}

		if(!message.startsWith(kingPrefix))
		{
			return;
		}

		System.out.println("CommandCriteriaPassed");
		String command = message.substring(kingPrefix.length() - 1);
			if(ModData.getCommandHandler().commandIsValid(command))
			{
				ModData.getCommandHandler().executeCommand(command);
			}
	}
}
