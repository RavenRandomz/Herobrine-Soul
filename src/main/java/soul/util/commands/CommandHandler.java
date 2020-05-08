package soul.util.commands;

import soul.util.collection.NameRegistry;

import soul.util.commands.Command;

import java.util.StringTokenizer;
public class CommandHandler
{
	static final String[] EMPTY_ARGS = {""};
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

	public boolean commandIsValid(String rawCommand)
	{
		StringTokenizer commandTokens = new StringTokenizer(rawCommand);
		return commandExists(commandTokens.nextToken());
		
	}

	public void executeCommand(String name, String rawArgs)
	{
		System.out.println(name);
		System.out.println(rawArgs);
		commandRegistry.getElement(name).execute(rawArgs);
	}

	public Command getCommand(String name)
	{
		return commandRegistry.getElement(name);
	}
}
