package SOLID.appenders;


import SOLID.loggers.ReportLevels;

public interface AppendersService {
    void append(String timeStamp , ReportLevels reportLevels, String message);
}
