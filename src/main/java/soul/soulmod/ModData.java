package soul.soulmod;

import soul.soulmod.kings.KingRegistry;
public class ModData
{
	private static KingRegistry kings = new KingRegistry();

	public static KingRegistry getKingRegistry()
	{
		return kings;
	}
}
