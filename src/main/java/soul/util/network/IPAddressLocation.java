package soul.util.network;

public class IPAddressLocation
{
	private String address;
	private int port;

	public IPAddressLocation(String IPAddress, int port)
	{
		address = IPAddress;
		this.port = port;
	}

	public String getAddress()
	{
		return address;
	}

	public int getPort()
	{
		return port;
	}
}



