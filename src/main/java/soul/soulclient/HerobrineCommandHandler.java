package soul.soulclient;

import soul.util.wrapper.LocalPlayerWrapper;
import soul.util.wrapper.MinecraftWrapper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class HerobrineCommandHandler  implements Runnable
{
	private BlockingQueue<String> unhandledCommands = new LinkedBlockingQueue<>();

	public void addCommand(String command)
	{
		System.out.println("Handling Add");

		try
		{
			unhandledCommands.put(command);
		}
		catch(Exception e)
		{
		}
	}

	public void run()
	{
		System.out.println("StartingCommandHanler");
		for(;;) //Oldschool fuck yeah
		{
			try
			{

			String command = unhandledCommands.take();
			LocalPlayerWrapper.sendChat(command);
			}
			catch(Exception e)
			{

			}

		}
	}

}
