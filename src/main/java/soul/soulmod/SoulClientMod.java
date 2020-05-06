package soul.soulmod;

import soul.soulmod.routines.EchoRoutine;
import soul.soulmod.routines.RoutineRegistry;
import soul.soulmod.ModData;

import net.minecraftforge.event.ServerChatEvent;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import soul.util.wrapper.LocalPlayerWrapper;
import soul.soulclient.SoulClient;
import soul.util.wrapper.MinecraftWrapper;
import soul.util.network.IPAddressLocation;
import java.util.stream.Collectors;
import java.net.UnknownHostException;
import java.io.IOException;

import java.util.StringTokenizer;



import java.util.ArrayList;
// The value here should match an entry in the META-INF/mods.toml file
@Mod("soulclientmod")
public class SoulClientMod
{
    // Directly reference a log4j logger.
	private SoulClient soulClient = new SoulClient();
    private static final Logger LOGGER = LogManager.getLogger();

    public SoulClientMod() {


		
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
	@SubscribeEvent
	public void onChat(ServerChatEvent chatEvent)
	{
		StringTokenizer chatTokens = new StringTokenizer(chatEvent.getMessage());

		int tokenCount = chatTokens.countTokens();
		String firstToken = chatTokens.nextToken();
		if(firstToken.equals("@connect") && tokenCount == 3)
		{
			String address = chatTokens.nextToken();
			int port = Integer.parseInt(chatTokens.nextToken());
			IPAddressLocation herobrineLocation = new IPAddressLocation(address, port);

			try
			{
				soulClient.connect(herobrineLocation);
			}
			catch(UnknownHostException e)
			{
				MinecraftWrapper.displayMessageInChat("No Host Connection. Cannot find our lord and savior Herobrine.");
			}
			catch(IOException e)
			{
				MinecraftWrapper.displayMessageInChat("Stream failed. Herobrine must be busy.");
			}
		}

	}
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
