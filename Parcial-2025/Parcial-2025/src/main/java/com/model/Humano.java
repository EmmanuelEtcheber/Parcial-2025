package com.model;

import com.enums.EFaccion;
import com.interfaces.IAtacar;

import java.util.Objects;
import java.util.UUID;

public class Humano implements IAtacar {
    private UUID id;
    private String nombre;
    private Integer edad;
    private EFaccion faccion;

    public Humano() {
        id = UUID.randomUUID();
        nombre = "";
        edad = -1;
        faccion = null;
    }

    public Humano(UUID id){
        this.id = id;
    }

    public Humano(String nombre, Integer edad, EFaccion faccion) {
        id = UUID.randomUUID();
        this.nombre = nombre;
        this.edad = edad;
        this.faccion = faccion;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public EFaccion getFaccion() {
        return faccion;
    }

    public void setFaccion(EFaccion faccion) {
        this.faccion = faccion;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Humano humano)) return false;
        return Objects.equals(id, humano.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public Integer atacar() {
        return (int)Math.floor(Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Humano{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", faccion=" + faccion +
                '}';
    }
}
