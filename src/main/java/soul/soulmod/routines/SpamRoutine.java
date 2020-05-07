package soul.soulmod.routines;

import soul.util.wrapper.LocalPlayerWrapper;
import soul.soulmod.routines.IRoutine;
import soul.soulmod.ModData;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ServerChatEvent;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class SpamRoutine implements IRoutine
{
	private static long DEFAULT_SPAM_INTERVAL_MS = 1000;
	private String spamMessage;
	private long spamIntervalMilliseconds;
	private ScheduledExecutorService periodicExecutor = Executors.newScheduledThreadPool(1);
	private ScheduledFuture<?> spammerHandler;
	private class Spammer implements Runnable
	{
		private String spamMessage;
		public Spammer(String message)
		{
			spamMessage = message;
		}
		@Override
		public void run()
		{
			LocalPlayerWrapper.sendChat(spamMessage);

		}
	}

	@Override
	public void activate(String[] args)
	{
		ArrayList<String> argsList = new ArrayList<String>(Arrays.asList(args));
		spamMessage = args[0];
		if(argsList.size() == 2)
		{
			spamIntervalMilliseconds = Integer.parseInt(argsList.get(1));
		}
		else
		{
			spamIntervalMilliseconds = DEFAULT_SPAM_INTERVAL_MS;
		}
		Spammer theSpammer = new Spammer(spamMessage);
		Thread spamThread = new Thread(theSpammer);
		spammerHandler = periodicExecutor.schedule(spamThread, spamIntervalMilliseconds, TimeUnit.MILLISECONDS);
	}
	@Override
	public void activate()
	{
	}

	@Override
	public void deactivate()
	{
	}

	@Override
	public String getName()
	{
		return "spam";
	}
}
