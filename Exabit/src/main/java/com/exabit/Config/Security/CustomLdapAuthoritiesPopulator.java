package main.java.com.exabit.Config.Security;

import main.java.com.exabit.Entities.AuthoritiesEntity;
import main.java.com.exabit.Entities.UsersEntity;
import main.java.com.exabit.Repositories.AuthoritiesEntityRepository;
import main.java.com.exabit.Repositories.UsersEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nikostot on 4/9/2016.
 */

@Service("authLdapService")
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {

    @Autowired
    private AuthoritiesEntityRepository authoritiesEntityRepository;

    @Autowired
    private UsersEntityRepository usersEntityRepository;

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations dirContextOperations, String s) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        Attributes uid = dirContextOperations.getAttributes();
        String suid = uid.get("uid").getID();
        System.out.println("Uid : " + suid);

        UsersEntity user = usersEntityRepository.findByuid(suid);

        AuthoritiesEntity authority = authoritiesEntityRepository.findByNumber( user.getIdAuthority() );

        if( authority != null ){
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return authorities;
    }
}
