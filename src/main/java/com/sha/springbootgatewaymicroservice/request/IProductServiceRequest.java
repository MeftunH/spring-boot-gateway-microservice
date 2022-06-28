package com.sha.springbootgatewaymicroservice.request;

import com.google.gson.JsonElement;
import lombok.Getter;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface IProductServiceRequest {
    @POST("api/v1/products")
    Call<JsonElement> saveProduct(@Body JsonElement requestBody);

    @DELETE("api/v1/products/{id}")
    Call<Void> deleteProduct(@Path("id") Long id);

    @GET("api/v1/products")
    Call<List<JsonElement>> getAllProducts();
}
