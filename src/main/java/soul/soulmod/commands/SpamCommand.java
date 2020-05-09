package soul.soulmod.commands;

import soul.soulmod.ModData;

import herobrinesoul.commands.Command;
import herobrinesoul.commands.Cancellable;

import herobrinesoul.commands.QuotedTokenizer;
import soul.util.wrapper.LocalPlayerWrapper;

import java.util.ArrayList;
import java.util.Arrays;
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
		System.out.println(tokens.countTokens());
		String spamMessage = tokens.nextToken() ;
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add(spamMessage);
		try
		{
			String spamInterval = tokens.nextToken();
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
