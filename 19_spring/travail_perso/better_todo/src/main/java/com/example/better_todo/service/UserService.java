package com.example.better_todo.service;

import com.example.better_todo.config.jwt.JwtProvider;
import com.example.better_todo.entity.Role;
import com.example.better_todo.entity.User;
import com.example.better_todo.repository.RoleRepository;
import com.example.better_todo.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    public UserService(final UserRepository userRepository,
                       final RoleRepository roleRepository,
                       final PasswordEncoder passwordEncoder,
                       final JwtProvider jwtProvider,
                       @Lazy
                       final AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(""+id));
    }

    public User createUser(User user) {
        user.setRoles(List.of(new Role("ROLE_USER")));
        System.out.println(user.getRoles());
        return addUser(user);
    }

//    public User createEnterprise(User user) {
//        user.setRoles(List.of(new Role("ROLE_USER"), new Role("ROLE_ENTERPRISE")));
//        return addUser(user);
//    }

    public User createAdmin(User user) {
        user.setRoles(List.of(new Role("ROLE_USER"), new Role("ROLE_ADMIN")));
        return addUser(user);
    }

    private User addUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> roles = user.getRoles().stream()
                    .map(r -> roleRepository.findByRole(r.getRole())
                    .orElse(r)).toList();
            user.setRoles(roles);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid email or password");
        }
    }

//    private boolean verifyUser(User user) {
//        return userRepository.findByEmail(user.getEmail()).map(u -> passwordEncoder.matches(user.getPassword(), u.getPassword()))
//                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));
//    }

    public String generateToken(User user) {
//        if (! verifyUser(user)) throw new BadCredentialsException("Invalid email or password");
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        return jwtProvider.generateToken(auth);
    }

}
