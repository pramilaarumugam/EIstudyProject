package behavioral.observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");

        agency.addObserver(cnn);
        agency.addObserver(bbc);

        agency.setNews("Breaking News: New Observer Pattern Implemented!");
        agency.setNews("Update: Observer Pattern in Java Project");
    }
}
