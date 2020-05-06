package soul.soulmod.kings;

import java.util.ArrayList;
public class KingRegistry
{
	private ArrayList<String> kings = new ArrayList<>();

	public void addKing(String kingName)
	{
		if(!hasKing(kingName))
		{
			kings.add(kingName);
		}
		else
		{
			return;
		}
	}

	public void removeKing(String kingName)
	{
		kings.remove(kingName);
	}

	public boolean hasKing(String playerName)
	{
		return kings.contains(playerName);

	}

}
