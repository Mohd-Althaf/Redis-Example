package com.example.librarydb.product;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RedisHash("product")
public class product implements Serializable {
    private int price;
    private int quantity;
    @Id
    @GeneratedValue
    private int proId;
    private String pName;
}
