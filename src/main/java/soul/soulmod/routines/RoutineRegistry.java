package soul.soulmod.routines;

import soul.soulmod.routines.IRoutine;

import java.util.HashMap;
public class RoutineRegistry
{
	private HashMap<String, IRoutine> nameRoutineMap = new HashMap<>();

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
