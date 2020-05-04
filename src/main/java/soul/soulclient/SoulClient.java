package soul.soulclient;
import java.net.Socket;

import soul.util.network.IPAddressLocation;

import java.net.UnknownHostException;
import java.io.IOException;

import java.util.Queue;
public class SoulClient
{
	private HerobrineListener herobrineListener;
	/**
	 * UnknownHost means failure to connect
	 * IOException means failure to obtain stream
	 */
	public void connect(IPAddressLocation addressLocation) throws UnknownHostException, IOException
	{
		Socket herobrineSocket = new Socket(addressLocation.getAddress(), addressLocation.getPort());
		herobrineListener = new HerobrineListener(herobrineSocket, this);
		Thread herobrineListenerthread = new Thread(herobrineListener);
		herobrineListenerthread.start();
	}
}
