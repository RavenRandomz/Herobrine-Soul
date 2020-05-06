package soul.util.collection;


import soul.util.collection.Named;

import java.util.HashMap;
import java.util.ArrayList;
public class NameRegistry<E>
{
	private HashMap<String, Named> namedElementMap = new HashMap<>();

	public NameRegistry()
	{
	}

	public NameRegistry(ArrayList<Named> elements)
	{
		for(Named element : elements)
		{
			addElement(element);
		}
	}
	public void addElement(Named element)
	{
		String name = element.getName();
		namedElementMap.put(name, element);
	}

	public boolean hasElement(String name)
	{
		return namedElementMap.containsKey(name);
	}

	public E getElement(String name)
	{
		return (E)namedElementMap.get(name);
	}
}
