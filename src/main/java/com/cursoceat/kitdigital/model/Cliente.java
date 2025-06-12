package com.cursoceat.kitdigital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEmpresa;
    private int numEmpleado;
    private String sociedadEmpresa;
    private String opcionKit;
    private LocalDateTime fechaCita;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getSociedadEmpresa() {
        return sociedadEmpresa;
    }

    public void setSociedadEmpresa(String sociedadEmpresa) {
        this.sociedadEmpresa = sociedadEmpresa;
    }

    public String getOpcionKit() {
        return opcionKit;
    }

    public void setOpcionKit(String opcionKit) {
        this.opcionKit = opcionKit;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }
}
