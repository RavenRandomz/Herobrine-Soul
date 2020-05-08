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
			if(isInQuote)
			{
				if(c == quoteChar)
				{
					isInQuote = false;
				}
				else 
				{
					currentToken += c;
				}
				
			}
			else
			{
				if(c == quoteChar)
				{
					isInQuote = true;
				}
				else if(c == delimeterChar)
				{
					tokens.add(currentToken);
					currentToken = "";
				}
				else
				{
					currentToken += c;
				}
			}

		}
		return tokens;
	}
}

