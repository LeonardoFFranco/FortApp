package edu.upb.fortapp.ui.activites.utils;

public class bpElemMock {
    private int id;
    private int level;
    private int imagePremio;
    private String nombrePremio;

    public bpElemMock(int id, int constLevel, int constImagePremio, String constNombrePremio){
        this.id=id;
        this.level=constLevel;
        this.imagePremio=constImagePremio;
        this.nombrePremio=constNombrePremio;
    }


    public void setId (int paramId){
        this.id=paramId;
    }
    public void setLevel (int paramlevel){
        this.level=paramlevel;
    }
    public void setImgPremio (int paramImgPremio){
        this.imagePremio=paramImgPremio;
    }
    public void setNombrePremio (String paramNombrePremio){
        this.nombrePremio=paramNombrePremio;
    }
    public int getId(){ return this.id; }
    public int getLevel (){
        return this.level;
    }
    public int getImagePremio(){ return this.imagePremio; }
    public String getNombrePremio(){
        return this.nombrePremio;
    }
}
