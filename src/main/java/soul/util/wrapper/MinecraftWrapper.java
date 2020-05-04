package soul.util.wrapper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
public class MinecraftWrapper
{
	public static Minecraft getMinecraft()
	{
		return Minecraft.getInstance();

	}

	public static ClientPlayerEntity getLocalPlayer()
	{
		return getMinecraft().player;
	}

	public static void displayMessageInChat(String message)
	{
		getMinecraft().ingameGUI.getChatGUI().printChatMessage(new StringTextComponent(message));
	}




}
