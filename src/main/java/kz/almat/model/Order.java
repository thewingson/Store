package kz.almat.model;


import kz.almat.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "ORDER_SEQ_ID", name = "ORDER_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "SHIP_DATE")
    private Timestamp shipDate;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "ORDER_STATUS")
    @NotNull
    private OrderStatus orderStatus;

    @Column(name = "COMPLETE")
    @NotNull
    private Boolean complete = false;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORDER_ID", updatable = false)
    private List<Product> products = new ArrayList<Product>();

}
