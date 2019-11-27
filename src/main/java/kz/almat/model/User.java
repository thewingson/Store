package kz.almat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USR")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "USR_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "USR_SEQ_ID", name = "USR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME")
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

}
