package kz.almat.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDR")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "ORDER_SEQ_ID", name = "ORDER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Set<OrderProduct> items;

}
