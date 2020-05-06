package soul.soulmod;

import soul.soulmod.kings.KingRegistry;
import soul.soulmod.routines.RoutineRegistry;
public class ModData
{
	private static KingRegistry kings = new KingRegistry();
	private static RoutineRegistry routines = new RoutineRegistry();

	public static KingRegistry getKings()
	{
		return kings;
	}

	public static RoutineRegistry getRoutines()
	{
		return routines;
	}
}
