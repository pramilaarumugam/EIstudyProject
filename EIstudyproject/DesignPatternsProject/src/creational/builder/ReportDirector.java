package creational.builder;

public class ReportDirector {
    public Report buildDailyReport() {
        return new ReportBuilder()
                .setTitle("Daily Report")
                .setHeader("Header: Sales & Operations")
                .setBody("Body: Data, Charts, Graphs")
                .setFooter("Footer: Confidential")
                .build();
    }

    public Report buildWeeklyReport() {
        return new ReportBuilder()
                .setTitle("Weekly Report")
                .setHeader("Header: Weekly Summary")
                .setBody("Body: Sales Analysis, Charts, Graphs")
                .setFooter("Footer: Management Only")
                .build();
    }
}

