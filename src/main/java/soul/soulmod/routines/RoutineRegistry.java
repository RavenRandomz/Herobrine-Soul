package soul.soulmod.routines;

import soul.soulmod.routines.IRoutine;

import java.util.HashMap;
import java.util.ArrayList;
public class RoutineRegistry
{
	private HashMap<String, IRoutine> nameRoutineMap = new HashMap<>();

	public RoutineRegistry()
	{
	}
	public RoutineRegistry(ArrayList<IRoutine> routines)
	{
		for(IRoutine routine : routines)
		{
			addRoutine(routine);
		}
	}
	public void addRoutine(IRoutine routine)
	{
		String name = routine.getName();
		nameRoutineMap.put(name, routine);
	}

	public IRoutine getRoutine(String name)
	{
		return nameRoutineMap.get(name);
	}
}
