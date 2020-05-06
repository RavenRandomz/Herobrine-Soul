package soul.soulmod;

import soul.soulmod.kings.KingRegistry;
import soul.soulmod.routines.RoutineRegistry;
import soul.soulmod.routines.IRoutine;
import soul.soulmod.routines.EchoRoutine;

import java.util.ArrayList;
import java.util.Arrays;
public class ModData
{
	private static KingRegistry kings = new KingRegistry();
	private static ArrayList<IRoutine> rawRoutines = new ArrayList<IRoutine>(
			Arrays.asList(
				new EchoRoutine()
				)
			);
	private static RoutineRegistry routines = new RoutineRegistry(rawRoutines);

	public static KingRegistry getKings()
	{
		return kings;
	}

	public static RoutineRegistry getRoutines()
	{
		return routines;
	}

}
