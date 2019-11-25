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
@Table(name = "VENDOR")
public class Vendor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "VENDOR_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "VENDOR_SEQ_ID", name = "VENDOR_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    private String name;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "VENDOR_ID")
//    List<Product> products = new ArrayList<Product>();

}
