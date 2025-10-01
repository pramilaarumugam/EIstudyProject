package creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        ReportDirector director = new ReportDirector();

        Report dailyReport = director.buildDailyReport();
        Report weeklyReport = director.buildWeeklyReport();

        dailyReport.showReport();
        weeklyReport.showReport();
    }
}

