package edu.upb.fortapp.models;

public class Noticias {
    private String titulo;
    private String descripcion;
    private String fecha;
    private String categoria;

    public Noticias(){}

    public Noticias(String titulo, String descripcion, String fecha, String categoria){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.categoria=categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }




}
