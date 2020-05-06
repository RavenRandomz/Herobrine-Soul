package soul.util.wrapper;

import soul.util.wrapper.MinecraftWrapper;

public class LocalPlayerWrapper
{
	public static void sendChat(String message)
	{
		MinecraftWrapper.getMinecraft().player.sendChatMessage(message);
		//MinecraftWrapper.getLocalPlayer().sendChatMessage(message);
	}

}
