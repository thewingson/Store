package kz.almat.model;


import kz.almat.converter.BooleanConverter;
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
@Table(name = "ORDR")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDR_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "ORDR_SEQ_ID", name = "ORDR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "SHIP_DATE")
    @NotNull
    private Timestamp shipDate;

    @Column(name = "CREATED_AT")
    @NotNull
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @Column(name = "STATUS")
    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PLACED;

    @Column(name = "COMPLETE")
    @Convert(converter = BooleanConverter.class)
    private Boolean complete = false;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDR_ID", updatable = false)
    private List<OrderProduct> items = new ArrayList<OrderProduct>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USR_ID", foreignKey = @ForeignKey(name = "PRODUCT_CATEGORY_FK"))
//    @NotNull
    private User user;

}
