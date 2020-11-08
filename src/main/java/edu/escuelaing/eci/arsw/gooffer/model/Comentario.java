package edu.escuelaing.eci.arsw.gooffer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario {
	/* falta comentario por conexion */
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Id
    private int idservicio;
	
	@Column(name = "idusuario")
    private int idusuario;
	
	@Column(name = "creationdate")
    private Date fecha;
	
	@Column(name = "comentario")
    private String comentario;
	
    public Comentario(int idservicio, int idusuario, Date fecha, String comentario,int id) {
        this.idservicio= idservicio;
        this.idusuario = idusuario;
        this.comentario = comentario;
        this.fecha = fecha;
        this.id=id;
    }
    public Comentario() {
    	
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdservicio() {
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