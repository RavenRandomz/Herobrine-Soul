package soul.util.commands;

import soul.util.collection.NameRegistry;

import soul.util.commands.Command;
public class CommandHandler
{
	private NameRegistry<Command> commandRegistry = new NameRegistry<>();
	public CommandHandler()
	{
	}

	public CommandHandler(NameRegistry<Command> registry)
	{
		commandRegistry = registry;
	}

	public void addCommand(Command command)
	{
		commandRegistry.addElement(command);
	}

	public boolean commandExists(String commandInvocation)
	{
		return commandRegistry.hasElement(commandInvocation);
	}

	public void executeCommand(String name, String[] args)
	{
		commandRegistry.getElement(name).execute(args);
	}
}
