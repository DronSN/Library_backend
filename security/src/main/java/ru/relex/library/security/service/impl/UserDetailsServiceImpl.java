package ru.relex.library.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.relex.library.db.mappers.UserSecurityMapper;
import ru.relex.library.security.model.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserSecurityMapper mapper;

    @Autowired
    public UserDetailsServiceImpl(UserSecurityMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = mapper.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + "not found");
        }
        return new UserDetailsImpl(user);
    }
}
