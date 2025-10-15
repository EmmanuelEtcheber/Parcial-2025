package com.model;

public class Pesado extends Infectado{
    private Integer puertasMax;
    private Integer puertasRotas;

    public Pesado() {
        puertasMax = 0;
        puertasRotas = 0;
    }

    public Pesado(String nombre, String origen, Integer puertasMax) {
        super(nombre, origen);
        this.puertasMax = puertasMax;
        puertasRotas = 0;
    }

    public Integer getPuertasMax() {
        return puertasMax;
    }

    public void setPuertasMax(Integer puertasMax) {
        this.puertasMax = puertasMax;
    }

    public Integer getPuertasRotas() {
        return puertasRotas;
    }

    public boolean romperPuerta(){
        if(puertasRotas < puertasMax){
            puertasRotas++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pesado{" +
                "puertasMax=" + puertasMax +
                ", puertasRotas=" + puertasRotas +
                "} " + super.toString();
    }
}
