package com.eofsentinel.ecommerceWebApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private String brand;

    private BigDecimal price;

    private String category;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")  // Handled in react now
    private Date releaseDate;

    private boolean productAvailable;

    private int stockQuantity;

    private String imageName;

    private String imageType;

    @Lob
    private byte[] imageData;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", releaseDate=" + releaseDate +
                ", productAvailable=" + productAvailable +
                ", stockQuantity=" + stockQuantity +
                ", imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageSizeInBytes=" + imageData.length +
                '}';
    }
}
