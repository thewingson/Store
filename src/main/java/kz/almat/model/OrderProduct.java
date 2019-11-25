package kz.almat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDER_PRODUCT_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "ORDER_PRODUCT_SEQ_ID", name = "ORDER_PRODUCT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "QUANTITY")
    @NotNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID", foreignKey = @ForeignKey(name = "OP_ORDER_FK"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "OP_PRODUCT_FK"))
    private Product product;


}
