package com.kism3t.product.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
public class VariantProduct implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String onlineId;
    private String name;
    private String erpId;

    @ElementCollection
    private List<String> downloads;

    @ElementCollection
    private List<String> images;

    private int deliveryTime;
    private double price;

    private int orderId;
}
