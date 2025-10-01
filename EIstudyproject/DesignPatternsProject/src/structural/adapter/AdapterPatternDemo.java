package structural.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // legacy logger instance
        LegacyLogger legacy = new LegacyLogger();

        // adapter wraps legacy logger
        ILogger logger = new LoggerAdapter(legacy);

        logger.log("This is a test message.");
        logger.log("Adapter Pattern implemented successfully!");
    }
}

