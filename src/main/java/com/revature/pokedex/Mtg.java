package com.revature.pokedex;

public class Mtg {
    // Card Name,Card Type,CMC,Color,Rarity
    private String name;
    private int manaCost;
    private String type;
    private String rarity;

    public Mtg() {}


    public Mtg(String name, int manaCost, String type, String rarity) {
        this.name = name;
        this.type = type;
        this.manaCost = manaCost;
        this.rarity = rarity;


    }

    public Mtg(String name){
        this(name, -1, "", "");
    }

    public static Mtg of() {
        return new Mtg();
    }

    public Mtg name(String name){
        this.name = name;
        return this;
    }

    public Mtg type(String type) {
        this.type = type;
        return this;
    }

    public Mtg manaCost(int manaCost) {
        this.manaCost = manaCost;
        return this;
    }

    public Mtg rarity(String rarity){
        this.rarity = rarity;
        return this;
    }

    public String getName(){
        return this.name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
