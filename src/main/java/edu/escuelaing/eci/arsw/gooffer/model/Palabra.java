package edu.escuelaing.eci.arsw.gooffer.model;

public class Palabra {
    private int idPalabra;
    private int idServicio;
    private String categoria;

<<<<<<< HEAD
    public Palabra(int idPalabra, int idServicio, String categoria) {
=======
    public Palabra(int idPalabra,int idServicio, String categoria) {
>>>>>>> daf6bf6798d8e821c17bb65e4b93d571b05d6fd4
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

<<<<<<< HEAD
    public int getIdServicio() { return idServicio; }

    public void setServicio(int servicio) {
        this.idServicio = servicio;
=======
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
>>>>>>> daf6bf6798d8e821c17bb65e4b93d571b05d6fd4
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
