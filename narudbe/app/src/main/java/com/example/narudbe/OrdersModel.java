package com.example.narudbe;

public class OrdersModel {

    private int id;
    private String order;
    private String for_the;
    private boolean isChecked;

    public OrdersModel(int id, String order, String for_the, boolean isChecked) {
        this.id = id;
        this.order = order;
        this.for_the = for_the;
        this.isChecked = isChecked;
    }

    public OrdersModel() {

    }

    @Override
    public String toString() {
        return "OrdersModel{" +
                "id=" + id +
                ", order='" + order + '\'' +
                ", for_the='" + for_the + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFor_the() {
        return for_the;
    }

    public void setFor_the(String for_the) {
        this.for_the = for_the;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

