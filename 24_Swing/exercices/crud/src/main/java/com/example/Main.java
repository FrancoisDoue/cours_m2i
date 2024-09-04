package com.example;

import com.example.ui.MainUI;
import com.example.util.DatabaseManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.getInstance();
        new MainUI();
//        DatabaseManager.close();
    }
}