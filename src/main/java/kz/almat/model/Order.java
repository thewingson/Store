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
@Table(name = "ORDR")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDR_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "ORDR_SEQ_ID", name = "ORDR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDR_ID", updatable = false)
    private List<OrderProduct> items = new ArrayList<OrderProduct>();

}
