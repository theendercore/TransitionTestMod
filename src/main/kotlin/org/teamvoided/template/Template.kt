package org.teamvoided.template

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress("unused")
object Template {
    const val MODID = "heroism"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(Template::class.simpleName)
//    trest_block
    val BLOCK_X = regsiter("block_x", Block(AbstractBlock.Settings.copy(Blocks.STONE)))
    val TEST_BLOCK = regsiter("test_block", Block(AbstractBlock.Settings.copy(Blocks.GLASS)))

    fun init() {
        log.info("Hello from Common")
    }

    fun regsiter(i: String, block: Block) {
        val id = id(i)
        Registry.register(Registries.BLOCK, id, block)
        Registry.register(Registries.ITEM, id, BlockItem(block, Item.Settings()))
    }

    fun id(path: String) = Identifier.of(MODID, path)
}
