package structural.adapter;

public class LoggerAdapter implements ILogger {
    private LegacyLogger legacyLogger;

    public LoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void log(String message) {
        legacyLogger.logMessage(message); // adapts interface
    }
}
