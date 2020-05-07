package soul.util.commands;

import soul.util.collection.NameRegistry;

import soul.util.commands.Command;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
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

	public void executeCommand(String name, String[] args)
	{
		commandRegistry.getElement(name).execute(args);
	}

	public void executeCommand(String rawCommand)
	{
		StringTokenizer commandTokens = new StringTokenizer(rawCommand);
		String name = commandTokens.nextToken();	
		String args[];
		if(!commandTokens.hasMoreTokens())
		{
			args = EMPTY_ARGS;
		}
		else
		{
			ArrayList<String> rawArgs = new ArrayList<>();
			while(commandTokens.hasMoreTokens())
			{
			rawArgs.add(commandTokens.nextToken());
			}
			args = rawArgs.toArray(new String[0]);
		}


		commandRegistry.getElement(name).execute(args);
	}
}
