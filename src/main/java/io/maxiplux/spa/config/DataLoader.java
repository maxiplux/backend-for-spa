package io.maxiplux.spa.config;

import io.maxiplux.spa.models.Role;
import io.maxiplux.spa.models.User;
import io.maxiplux.spa.repositories.RoleRepository;
import io.maxiplux.spa.services.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

//@Component
@Transactional
@Configuration
@Slf4j
public class DataLoader implements ApplicationRunner {

    @Autowired
    @Qualifier("CustomUserDetailsService")
    private UserServices userServices;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role=this.userServices.saveRole(Role.builder().authority("ROLE_ADMIN").build());
        Role role2=this.userServices.saveRole(Role.builder().authority("ROLE_USER").build());
        List<Role> roles=List.of(role,role2);

        User user= User.builder().username("admin").password(this.passwordEncoder.encode("admin")).enabled(true).roles(roles).build();
        this.userServices.saveUser(user);
        log.info("DataLoader is running");
    }


}
