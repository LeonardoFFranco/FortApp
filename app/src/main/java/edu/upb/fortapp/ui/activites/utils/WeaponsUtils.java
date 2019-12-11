package edu.upb.fortapp.ui.activites.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.fortapp.R;
import edu.upb.fortapp.ui.activites.Weapon;

public class WeaponsUtils {

    /**
     * Get list of pokemons
     * @return List of pokemons in the pokedex
     */
    public static List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon(1, "Assault Rifle", R.drawable.assault1, "Common",30,60,"2.5s",5.5));
        weapons.add(new Weapon(2, "Assault Rifle", R.drawable.assault2, "uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(3, "Assault Rifle", R.drawable.assault3, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(4, "Assault Rifle", R.drawable.assault4, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(5, "Assault Rifle", R.drawable.assault5, "Legendary",30,60,"2.5s",5.5));
        weapons.add(new Weapon(6, "Pump Shotgun", R.drawable.pump1, "Common",30,60,"2.5s",5.5));
        weapons.add(new Weapon(7, "Pump Shotgun", R.drawable.pump2, "Uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(8, "Pump Shotgun", R.drawable.pump3, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(9, "Pump Shotgun", R.drawable.pump4, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Pump Shotgun", R.drawable.pump5, "Legendary",30,60,"2.5s",5.5));
        weapons.add(new Weapon(6, "Burst Assault Rifle", R.drawable.burst1, "Common",30,60,"2.5s",5.5));
        weapons.add(new Weapon(7, "Burst Assault Rifle", R.drawable.burst2, "Uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(8, "Burst Assault Rifle", R.drawable.burst3, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(9, "Burst Assault Rifle", R.drawable.burst4, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Burst Assault Rifle", R.drawable.burst5, "Legendary",30,60,"2.5s",5.5));
        weapons.add(new Weapon(7, "Bolt-action Sniper Rifle", R.drawable.bolt1, "Uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(8, "Bolt-action Sniper Rifle", R.drawable.bolt2, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(9, "Bolt-action Sniper Rifle", R.drawable.bolt3, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Bolt-action Sniper Rifle", R.drawable.bolt4, "Legendary",30,60,"2.5s",5.5));
        weapons.add(new Weapon(7, "Rocket Launcher", R.drawable.rpg1, "Uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(8, "Rocket Launcher", R.drawable.rpg2, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(9, "Rocket Launcher", R.drawable.rpg3, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Rocket Launcher", R.drawable.rpg4, "Legendary",30,60,"2.5s",5.5));
        weapons.add(new Weapon(6, "Pistol", R.drawable.pistol1, "Common",30,60,"2.5s",5.5));
        weapons.add(new Weapon(7, "Pistol", R.drawable.pistol2, "Uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(8, "Pistol", R.drawable.pistol3, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(9, "Pistol", R.drawable.pistol4, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Pistol", R.drawable.pistol5, "Legendary",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Grenade", R.drawable.grenade1, "Common",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Tactical Shotgun", R.drawable.tactica1, "Common",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Tactical Shotgun", R.drawable.tactica2, "Uncommon",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Tactical Shotgun", R.drawable.tactica3, "Rare",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Tactical Shotgun", R.drawable.tactica4, "Epic",30,60,"2.5s",5.5));
        weapons.add(new Weapon(10, "Tactical Shotgun", R.drawable.tactica5, "Legendary",30,60,"2.5s",5.5));

        return weapons;
    }
}

