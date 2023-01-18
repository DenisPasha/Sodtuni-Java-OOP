package SOLID.appenders;

import SOLID.layouts.LayoutService;
import SOLID.loggers.File;
import SOLID.loggers.LogFile;
import SOLID.loggers.ReportLevels;

public class FileAppender implements AppendersService{

    private LayoutService layout;
    private File file;

    public FileAppender(LayoutService layout,File file) {
        this.layout = layout;
        this.file = file;
    }


    @Override
    public void append(String timeStamp, ReportLevels reportLevels, String message) {
        file.write(layout.format(timeStamp, String.valueOf(reportLevels),message));
    }
}
