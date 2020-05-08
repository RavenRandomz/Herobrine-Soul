package soul.soulmod.commands;

import soul.soulmod.ModData;
import soul.util.commands.Command;

import soul.util.wrapper.LocalPlayerWrapper;

public class NoCommand implements Command
{
	@Override
	public String getInvocation()
	{
		return "no";
	}

	@Override
	public void execute(String[] args)
	{
		String cancelledCommand = args[0];
		
	}

	@Override
	public String getName()
	{
		return "no";
	}
}
