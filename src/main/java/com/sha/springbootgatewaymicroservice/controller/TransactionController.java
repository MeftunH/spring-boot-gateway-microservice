package com.sha.springbootgatewaymicroservice.controller;

import com.google.gson.JsonElement;
import com.sha.springbootgatewaymicroservice.Security.UserPrincipal;
import com.sha.springbootgatewaymicroservice.Service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> saveTransaction(JsonElement request) {
        return ResponseEntity.ok(transactionService.saveTransaction(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactionsOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.ok(transactionService.getAllTransactionsOfAuthorizedUser(principal.getId()));
    }
}
