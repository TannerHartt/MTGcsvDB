package com.revature.pokedex.domain;

import java.util.Objects;

public class Mtg {
    // Card Name,Card Type,CMC,Color,Rarity
    private String name;
    private int manaCost;
    private String type;


    public Mtg() {}

    public Mtg(String name, int manaCost, String type) {
        this.name = name;
        this.type = type;
        this.manaCost = manaCost;
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

    public Mtg manaCost(int manaCost) {
        this.manaCost = manaCost;
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
//
//    @Override
//    public String toString() {
//        return "Mtg{" +
//                "name='" + name + '\'' +
//                ", manaCost=" + manaCost +
//                ", type='" + type + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mtg mtg = (Mtg) o;
        return manaCost == mtg.manaCost && Objects.equals(name, mtg.name) && Objects.equals(type, mtg.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, manaCost, type);
    }

}
