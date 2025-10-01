package creational.builder;

public class Report {
    private String title;
    private String header;
    private String body;
    private String footer;

    // setters
    public void setTitle(String title) { this.title = title; }
    public void setHeader(String header) { this.header = header; }
    public void setBody(String body) { this.body = body; }
    public void setFooter(String footer) { this.footer = footer; }

    public void showReport() {
        System.out.println("----- " + title + " -----");
        System.out.println(header);
        System.out.println(body);
        System.out.println(footer);
        System.out.println("----------------------");
    }
}
