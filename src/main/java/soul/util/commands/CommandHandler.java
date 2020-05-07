package soul.util.commands;

import soul.util.collection.NameRegistry;

import soul.util.commands.Command;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
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

	public boolean commandIsValid(String rawCommand)
	{
		StringTokenizer commandTokens = new StringTokenizer(rawCommand);
		return commandExists(commandTokens.nextToken());
		
	}

	public void executeCommand(String name, String[] args)
	{
		commandRegistry.getElement(name).execute(args);
	}

	public void executeCommand(String rawCommand)
	{
		ArrayList<String> splitCommand = new ArrayList<String>(Arrays.asList(rawCommand.split(" ")));
		String name = splitCommand.get(0);
		String[] args = splitCommand.subList(1, splitCommand.size() -1).toArray(new String[0]);
		commandRegistry.getElement(name).execute(args);
	}
}
