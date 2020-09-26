package edu.escuelaing.eci.arsw.gooffer.model;

import java.util.Date;

public class Comentario {
    private int id;
    private int idCompra;
    private String comentario;
    private Date fecha;

    public Comentario(int id, int idCompra, String comentario, Date fecha) {
        this.id = id;
        this.idCompra = idCompra;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
