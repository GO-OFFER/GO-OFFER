package edu.escuelaing.eci.arsw.gooffer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name="compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column(name = "idservicio")
    private int idservicio;
	@Column(name = "idusuario")
    private int idusuario;
	@Column(name = "calificacion")
    private int calificacion;
	@Column(name = "creationdate")
    private Date creationdate;
    
    
/*
    public Compra(int id, int idServicio, int idComprador, int calificacion, Date fecha ) {
        this.id = id;
        this.idservicio = idServicio;
        this.idusuario = idComprador;
        this.calificacion = calificacion;
        this.creationdate = fecha;
    }
    */
	
    public Compra() {
    	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdServicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }


}
