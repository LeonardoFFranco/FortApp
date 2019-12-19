package edu.upb.fortapp.models.repository;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weapon_table")
public class Weapon2 {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int image;
    private String type;
    private int damage;
    private int head;
    private String reload;
    private double fireRate;

    public Weapon2(String name, int image, String type, int damage, int head, String reload, double fireRate) {
        this.name = name;
        this.image = image;
        this.type = type;
        this.damage = damage;
        this.head = head;
        this.reload = reload;
        this.fireRate = fireRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHead() {
        return head;
    }

    public String getReload() {
        return reload;
    }

    public double getFireRate() {
        return fireRate;
    }
}
