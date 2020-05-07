package soul.soulmod.routines;

public interface IRoutine
{
	public void activate();
	public void activate(String[] args);
	public void deactivate();
	public String getName();
}
