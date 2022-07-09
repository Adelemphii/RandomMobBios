package tech.adelemphii.randommobnames.events;

import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import tech.adelemphii.randommobnames.utility.GeneralUtils;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if(!(event.getEntity() instanceof Mob)) {
            return;
        }
        GeneralUtils.generateEntityData(event.getEntity());
    }


}
