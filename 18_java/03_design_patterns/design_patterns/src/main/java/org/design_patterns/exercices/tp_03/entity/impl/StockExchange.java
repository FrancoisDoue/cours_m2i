package org.design_patterns.exercices.tp_03.entity.impl;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

@Getter
public class StockExchange extends Thread {
    private ArrayList<Share> shares = new ArrayList<>();
    private ArrayList<Trader> traders = new ArrayList<>();

    public StockExchange() {
        for (int i = 1; i < 21; i++) {
            String name = "action_"+i;
            shares.add(new Share(name, 100));
        }
        for (int i = 1; i < 6; i++) {
            String name = "trader_"+i;
            Trader trader = new Trader(name);
            for (int j = 0; j < new Random().nextInt(1,3); j++) {
                trader.subscribeToShare(
                        shares.get(new Random().nextInt(shares.size()))
                );
            }
            traders.add(trader);
        }
    }

    public void run() throws RuntimeException {
        while (true) {
            shares.forEach(Share::updateValue);
            try {
                sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
