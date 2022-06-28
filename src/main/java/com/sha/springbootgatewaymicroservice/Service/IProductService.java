package com.sha.springbootgatewaymicroservice.Service;

import com.google.gson.JsonElement;

import java.util.List;

public interface IProductService {
    JsonElement saveProduct(JsonElement request);

    void deleteProduct(Long id);

    List<JsonElement> getAllProducts();
}
