package io.maxiplux.spa.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

//@Component
@Transactional
@Configuration
@Slf4j
public class DataLoader implements ApplicationRunner {

   /* @Autowired
    @Qualifier("CustomUserDetailsService")
    private UserServices userServices;
*/


//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Role role=this.userServices.saveRole(Role.builder().authority("ROLE_ADMIN").build());
//        Role role2=this.userServices.saveRole(Role.builder().authority("ROLE_USER").build());
//        List<Role> roles=List.of(role,role2);
//
//        User user= User.builder().username("admin").password(this.passwordEncoder.encode("admin")).enabled(true).roles(roles).build();
//        this.userServices.saveUser(user);
//        log.info("DataLoader is running");
    }


}
