package org.teamvoided.template.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.registry.HolderLookup
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.template.Template.log
import org.teamvoided.transition.api.data.gen.MappingsProvider
import java.util.concurrent.CompletableFuture

@Suppress("unused")
object TemplateData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        pack.addProvider(::MappingGen)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }

    class MappingGen(o: FabricDataOutput, r: CompletableFuture<HolderLookup.Provider>?) : MappingsProvider(o, r) {

        override fun makeMappings(lookup: HolderLookup.Provider, builder: MappingBuilder) {

            builder.addOldNamespace("template")
            builder.addOldPathMappings("test_block", "trest_block", "hempfar", "helios")
        }

    }
}
