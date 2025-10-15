package com.model;

import com.enums.EFaccion;
import com.interfaces.IAtacar;

import java.util.*;

public class GestorCuarentena {
    private Set<IAtacar> humanos;
    private List<IAtacar> infectados;

    public GestorCuarentena() {
        humanos = new HashSet<>();
        infectados = new ArrayList<>();
    }

    public boolean agregar(IAtacar atacante){
        if(atacante instanceof Infectado){
            return infectados.add(atacante);
        }else if(atacante instanceof Humano){
            return humanos.add(atacante);
        }else{
            return false;
        }
    }

    public boolean eliminar(UUID id){
        IAtacar aEliminar = buscarParticipante(id);
        if(aEliminar instanceof Humano) {
            return humanos.remove(aEliminar);
        }else if(aEliminar instanceof Infectado){
            return infectados.remove(aEliminar);
        }else {
            return false;
        }
    }

    public IAtacar buscarParticipante(UUID id){
        IAtacar aBuscar = new Humano(id);
        if(humanos.contains(aBuscar)){
            for(IAtacar humano : humanos){
                if(humano.equals(aBuscar)){
                    return humano;
                }
            }
        }

        aBuscar = new Infectado(id);
        if(infectados.contains(aBuscar)){
            for(IAtacar infectado : infectados){
                if(infectado.equals(aBuscar)){
                    return infectado;
                }
            }
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        for(IAtacar humano : humanos){
            mensaje.append(humano.toString()).append("\n");
        }
        for(IAtacar infectado : infectados){
            mensaje.append(infectado.toString()).append("\n");
        }

        return mensaje.toString();
    }

    public boolean modificarCantInfectados(UUID id, Integer nuevaCantInfectados){
        Infectado buscado = (Infectado) buscarParticipante(id);
        if(nuevaCantInfectados > buscado.getCantInfectados()){
            buscado.setCantInfectados(nuevaCantInfectados);
            return true;
        }
        return false;
    }

    public Integer contarPorTipo(EFaccion faccion){
        int cantidad = 0;
        for(IAtacar humano : humanos) {
            if(((Humano)humano).getFaccion().equals(faccion)){
                cantidad++;
            }
        }
        return cantidad;
    }
}
