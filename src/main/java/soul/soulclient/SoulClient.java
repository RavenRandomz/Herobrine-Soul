package soul.soulclient;
import java.net.Socket;

import soul.util.network.IPAddressLocation;
import soul.soulclient.HerobrineCommandHandler;

import java.net.UnknownHostException;
import java.io.IOException;

public class SoulClient
{
	private HerobrineListener herobrineListener;
	private HerobrineCommandHandler commandHandler;
	/**
	 * UnknownHost means failure to connect
	 * IOException means failure to obtain stream
	 */

	public SoulClient()
	{
		commandHandler = new HerobrineCommandHandler();

		Thread commandHandlerThread = new Thread(commandHandler);
		commandHandlerThread.start();
	}
	public void connect(IPAddressLocation addressLocation) throws UnknownHostException, IOException
	{
		Socket herobrineSocket = new Socket(addressLocation.getAddress(), addressLocation.getPort());
		herobrineListener = new HerobrineListener(herobrineSocket, this);

		Thread herobrineListenerthread = new Thread(herobrineListener);
		herobrineListenerthread.start();


	}

	public void proccessCommand(String command)
	{
		commandHandler.addCommand(command);
	}
}
