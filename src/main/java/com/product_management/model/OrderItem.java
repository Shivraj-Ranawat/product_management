package com.product_management.model;

import jakarta.persistence.*;

@Entity
@Table(name="order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_seq_id")
    private Integer orderItemSeqId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderHeader order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String status;


    public Integer getOrderItemSeqId() {
        return orderItemSeqId;
    }

    public void setOrderItemSeqId(Integer orderItemSeqId) {
        this.orderItemSeqId = orderItemSeqId;
    }

    public OrderHeader getOrder() {
        return order;
    }

    public void setOrder(OrderHeader order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
