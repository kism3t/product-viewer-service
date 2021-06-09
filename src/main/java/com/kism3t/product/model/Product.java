package com.kism3t.product.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String onlineId;
    private String pageTitle;
    private String urlName;
    private String metaData;

    @OneToMany(targetEntity = VariantProduct.class)
    private List<VariantProduct> variantProducts;
}
