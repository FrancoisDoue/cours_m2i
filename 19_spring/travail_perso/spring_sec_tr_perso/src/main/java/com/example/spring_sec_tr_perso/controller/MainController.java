package com.example.spring_sec_tr_perso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping
    public ResponseEntity<Map<String, String>> base() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "API ok");
        return ResponseEntity.ok(map);
    }

}
