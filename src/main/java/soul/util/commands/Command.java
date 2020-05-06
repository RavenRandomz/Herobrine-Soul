package soul.util.commands;

public interface Command
{
	public String getCommandPrefix();
	public void execute(String[] args);
}
