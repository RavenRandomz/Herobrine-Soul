package soul.soulmod.commands;

import soul.soulmod.ModData;
import herobrinesoul.commands.Command;
import herobrinesoul.commands.Cancellable;

import soul.util.wrapper.LocalPlayerWrapper;

public class NoCommand implements Command
{
	@Override
	public String getInvocation()
	{
		return "no";
	}

	@Override
	public void execute(String rawArgs)
	{
		String[] args = rawArgs.split(" ");
		String commandName = args[0];

		Command possibleCancel =  ModData.getCommandHandler().getCommand(commandName);
		if(possibleCancel instanceof Cancellable)
		{
			((Cancellable)possibleCancel).cancel();

		}
		
	}

	@Override
	public String getName()
	{
		return "no";
	}
}
