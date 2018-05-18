package com.fpt.assignment.assignment.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Tên không thể để trống.")
    @Size(min = 10, message = "Tên phải dài hơn 10ký tự.")
    private String foodname;
    private String foodcategory;
    private String desciption;
    @NotBlank(message = "Cần có ảnh đại diện cho sản phẩm.")
    private String imgUrl;
    @Min(1)
    private int price;
    private String timeSell;
    private String editTime;
    private String status;

    public Food() {
    }

    public Food(@NotBlank(message = "Tên không thể để trống.") @Size(min = 10, message = "Tên phải dài hơn 10ký tự.") String foodname, String foodcategory, String desciption, @NotBlank(message = "Cần có ảnh đại diện cho sản phẩm.") String imgUrl, @Min(1) int price, String timeSell, String editTime, String status) {
        this.foodname = foodname;
        this.foodcategory = foodcategory;
        this.desciption = desciption;
        this.imgUrl = imgUrl;
        this.price = price;
        this.timeSell = timeSell;
        this.editTime = editTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodcategory() {
        return foodcategory;
    }

    public void setFoodcategory(String foodcategory) {
        this.foodcategory = foodcategory;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTimeSell() {
        return timeSell;
    }

    public void setTimeSell(String timeSell) {
        this.timeSell = timeSell;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

