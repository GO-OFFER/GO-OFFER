package edu.escuelaing.eci.arsw.gooffer.model;

public class Palabra {
    private int idPalabra;
    private int idServicio;
    private String categoria;

    public Palabra(int idPalabra,int idServicio, String categoria) {
        this.idPalabra = idPalabra;
        this.idServicio = idServicio;
        this.categoria = categoria;
    }
    public int getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(int idPalabra) {
        this.idPalabra = idPalabra;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
