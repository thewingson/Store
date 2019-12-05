package kz.almat.model;

import kz.almat.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USR")
public class User implements UserDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "USR_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "USR_SEQ_ID", name = "USR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "USRNAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHONE")
    private String phone;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ID", updatable = false)
    private List<Order> orders = new ArrayList<Order>();

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @Column(name = "ROLE_ID")
    @Column(name = "ROLE")
    @CollectionTable(name = "USR_ROLE", joinColumns = @JoinColumn(name = "USR_ID"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<Role>();

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
