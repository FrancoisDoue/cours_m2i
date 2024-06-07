package org.bdd_exo_1.service;

import org.bdd_exo_1.entity.Account;
import org.bdd_exo_1.entity.Order;
import org.bdd_exo_1.entity.Product;
import org.bdd_exo_1.exception.AccountNotLoggedException;
import org.bdd_exo_1.repository.impl.OrderRepository;

public class OrderService {

    private final AccountService accountService;
    private final ProductService productService;

    private final OrderRepository orderRepository;

    public OrderService(AccountService accountService, ProductService productService, OrderRepository oRepository) {
        this.accountService = accountService;
        this.productService = productService;
        this.orderRepository = oRepository;
    }

    public Order createOrder(Account account) {
        if (account == null || !account.isLogged())
            throw new AccountNotLoggedException("Account not logged.");
        return new Order(account);
    }

    public Order confirmOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
