package soul.soulmod.commands;

import soul.soulmod.ModData;
import soul.util.commands.Command;
import soul.util.commands.Cancellable;

import soul.util.wrapper.LocalPlayerWrapper;

public class EchoCommand implements Command, Cancellable
{
	@Override
	public String getInvocation()
	{
		return "echo";
	}

	@Override
	public void execute(String[] args)
	{
		//LocalPlayerWrapper.sendChat("Attempting Echo");
		//LocalPlayerWrapper.sendChat(new Boolean(ModData.getRoutines().hasRoutine("echo")).toString());
		ModData.getRoutines().getRoutine("echo").activate();
	}

	@Override
	public void cancel()
	{
		ModData.getRoutines().getRoutine("echo").deactivate();
	}

	@Override
	public String getName()
	{
		return "echo";
	}
}
