package kz.almat.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN,
    MODERATOR,
    USER,
    VENDOR;

    public String getAuthority() {
        return name();
    }
}
