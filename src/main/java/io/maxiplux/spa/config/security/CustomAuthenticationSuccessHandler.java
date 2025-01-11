package io.maxiplux.spa.config.security;

import io.maxiplux.spa.models.CustomUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.saml2.provider.service.authentication.DefaultSaml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        // Custom logic after successful authentication
        log.info("Authentication successful for user: {}", authentication.getName());
        if (authentication instanceof Saml2Authentication) {
            Saml2Authentication saml2Auth = (Saml2Authentication) authentication;
            Map<String, List<Object>> attributes =
                    ((DefaultSaml2AuthenticatedPrincipal) saml2Auth.getPrincipal()).getAttributes();

            CustomUserDTO userDTO = CustomUserDTO.builder()
                    .username(getSingleAttribute(attributes, "saml_subject"))
                    .email(getSingleAttribute(attributes, "email"))
                    .groups(attributes.getOrDefault("groups", new ArrayList<>()).stream()
                            .map(Object::toString)
                            .toList())
                    .givenName(getSingleAttribute(attributes, "name"))
                    .authorities(new ArrayList<>(authentication.getAuthorities()))
                    .build();

            HttpSession session = request.getSession();
            session.setAttribute("USER_DTO", userDTO);

            log.info("User successfully authenticated: {}", userDTO.getUsername());


            response.sendRedirect("/app/home"); // Redirect to dashboard after login
        }

    }


    private String getSingleAttribute(Map<String, List<Object>> attributes, String key) {
        List<Object> values = attributes.get(key);
        return values != null && !values.isEmpty() ? values.get(0).toString() : null;
    }
}


