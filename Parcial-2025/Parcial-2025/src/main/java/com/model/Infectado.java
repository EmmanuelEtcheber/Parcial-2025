package com.model;

import com.interfaces.IAtacar;

import java.util.Objects;
import java.util.UUID;

public class Infectado implements IAtacar {
    protected UUID id;
    protected String nombre;
    protected String origen;
    protected Integer cantInfectados;

    public Infectado() {
        id = UUID.randomUUID();
        nombre = "";
        origen = "";
        cantInfectados = 0;
    }

    public Infectado(UUID id){
        this.id = id;
    }

    public Infectado(String nombre, String origen) {
        id = UUID.randomUUID();
        this.nombre = nombre;
        this.origen = origen;
        cantInfectados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Integer getCantInfectados() {
        return cantInfectados;
    }

    public void setCantInfectados(Integer cantInfectados) {
        this.cantInfectados = cantInfectados;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Infectado infectado)) return false;
        return Objects.equals(id, infectado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public Integer atacar() {
        return 100;
    }

    @Override
    public String toString() {
        return "Infectado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", cantInfectados=" + cantInfectados +
                '}';
    }
}
