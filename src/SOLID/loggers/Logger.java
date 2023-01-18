package SOLID.loggers;

import SOLID.appenders.AppendersService;

import java.util.Arrays;

public class Logger implements LoggerService{

    private   AppendersService[] appenders;

    public Logger(AppendersService... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(timeStamp,ReportLevels.INFO , message));
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(timeStamp,ReportLevels.WARNING , message));
    }

    @Override
    public void logError(String timeStamp, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(timeStamp,ReportLevels.ERROR , message));
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(timeStamp,ReportLevels.CRITICAL , message));
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        Arrays.stream(appenders).forEach(appender -> appender.append(timeStamp,ReportLevels.FATAL , message));
    }
}
