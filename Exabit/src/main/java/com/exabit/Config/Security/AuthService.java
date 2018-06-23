package main.java.com.exabit.Config.Security;

import main.java.com.exabit.Entities.AuthoritiesEntity;
import main.java.com.exabit.Entities.CustomUserEntity;
import main.java.com.exabit.Entities.UsersEntity;
import main.java.com.exabit.Repositories.AuthoritiesEntityRepository;
import main.java.com.exabit.Repositories.UsersEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikostot on 4/9/2016.
 */

@Service("authService")
public class AuthService implements UserDetailsService {

    @Autowired
    private UsersEntityRepository usersEntityRepository;

    @Autowired
    private AuthoritiesEntityRepository authoritiesEntityRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UsersEntity user = usersEntityRepository.findByusername(s);

        CustomUserEntity usr = null;

        if( user != null ){

            try {
                usr = new CustomUserEntity(user.getEmail(), new String(user.getPassword(),"UTF-8"),
                        true, true, true, true, getGrantedAuthorities(user), user.getIdUsers());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return usr;

    }

    private List<GrantedAuthority> getGrantedAuthorities(UsersEntity usr){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if( usr == null ) return  authorities;

        AuthoritiesEntity authority = authoritiesEntityRepository.findByNumber( usr.getIdAuthority() );

        if( authority != null ){
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return authorities;
    }

}
