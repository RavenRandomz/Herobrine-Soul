package soul.util.wrapper;

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




}
