package com.example.a3in1;

public class Model {
    String id, tak,jum;
    public Model(){

    }
    public Model(String id, String jum,String tak){
        this.id=id;
        this.jum=jum;
        this.tak=tak;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getTak(){
        return tak;
    }

    public void setTak(String tak){
        this.tak=tak;
    }

    public String getJum(){
        return jum;
    }

    public void setJum(String jum){
        this.jum=jum;
    }

}
