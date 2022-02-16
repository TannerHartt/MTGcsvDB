package com.revature.pokedex;

public class Mtg {
    private String name;
    private int dexId;
    private String type;

    public Mtg() {}


    public Mtg(String name, int dexId, String type) {
        this.name = name;
        this.dexId = dexId;
        this.type = type;
    }

    public Mtg(String name){
        this(name, -1, "");
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

    public Mtg id (int dexId) {
        this.dexId = dexId;
        return this;
    }

    public void nameTest(){

    }
    public String getName(){
        return name;
    }

    public int getDexId() {
        return dexId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
