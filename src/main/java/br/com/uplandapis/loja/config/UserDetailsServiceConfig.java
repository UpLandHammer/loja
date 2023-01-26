package br.com.uplandapis.loja.config;

import br.com.uplandapis.loja.exceptions.BuscarUsuarioException;
import br.com.uplandapis.loja.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class UserDetailsServiceConfig implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(UserDetailsConfig::new)
                .orElseThrow(() -> new BuscarUsuarioException(String.format("User %s not found", username)));
    }
}
