package br.com.uplandapis.loja.http.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AccessDTO {

    private String username;
    private String uri;
    private String elapsedTime;
    private String host;
    private String local;
}
