package me.hypherionmc.modexporter.setup;

import com.mojang.brigadier.CommandDispatcher;
import me.hypherionmc.modexporter.ModExporter;
import me.hypherionmc.modexporter.common.commands.ModListExportCommand;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "modexporter", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonSetup {

    @SubscribeEvent
    public static void onRegisterCommandEvent(RegisterCommandsEvent event) {
        ModExporter.LOGGER.info("Registering Commands");
        CommandDispatcher<CommandSource> commandDispatcher = event.getDispatcher();
        ModListExportCommand.register(commandDispatcher);
    }

}
