package kz.almat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "CATEGORY_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "CATEGORY_SEQ_ID", name = "CATEGORY_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "products")
    @OneToMany(mappedBy = "CATEGORY")
    private List<Product> products = new ArrayList<Product>();

}
