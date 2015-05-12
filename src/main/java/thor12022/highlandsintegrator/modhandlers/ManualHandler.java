package thor12022.highlandsintegrator.modhandlers;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import thor12022.highlandsintegrator.ConfigHandler;
import thor12022.highlandsintegrator.HighlandsIntegrator;
import thor12022.highlandsintegrator.ModInformation;
import thor12022.highlandsintegrator.util.TextHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager.BiomeType;
import thaumcraft.common.lib.world.ThaumcraftWorldGenerator;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeEntry;
import fabricator77.multiworld.api.biomeregistry.AdvancedBiomeRegistry;

public class ManualHandler
{
   public static void init(FMLInitializationEvent event)
   {
      HighlandsIntegrator.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init.thaumcraft"));

      for (int index = 0; index < ConfigHandler.manualEntries.size(); ++index)
      {
         ConfigHandler.ManualEntry entry = ConfigHandler.manualEntries.get(index);
         HighlandsIntegrator.logger.info("Registering Biome " + entry.id + " from " + entry.modName +" with weight " + entry.weight + " as type " + entry.type );
         AdvancedBiomeEntry biome = new AdvancedBiomeEntry(BiomeGenBase.getBiome(entry.id), entry.weight, entry.modName);
         AdvancedBiomeRegistry.addBiome(biome, entry.type, true);
      }
   }
}
