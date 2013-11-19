package nortal.lab.security.controllers;

import java.security.Principal;

import nortal.lab.security.auth.CustomAuthenticationToken;
import nortal.lab.security.entities.User;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class PrincipalAdvice {
    
    @ModelAttribute("user")
    public User loggedIn(final Principal principal) {

        if (principal instanceof CustomAuthenticationToken) {
            CustomAuthenticationToken token = (CustomAuthenticationToken) principal;

            return token.getUser();
        }
        return null;
    }
}
