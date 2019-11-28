package kz.almat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "PRODUCT_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "PRODUCT_SEQ_ID", name = "PRODUCT_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "PRICE")
    @NotNull
    private Integer price;

    @Column(name = "QUANTITY")
    @NotNull
    private Integer quantity;

    @JoinColumn(name = "CATEGORY_ID", foreignKey = @ForeignKey(name = "PRODUCT_CATEGORY_FK"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JoinColumn(name = "VENDOR_ID", foreignKey = @ForeignKey(name = "PRODUCT_VENDOR_FK"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Vendor vendor;

}



