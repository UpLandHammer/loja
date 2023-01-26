package br.com.uplandapis.loja.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String username;
    private String password;
}