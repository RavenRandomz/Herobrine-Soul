package soul.util.commands;

import java.util.LinkedList;
public class QuotedTokenizer
{
	private char quoteChar = '\"';
	private char delimeterChar = '\"';
	private LinkedList<String> leTokens = new LinkedList<>();
	public QuotedTokenizer(String string)
	{
		leTokens = quotedTokenize(string);
	}

	public boolean hasMoreTokens()
	{
		return leTokens.size() == 0;
	}

	public int countTokens()
	{
		return leTokens.size();
	}

	public String nextToken()
	{
		return leTokens.remove();
	}

	private LinkedList<String> quotedTokenize(String string)
	{
		LinkedList<String> tokens = new LinkedList<>();
		String currentToken = "";
		boolean isInQuote = false;

		for(char c: string.toCharArray())
		{
			System.out.println(c);
			if(isInQuote)
			{
				if(c == quoteChar)
				{
					System.out.println("Moving outsicde quote");
					isInQuote = false;
				}
				else 
				{
					System.out.println("Adding Char");
					currentToken += c;
				}
				
			}
			else
			{
				if(c == quoteChar)
				{
					System.out.println(" Entring char");
					isInQuote = true;
				}
				else if(c == delimeterChar)
				{
					System.out.println("Adding token");
					tokens.add(currentToken);
					currentToken = "";
				}
				else
				{
					System.out.println("Adding char");
					currentToken += c;
				}
			}

		}
		if(!currentToken.equals(""))
		{
			tokens.add(currentToken);
		}
		System.out.println(tokens.toString());
		return tokens;
	}
}

