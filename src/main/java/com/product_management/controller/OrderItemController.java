package com.product_management.controller;

import com.product_management.model.OrderItem;
import com.product_management.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;


    @PostMapping("/addOrderItem/{orderId}")
    public ResponseEntity<OrderItem> addOrderItem(
            @PathVariable Integer orderId,
            @RequestBody OrderItem orderItem) {
        OrderItem createdItem = orderItemService.addOrderItem(orderId, orderItem);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }


    @PutMapping("/updateOrderItem/{orderItemSeqId}")
    public ResponseEntity<OrderItem> updateOrderItem(
            @PathVariable Integer orderItemSeqId,
            @RequestBody OrderItem orderItem) {
        OrderItem updatedItem = orderItemService.updateOrderItem(orderItemSeqId, orderItem);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }


    @DeleteMapping("/deleteOrderItem/{orderItemSeqId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Integer orderItemSeqId) {
        orderItemService.deleteOrderItem(orderItemSeqId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/getOrderItem/{orderId}")
    public ResponseEntity<List<OrderItem>> getItemsByOrderId(@PathVariable Integer orderId) {
        List<OrderItem> items = orderItemService.getItemsByOrderId(orderId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }



}
