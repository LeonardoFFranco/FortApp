package edu.upb.fortapp.ui.activites.utils;

public class Noticia  {
        private int uuid;
        private String titulo;
        private int imagen;
        private String fecha;
        private String Contenido;

    public Noticia(int uuid, String titulo, int imagen, String fecha, String Contenido) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.imagen = imagen;
        this.fecha = fecha;
        this.Contenido = Contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


        public int getUuid() {
            return uuid;
        }

        public void setUuid(int uuid) {
            this.uuid = uuid;
        }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }
}
