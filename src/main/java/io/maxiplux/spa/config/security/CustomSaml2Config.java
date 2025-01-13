package io.maxiplux.spa.config.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Security;

@Component
public class CustomSaml2Config {

    @PostConstruct
    public void init() {
        Security.addProvider(new BouncyCastleProvider());
    }
}
