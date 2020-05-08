package soul.util.commands;

import java.util.LinkedList;
public class QuotedTokenizer
{
	private char quoteChar = '\"';
	private char delimeterChar = '\"';
	private LinkedList<String> tokens = new LinkedList<>();
	public QuotedTokenizer(String string)
	{
		tokens = quotedTokenize(string);
	}

	public boolean hasMoreTokens()
	{
		return tokens.size() == 0;
	}

	public int countTokens()
	{
		return tokens.size();
	}

	public String nextToken()
	{
		return tokens.remove();
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
		return tokens;
	}
}

