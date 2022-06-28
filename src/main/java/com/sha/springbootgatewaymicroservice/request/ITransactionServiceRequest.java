package com.sha.springbootgatewaymicroservice.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ITransactionServiceRequest {
    @POST("api/v1/transaction")
    Call<JsonElement> saveTransaction(@Body JsonElement requestBody);

    @DELETE("/{api/v1/transaction/{id}")
    Call<Void> deleteTransaction(@Path("id") Long id);

    @GET("api/v1/transaction/{id}")
    Call<List<JsonElement>> getAllTransactionsOfAuthorizedUser(@Path("id") Long id);
}
