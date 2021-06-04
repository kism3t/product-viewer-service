package com.kism3t.product.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String onlineId;
    private String pageTitle;
    private String urlName;
    private String metaData;

    @Transient
    private List<VariantProduct> variantProducts;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOnlineId() {
        return onlineId;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getUrlName() {
        return urlName;
    }

    public String getMetaData() {
        return metaData;
    }
}
