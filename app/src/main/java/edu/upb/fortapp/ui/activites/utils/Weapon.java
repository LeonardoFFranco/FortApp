package edu.upb.fortapp.ui.activites.utils;

public class Weapon {
    private int id;
    private String name;
    private int image;
    private String type;
    private int damage;
    private int head;
    private String reload;
    private double fireRate;



    public Weapon(int id, String name, int image, String type,int damage,int head,String reload,double fireRate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.damage = damage;
        this.head = head;
        this.reload = reload;
        this.fireRate = fireRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getReload() {
        return reload;
    }

    public void setReload(String reload) {
        this.reload = reload;
    }

    public double getFireRate() {
        return fireRate;
    }

    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

}

