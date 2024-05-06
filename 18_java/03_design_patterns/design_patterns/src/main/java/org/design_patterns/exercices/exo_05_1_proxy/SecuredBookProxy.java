package org.design_patterns.exercices.exo_05_1_proxy;

public class SecuredBookProxy implements Book {
    private final RealBook book;

    private boolean isUserPremium = false;

    public SecuredBookProxy(String title, String content) {
        book = new RealBook(title, content);
    }

    @Override
    public void readBook() throws RuntimeException {
        if (!isUserPremium)
            throw new RuntimeException("User is not premium");
        book.readBook();
    }

    public void setUserPremium(boolean userPremium) {
        isUserPremium = userPremium;
    }

}
