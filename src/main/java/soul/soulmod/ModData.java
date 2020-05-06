package soul.soulmod;

import soul.soulmod.kings.KingRegistry;
import soul.soulmod.routines.RoutineRegistry;
import soul.soulmod.routines.EchoRoutine;
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
