package SOLID.appenders;

import SOLID.layouts.LayoutService;
import SOLID.layouts.SimpleLayout;
import SOLID.loggers.ReportLevels;

public class ConsoleAppender implements AppendersService{

    private LayoutService layout;

    public ConsoleAppender(LayoutService layout) {
        this.layout = layout;
    }

    @Override
    public void append(String timeStamp , ReportLevels reportLevel, String message) {
        System.out.println(layout.format(timeStamp, String.valueOf(reportLevel),message));
    }
}
