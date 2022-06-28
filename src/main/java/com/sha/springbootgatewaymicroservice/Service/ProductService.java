package com.sha.springbootgatewaymicroservice.Service;

import com.google.gson.JsonElement;
import com.sha.springbootgatewaymicroservice.request.IProductServiceRequest;
import com.sha.springbootgatewaymicroservice.utils.RetrofitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService implements IProductService {

    @Autowired
    private IProductServiceRequest productServiceRequest;

    @Override
    public JsonElement saveProduct(JsonElement request) {
        return RetrofitUtils.executeInBlock(productServiceRequest.saveProduct(request));
    }

    @Override
    public void deleteProduct(Long id) {
        RetrofitUtils.executeInBlock(productServiceRequest.deleteProduct(id));
    }

    @Override
    public List<JsonElement> getAllProducts() {
        return RetrofitUtils.executeInBlock(productServiceRequest.getAllProducts());
    }
}
