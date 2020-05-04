package soul.util.wrapper;

import soul.util.wrapper.MinecraftWrapper;

public class LocalPlayerWrapper
{
	public void sendChat(String message)
	{
		MinecraftWrapper.getLocalPlayer().sendChatMessage(message);

	}

}
