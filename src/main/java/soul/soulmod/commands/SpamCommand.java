package soul.soulmod.commands;

import soul.soulmod.ModData;
import soul.util.commands.Command;

import soul.util.wrapper.LocalPlayerWrapper;

import java.util.ArrayList;
import java.util.Arrays;
public class SpamCommand implements Command
{
	@Override
	public String getInvocation()
	{
		return "spam";
	}

	@Override
	public void execute(String[] args)
	{
		String spamMessage = "";
		ArrayList<String> argList = new ArrayList<>(Arrays.asList(args));
		ArrayList<String> finalArgs = new ArrayList<>();
		if(argList.size() == 1)
		{
			finalArgs.add(argList.get(0));
		}
		else
		{
			for(int i = 0; i < argList.size() - 1; ++i)
			{
				spamMessage += argList.get(i) + " ";
			}
			finalArgs.add(spamMessage);
			finalArgs.add(argList.get(argList.size()-1));
		}

		ModData.getRoutines().getRoutine("spam").activate(finalArgs.toArray(new String[0]));
	}

	@Override
	public String getName()
	{
		return "spam";
	}
}
