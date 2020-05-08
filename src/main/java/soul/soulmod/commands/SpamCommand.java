package soul.soulmod.commands;

import soul.soulmod.ModData;
import soul.util.commands.Command;
import soul.util.commands.Cancellable;

import soul.util.wrapper.LocalPlayerWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import soul.util.commands.QuotedTokenizer;
public class SpamCommand implements Command, Cancellable
{
	@Override
	public String getInvocation()
	{
		return "spam";
	}

	@Override
	public void cancel()
	{

		ModData.getRoutines().getRoutine("spam").deactivate();
	}

	@Override
	public void execute(String args)
	{
		QuotedTokenizer tokens = new QuotedTokenizer(args);
		String spamInterval = tokens.nextToken();
		String spamMessage = tokens.nextToken() ;
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add(spamMessage);
		try
		{
			Integer.parseInt(spamInterval);
			arguments.add(spamInterval);
		}
		catch(Exception e)
		{
		}

		ModData.getRoutines().getRoutine("spam").activate(arguments.toArray(new String[0]));
	}

	@Override
	public String getName()
	{
		return "spam";
	}
}
