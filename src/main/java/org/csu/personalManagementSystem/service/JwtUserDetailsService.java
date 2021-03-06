package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Account;
import org.csu.personalManagementSystem.domain.Role;
import org.csu.personalManagementSystem.domain.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;
    @Override
    public UserDetail loadUserByUsername(String userId) throws UsernameNotFoundException {

        Account account=accountService.getAccountByUsername (userId);

        System.out.println ("userId"+userId);
        System.out.println ("usernamae"+account.getUsername ());
        System.out.println ("password"+account.getPassword ());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<> ();

        if (account != null) {
            //获取该用户所拥有的权限
            Role sysRoles = roleService.getRoleByUserId (userId);

            System.out.println ("role"+sysRoles.getName ());
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority (sysRoles.getName ());
            grantedAuthorities.add(grantedAuthority);
            // 声明用户授权
//            sysRoles.forEach(sysPermission -> {
//                System.out.println ("role"+sysPermission.getName ());
//                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority (sysPermission.getName ());
//                grantedAuthorities.add(grantedAuthority);
//            });
        }

//        User user=User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
        UserDetail userDetail= new UserDetail (userId,grantedAuthorities);
        return userDetail;
    }
}
