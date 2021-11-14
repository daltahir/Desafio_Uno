package com.previred.dbravo.desafiouno.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.dbravo.desafiouno.Model.ResponseGDD;
import com.previred.dbravo.desafiouno.Model.ResponseService;
import com.previred.dbravo.desafiouno.Model.Url;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("/api/v1")
public class Desafiouno {

    @GetMapping(path = "/faltantes",
    produces= {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<ResponseService>  fechasFaltantes(
        @RequestBody Url url
    ) {
       
        ResponseService respuesta = new ResponseService();
        ResponseEntity<ResponseService> ret =new ResponseEntity<ResponseService>(respuesta,HttpStatus.OK);
        ResponseGDD fechasgdd;
        String apiGdd="http://127.0.0.1:8080/periodos/api";
        if( url!=null 
            && url.getUrl()!=null 
            && !url.getUrl().isEmpty()){
            apiGdd=url.getUrl();    
        }
        try {
            fechasgdd = getGDD(apiGdd);
            respuesta.setId(fechasgdd.getId());
            respuesta.setFechaCreacion(fechasgdd.getFechaCreacion());
            respuesta.setFechaFin(fechasgdd.getFechaFin());
            respuesta.setFechas(fechasgdd.getFechas());
            respuesta.setFechasFaltantes(getfechasFaltantes(fechasgdd.getFechaCreacion(), 
                                                            fechasgdd.getFechaFin(), 
                                                            fechasgdd.getFechas()));
        } catch (IOException e) {
            ret =new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

       
        return ret;

    }

    protected ArrayList<String> getfechasFaltantes(String fechaCreacion, String fechaFin, ArrayList<String> fechas){
        ArrayList<String> fechasFaltantes = new ArrayList<String>();
        LocalDate finicio = LocalDate.parse(fechaCreacion);
        LocalDate ffin = LocalDate.parse(fechaFin);
        while(finicio.compareTo(ffin)<=0){
            if(!fechas.contains(finicio.toString())){
                fechasFaltantes.add(finicio.toString());
            }
            finicio=finicio.plusMonths(1);
        }      
        return fechasFaltantes;
    }
    protected ResponseGDD getGDD(String url) throws IOException {
        ResponseGDD respuestaGDD = new ResponseGDD();
        
        Response response;

        OkHttpClient client = new OkHttpClient()
                                    .newBuilder()
                                    .build();
        Request request = new Request
                                .Builder()
                                .url(url)
                                .method("GET", null)
                                .addHeader("Accept", "application/json")
                                .build();
     
            response = client
                        .newCall(request)
                        .execute();
            if (response.code() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                respuestaGDD= mapper.readValue(response.body().string(), ResponseGDD.class);
            }
        return respuestaGDD;

    }
}
