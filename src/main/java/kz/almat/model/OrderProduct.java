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
@Table(name = "ORDR_PRODUCT")
public class OrderProduct {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "ORDR_PRODUCT_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "ORDR_PRODUCT_SEQ_ID", name = "ORDR_PRODUCT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "QUANTITY")
    @NotNull
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDR_ID", foreignKey = @ForeignKey(name = "OP_ORDR_FK"))
    private Order order;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", foreignKey = @ForeignKey(name = "OP_PRODUCT_FK"))
    private Product product;


}
