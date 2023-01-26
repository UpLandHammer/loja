package br.com.uplandapis.loja.http.mappers;


import br.com.uplandapis.loja.http.dtos.UserDTO;
import br.com.uplandapis.loja.gateway.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class UserMapper {

    public static User from(UserDTO userDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .username(userDTO.getUsername())
                .roles("ROLE_USER")
                .password(bCryptPasswordEncoder.encode(userDTO.getPassword()))
                .enabled(true)
                .build();
    }
}
