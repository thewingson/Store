package kz.almat.security;

import kz.almat.model.User;
import kz.almat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User does not exist!");
        }

//        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//
//        for (Role role : user.getRoles()) {
//            roles.add(new SimpleGrantedAuthority(role.name()));
//        }
//
//        roles.add(new SimpleGrantedAuthority(Role.USER.name()));
//
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
//
//        return userDetails;

        return user;
    }
}
