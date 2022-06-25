package tech.adelemphii.randommobnames.utility;

import com.github.javafaker.Faker;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import tech.adelemphii.randommobnames.RandomMobBios;

import java.util.Arrays;
import java.util.List;

public class GeneralUtils {

    public static NamespacedKey randomMobBiosFact = new NamespacedKey(RandomMobBios.getInstance(), "random_mob_bios_fact");
    public static NamespacedKey randomMobBiosLOTR = new NamespacedKey(RandomMobBios.getInstance(), "random_mob_bios_lotr");
    public static NamespacedKey randomMobBiosMusic = new NamespacedKey(RandomMobBios.getInstance(), "random_mob_bios_music");
    public static NamespacedKey randomMobBiosGame = new NamespacedKey(RandomMobBios.getInstance(), "random_mob_bios_game");

    public static boolean hasData(Entity entity) {
        PersistentDataContainer pdc = entity.getPersistentDataContainer();

        if(!pdc.has(randomMobBiosFact, PersistentDataType.STRING) || !pdc.has(randomMobBiosLOTR, PersistentDataType.STRING)
            || !pdc.has(randomMobBiosMusic, PersistentDataType.STRING) || !pdc.has(randomMobBiosGame, PersistentDataType.STRING)) {
            return false;
        }

        return true;
    }

    public static void generateEntityData(Entity entity) {
        Faker faker = RandomMobBios.getInstance().getFaker();

        if(entity.getCustomName() == null) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();

            entity.setCustomNameVisible(true);
            entity.setCustomName(firstName + " " + lastName);
        }

        String randomFact = faker.chuckNorris().fact();
        String favoriteLOTRCharacter = faker.lordOfTheRings().character();
        String favoriteMusicGenre = faker.music().genre();
        String favoriteGame = faker.esports().game();

        PersistentDataContainer pdc = entity.getPersistentDataContainer();

        pdc.set(GeneralUtils.randomMobBiosFact, PersistentDataType.STRING, randomFact);
        pdc.set(GeneralUtils.randomMobBiosLOTR, PersistentDataType.STRING, favoriteLOTRCharacter);
        pdc.set(GeneralUtils.randomMobBiosMusic, PersistentDataType.STRING, favoriteMusicGenre);
        pdc.set(GeneralUtils.randomMobBiosGame, PersistentDataType.STRING, favoriteGame);
    }

    public static String[] getData(Entity entity) {
        PersistentDataContainer pdc = entity.getPersistentDataContainer();

        return new String[]{
                pdc.getOrDefault(randomMobBiosFact, PersistentDataType.STRING, "null"),
                pdc.getOrDefault(randomMobBiosLOTR, PersistentDataType.STRING, "null"),
                pdc.getOrDefault(randomMobBiosMusic, PersistentDataType.STRING, "null"),
                pdc.getOrDefault(randomMobBiosGame, PersistentDataType.STRING, "null")
        };
    }
}
