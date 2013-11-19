package nortal.lab.security.auth;

import java.util.Collection;

import nortal.lab.security.entities.User;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -4624220549947782224L;

    private final User user;

    public CustomAuthenticationToken(final User user, final Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        super.setAuthenticated(true);
        this.user = user;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }
}
