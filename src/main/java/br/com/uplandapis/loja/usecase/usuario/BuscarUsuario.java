package br.com.uplandapis.loja.usecase.usuario;

import br.com.uplandapis.loja.exceptions.BuscarUsuarioException;
import br.com.uplandapis.loja.gateway.entity.User;
import br.com.uplandapis.loja.gateway.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BuscarUsuario {

    private final UserRepository userRepository;

    public User executar(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new BuscarUsuarioException(String.format("User %s not found", username)));
    }
}
