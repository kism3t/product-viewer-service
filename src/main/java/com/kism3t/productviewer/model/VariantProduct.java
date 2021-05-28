package com.kism3t.productviewer.model;

import java.util.List;

public class VariantProduct extends Product {
    private String onlineId;
    private String name;
    private String erpId;
    private List<String> images;
    private List<String> downloads;
    private int deliveryTime;
    private double price;
    private Product master;
    private int orderId;
}
