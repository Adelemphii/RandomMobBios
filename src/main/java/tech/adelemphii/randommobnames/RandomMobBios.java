package tech.adelemphii.randommobnames;

import com.github.javafaker.Faker;
import org.bukkit.plugin.java.JavaPlugin;
import tech.adelemphii.randommobnames.events.EntitySpawnListener;
import tech.adelemphii.randommobnames.events.PlayerInteractEntityListener;

public final class RandomMobBios extends JavaPlugin {

    private Faker faker;
    private static RandomMobBios plugin;

    @Override
    public void onEnable() {
        plugin = this;
        faker = new Faker();

        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractEntityListener(), this);
    }

    @Override
    public void onDisable() {
    }

    public Faker getFaker() {
        return faker;
    }

    public static RandomMobBios getInstance() {
        return plugin;
    }
}
