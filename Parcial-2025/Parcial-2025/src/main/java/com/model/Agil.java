package com.model;

public class Agil extends Infectado implements IAlimentar{
    private Integer alturaMax;

    public Agil() {
        alturaMax = 0;
    }

    public Agil(String nombre, String origen, Integer alturaMax) {
        super(nombre, origen);
        this.alturaMax = alturaMax;
    }

    public Integer getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(Integer alturaMax) {
        this.alturaMax = alturaMax;
    }

    public boolean saltar(Integer altura){
        return altura < alturaMax;
    }

    @Override
    public String toString() {
        return "Agil{" +
                "alturaMax=" + alturaMax +
                "} " + super.toString();
    }
}
