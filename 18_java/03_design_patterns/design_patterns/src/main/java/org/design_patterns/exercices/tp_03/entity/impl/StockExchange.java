package org.design_patterns.exercices.tp_03.entity.impl;

import java.util.ArrayList;
import java.util.Random;

public class StockExchange extends Thread implements Runnable {
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

    public void updateStockExchange() {
        shares.forEach(Share::updateValue);
    }

    public ArrayList<Share> getShares() {
        return shares;
    }

    public ArrayList<Trader> getTraders() {
        return traders;
    }
    public void run() throws RuntimeException {
        while (true) {
            try {
                sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updateStockExchange();
        }
    }

}
