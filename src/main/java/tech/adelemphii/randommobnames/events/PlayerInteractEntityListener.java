package tech.adelemphii.randommobnames.events;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import tech.adelemphii.randommobnames.utility.GeneralUtils;

public class PlayerInteractEntityListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        if(!event.getPlayer().isSneaking() || event.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }

        Entity entity = event.getRightClicked();

        if(!GeneralUtils.hasData(entity)) {
            GeneralUtils.generateEntityData(entity);
        }

        Player player = event.getPlayer();

        String[] data = GeneralUtils.getData(entity);

        player.sendMessage(ChatColor.BLUE + "        -" + entity.getType().name() + "-");
        player.sendMessage(ChatColor.GRAY + "Name: " + ChatColor.YELLOW + entity.getCustomName());
        player.sendMessage(ChatColor.GRAY + "Favorite Fact: " + ChatColor.YELLOW + data[0]);
        player.sendMessage(ChatColor.GRAY + "Favorite LoTR Character: " + ChatColor.YELLOW + data[1]);
        player.sendMessage(ChatColor.GRAY + "Favorite Music Genre: " + ChatColor.YELLOW + data[2]);
        player.sendMessage(ChatColor.GRAY + "Favorite Game: " + ChatColor.YELLOW + data[3]);

        player.playSound(player.getLocation(), Sound.BLOCK_STONE_BUTTON_CLICK_ON, 1f, 1f);
    }
}
