package edu.escuelaing.eci.arsw.gooffer.model;

public class Palabra {
    private int servicio;
    private String categoria;

    public Palabra(int servicio, String categoria) {
        this.servicio = servicio;
        this.categoria = categoria;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
