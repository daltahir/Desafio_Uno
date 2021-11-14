package com.previred.dbravo.desafiouno.Model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseService {
    @JsonProperty("id")
    private float id;

    @JsonProperty("fechaCreacion")
    private String fechaCreacion;

    @JsonProperty("fechaFin")
    private String fechaFin;

    @JsonProperty("fechas")
    private ArrayList < String > fechas = new ArrayList < String > ();
    
    @JsonProperty("fechasFaltantes")
    ArrayList < String > fechasFaltantes = new ArrayList < String > ();
   
   
    // Getter Methods 
   
    public float getId() {
     return id;
    }
   
    public String getFechaCreacion() {
     return fechaCreacion;
    }
   
    public String getFechaFin() {
     return fechaFin;
    }

    public ArrayList<String> getFechas(){
        return fechas;
    }
    public ArrayList<String> getFechasFaltantes(){
        return fechasFaltantes;
    }
   
    // Setter Methods 
   
    public void setId(float id) {
     this.id = id;
    }
   
    public void setFechaCreacion(String fechaCreacion) {
     this.fechaCreacion = fechaCreacion;
    }
   
    public void setFechaFin(String fechaFin) {
     this.fechaFin = fechaFin;
}
public void setFechas(ArrayList<String> fechas){
    this.fechas=fechas;
}

public void setFechasFaltantes(ArrayList<String> fechasFaltantes){
    this.fechasFaltantes=fechasFaltantes;
}
}