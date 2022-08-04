package com.example.transferdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "data")

public class User {
    @Column(name = "internal_id", nullable = false)
    private Long internal_id;

    @Column(name = "to_id", nullable = false)
    private Integer to_id;

    @Column(name = "to_number", nullable = false)
    private Integer to_number;

    @Column(name = "fulfillment_date" , nullable = false)
    private String fulfillment_date;

    @Column(name = "fulfillment_id" , nullable = false)
    private Integer fulfillment_id;

    @Column(name = "fulfillment_number" , nullable = false)
    private Integer fulfillment_number;

    @Id
    @Column(name = "line_unique_key" , nullable = false)
    private Integer line_unique_key;

    @Column(name = "item", nullable = false)
    private String item;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "length" , nullable = false)
    private Integer length;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "unit_weight" , nullable = false)
    private Double unit_weight;

    @Column(name = "carton_weight", nullable = false)
    private Double carton_weight;

    @Column(name = "type" , nullable = false)
    private String type;

//    public user(Integer internalID, Integer toID, Integer to_Number, String fulfillment_Date, Integer fulfillmentID, Integer fulfillment_Number, Integer line_Unique_Key, String item, Integer quantity, Integer length, Integer width, Integer height, String unit_Weight, Long carton_Weight, String type) {
//        InternalID = internalID;
//        ToID = toID;
//        To_Number = to_Number;
//        Fulfillment_Date = fulfillment_Date;
//        FulfillmentID = fulfillmentID;
//        Fulfillment_Number = fulfillment_Number;
//        Line_Unique_Key = line_Unique_Key;
//        Item = item;
//        Quantity = quantity;
//        Length = length;
//        Width = width;
//        Height = height;
//        Unit_Weight = unit_Weight;
//        Carton_Weight = carton_Weight;
//        Type = type;
//    }


    public Long getInternal_id() {
        return internal_id;
    }

    public void setInternal_id(Long internal_id) {
        this.internal_id = internal_id;
    }

    public Integer getTo_id() {
        return to_id;
    }

    public void setTo_id(Integer to_id) {
        this.to_id = to_id;
    }

    public Integer getTo_number() {
        return to_number;
    }

    public void setTo_number(Integer to_number) {
        this.to_number = to_number;
    }

    public String getFulfillment_date() {
        return fulfillment_date;
    }

    public void setFulfillment_date(String fulfillment_date) {
        this.fulfillment_date = fulfillment_date;
    }

    public Integer getFulfillment_id() {
        return fulfillment_id;
    }

    public void setFulfillment_id(Integer fulfillment_id) {
        this.fulfillment_id = fulfillment_id;
    }

    public Integer getFulfillment_number() {
        return fulfillment_number;
    }

    public void setFulfillment_number(Integer fulfillment_number) {
        this.fulfillment_number = fulfillment_number;
    }

    public Integer getLine_unique_key() {
        return line_unique_key;
    }

    public void setLine_unique_key(Integer line_unique_key) {
        this.line_unique_key = line_unique_key;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getUnit_weight() {
        return unit_weight;
    }

    public void setUnit_weight(Double unit_weight) {
        this.unit_weight = unit_weight;
    }

    public Double getCarton_weight() {
        return carton_weight;
    }

    public void setCarton_weight(Double carton_weight) {
        this.carton_weight = carton_weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "user{" +
                "internal_id=" + internal_id +
                ", to_id=" + to_id +
                ", to_number=" + to_number +
                ", fulfillment_date='" + fulfillment_date + '\'' +
                ", fulfillment_id=" + fulfillment_id +
                ", fulfillment_number=" + fulfillment_number +
                ", line_unique_key=" + line_unique_key +
                ", item='" + item + '\'' +
                ", quantity=" + quantity +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", unit_weight=" + unit_weight +
                ", carton_weight=" + carton_weight +
                ", type='" + type + '\'' +
                '}';
    }
}