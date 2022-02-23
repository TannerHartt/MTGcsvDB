package com.revature.pokedex.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Types {
    private int cmc;
    private Type type;

    public Types() {}

    public Types(int cmc, Type type) {
        this.type = type;
        this.cmc = cmc;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public Type getTypes() {
        return type;
    }

    public void setTypes(Type type) {
        this.type = type;
    }

    @JsonProperty
    private void unpackType(Map<Type,Object> type) {
        this.type = Type.valueOf((String) type.get("types"));
    }

    @Override
    public String toString() {
        return "Types{" +
                "cmc=" + cmc +
                ", type='" + type + '\'' +
                '}';
    }
}
