package com.previred.dbravo.desafiouno.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Url {

@JsonProperty("url")
private String url;

public String getUrl(){
    return url;
}
public void setUrl(String url){
    this.url=url;
}


}
