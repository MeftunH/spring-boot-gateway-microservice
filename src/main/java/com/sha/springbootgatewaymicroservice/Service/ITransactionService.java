package com.sha.springbootgatewaymicroservice.Service;

import com.google.gson.JsonElement;

import java.util.List;

public interface ITransactionService {
    JsonElement saveTransaction(JsonElement request);

    void deleteTransaction(Long id);

    List<JsonElement> getAllTransactionsOfAuthorizedUser(Long id);
}
