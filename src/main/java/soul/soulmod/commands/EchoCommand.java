package soul.soulmod.commands;

import soul.soulmod.ModData;
import soul.util.commands.Command;

public class EchoCommand implements Command
{
	@Override
	public String getInvocation()
	{
		return "echo";
	}

	@Override
	public void execute(String[] args)
	{
		ModData.getRoutines().getRoutine("echo").activate();
	}

	@Override
	public String getName()
	{
		return "echo";
	}
}
