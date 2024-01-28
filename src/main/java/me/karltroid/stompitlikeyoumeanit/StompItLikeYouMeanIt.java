package me.karltroid.stompitlikeyoumeanit;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class StompItLikeYouMeanIt extends JavaPlugin implements Listener
{

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    private void onCropTrample(PlayerInteractEvent event) // detect the player trampling crops and cancel if sneaking
    {
        if (event.getAction() != Action.PHYSICAL) return;
        if (event.getPlayer().isSneaking()) return;

        Block block = event.getClickedBlock();
        if (block == null || block.getType() != Material.FARMLAND) return;

        event.setCancelled(true);
    }
}
