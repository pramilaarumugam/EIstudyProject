package behavioral.observer;

public class NewsChannel implements Channel {
    private String name;
    private String news;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        this.news = news;
        System.out.println(name + " received news: " + news);
    }
}
