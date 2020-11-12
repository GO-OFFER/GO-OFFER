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
@Table(name="favoritos")
public class Favorito {

	@Id
	@Column(name = "idServicio")
    private int idservicio;
	
	@Column(name = "idusuario")
    private int idusuario;
	
    
    
/*
    public Compra(int id, int idServicio, int idComprador, int calificacion, Date fecha ) {
        this.id = id;
        this.idservicio = idServicio;
        this.idusuario = idComprador;
        this.calificacion = calificacion;
        this.creationdate = fecha;
    }
    */
	
    public Favorito() {
    	
    }

   

    public int getIdServicio() {
        return idservicio;
    }

    public void setIdServicio(int idServicio) {
        this.idservicio = idServicio;
    }

    public int getIdComprador() {
        return idusuario;
    }

    public void setIdComprador(int idComprador) {
        this.idusuario = idComprador;
    }



}
