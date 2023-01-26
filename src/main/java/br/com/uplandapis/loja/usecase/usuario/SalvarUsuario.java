package br.com.uplandapis.loja.usecase.usuario;

import br.com.uplandapis.loja.gateway.entity.User;
import br.com.uplandapis.loja.gateway.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SalvarUsuario {

    private final UserRepository userRepository;
    public void executar(User user) {
        userRepository.save(user);
    }
}
