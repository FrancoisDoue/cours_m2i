package org.design_patterns.demo.proxy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
    private RealInternet realInternet;
    private List<String> allowedUrl;

    public ProxyInternet() {
        realInternet = new RealInternet();
        allowedUrl = new ArrayList<>(Arrays.asList("m2iformation.fr", "github.com"));
    }

    @Override
    public void connect(String url) throws RuntimeException {
        boolean allowed = allowedUrl.stream().anyMatch(url::contains);
        if (!allowed) throw new RuntimeException("URL not allowed: " + url);
        realInternet.connect(url);
    }
}
