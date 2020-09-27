package edu.escuelaing.eci.arsw.gooffer.model;

import java.util.ArrayList;
import java.util.Date;

public class Compra {
    private int id;
    private int idServicio;
    private int idComprador;
    private int idVendedor;
    private int calificacion;
    private Date fecha;
    private boolean estado;
    private ArrayList<Comentario> comentarios;

    public Compra(int id, int idServicio, int idComprador, int idVendedor,int calificacion, Date fecha, boolean estado, ArrayList<Comentario> comentarios) {
        this.id = id;
        this.idServicio = idServicio;
        this.idComprador = idComprador;
        this.idVendedor = idVendedor;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.estado = estado;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
