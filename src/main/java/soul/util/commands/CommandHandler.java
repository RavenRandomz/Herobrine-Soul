package soul.util.commands;

import soul.util.collection.NameRegistry;

import soul.util.commands.Command;
public class CommandHandler
{
	private NameRegistry<Command> commandRegistry;
	public void CommandHandler()
	{
	}

	public void addCommand(Command command)
	{
		commandRegistry.addElement(command);
	}

	public boolean commandExists(String commandName)
	{
		return commandRegistry.hasElement(commandPrefix);
	}

	public void executeCommand(String name, String[] args)
	{
		commandRegistry.getElement(name).execute(args);
	}
}
