package br.com.uplandapis.loja.http.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class UserFromContext {

    public static String getUserFromContext() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
