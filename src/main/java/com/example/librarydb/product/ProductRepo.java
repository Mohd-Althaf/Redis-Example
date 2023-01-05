package com.example.librarydb.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    @Autowired
    private RedisConfig redisConfig;

    public product save( product p){
        redisConfig.redisTemplate().opsForHash().put("product",p.getProId(),p);
        return p;
    }

    public List<Object> findAll(){

        System.out.println(redisConfig.redisTemplate().opsForHash().get("product",0));
        return redisConfig.redisTemplate().opsForHash().values("product");
    }

    public product findById(int id){
        return (product) redisConfig.redisTemplate().opsForHash().get("product",id);
    }

    public String delete(int id){
        redisConfig.redisTemplate().opsForHash().delete("product",id);
        return "deleted";
    }
}
