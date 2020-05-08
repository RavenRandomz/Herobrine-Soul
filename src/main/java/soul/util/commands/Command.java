package soul.util.commands;

import soul.util.collection.Named;

public interface Command extends Named
{
	public String getInvocation();
	public void execute(String rawArgs);
}
