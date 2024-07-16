package com.m2ibank.service;

import com.m2ibank.config.jwt.JWTProvider;
import com.m2ibank.model.Customer;
import com.m2ibank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;

    @Autowired
    public UserService(CustomerRepository customerRepository,
                       PasswordEncoder passwordEncoder,
                       @Lazy AuthenticationManager authenticationManager,
                       JWTProvider jwtProvider
    ) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Customer not found"));
    }

    public Customer createCustomer(Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customer.setRoles("ROLE_CUSTOMER");
        customerRepository.save(customer);
        return customer;
    }

    public boolean verifyCustomer(String email, String password) {
        return customerRepository.findByEmail(email).map(customer -> passwordEncoder.matches(password, customer.getPwd()))
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));
    }

    public boolean userNameExists(String email) {
        return customerRepository.findByEmail(email).isPresent();
    }

    public String generateJwt(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Customer customer = customerRepository.findByEmail(email).orElse(null);
        int id = customer != null ? customer.getId() : 0;
        return jwtProvider.generateToken(authentication, id);
    }




}
