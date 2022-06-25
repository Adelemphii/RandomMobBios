package tech.adelemphii.randommobnames.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import tech.adelemphii.randommobnames.utility.GeneralUtils;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        GeneralUtils.generateEntityData(event.getEntity());
    }


}
