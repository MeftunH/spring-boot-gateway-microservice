package com.sha.springbootgatewaymicroservice.Service;

import com.google.gson.JsonElement;
import com.sha.springbootgatewaymicroservice.request.ITransactionServiceRequest;
import com.sha.springbootgatewaymicroservice.utils.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionServiceRequest transactionServiceRequest;

    @Override
    public JsonElement saveTransaction(JsonElement request) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(request));
    }

    @Override
    public void deleteTransaction(Long id) {
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(id));
    }

    @Override
    public List<JsonElement> getAllTransactionsOfAuthorizedUser(Long id) {
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionsOfAuthorizedUser(id));
    }
}
