package soul.soulclient;

import soul.util.wrapper.LocalPlayerWrapper;
import java.util.LinkedList;
public class HerobrineCommandHandler  implements Runnable
{
	private LinkedList<String> unhandledCommands = new LinkedList<>();

	public void addCommand(String command)
	{
		unhandledCommands.add(command);
	}

	public void run()
	{
		for(;;) //Oldschool fuck yeah
		{
			if(!unhandledCommands.isEmpty())
			{
				String command = unhandledCommands.remove();
				LocalPlayerWrapper.sendChat(command);
			}

		}
	}

}
