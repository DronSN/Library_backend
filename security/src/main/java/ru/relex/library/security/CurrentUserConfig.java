package ru.relex.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import ru.relex.commons.model.CurrentUser;
import ru.relex.commons.model.LoggedUser;

@Configuration
public class CurrentUserConfig {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    CurrentUser currentUser() {
        final Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if (principal == null) {
            throw new IllegalStateException("Current user must be set");
        }
        if(!(principal instanceof CurrentUser)){
            return new LoggedUser(null, null, 0);
        } else {
            return (CurrentUser) principal;
        }
    }
}
