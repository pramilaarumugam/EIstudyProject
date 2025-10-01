package creational.builder;

public class ReportBuilder {
    private Report report;

    public ReportBuilder() {
        report = new Report();
    }

    public ReportBuilder setTitle(String title) {
        report.setTitle(title);
        return this;
    }

    public ReportBuilder setHeader(String header) {
        report.setHeader(header);
        return this;
    }

    public ReportBuilder setBody(String body) {
        report.setBody(body);
        return this;
    }

    public ReportBuilder setFooter(String footer) {
        report.setFooter(footer);
        return this;
    }

    public Report build() {
        return report;
    }
}

