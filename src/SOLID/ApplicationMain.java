package SOLID;

import SOLID.appenders.AppendersService;
import SOLID.appenders.ConsoleAppender;
import SOLID.appenders.FileAppender;
import SOLID.layouts.LayoutService;
import SOLID.layouts.SimpleLayout;
import SOLID.layouts.XmlLayout;
import SOLID.loggers.File;
import SOLID.loggers.LogFile;
import SOLID.loggers.Logger;
import SOLID.loggers.LoggerService;

import java.util.Scanner;

public class ApplicationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LayoutService simpleLayout = new SimpleLayout();
        AppendersService consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        AppendersService fileAppender = new FileAppender(simpleLayout,file);

        Logger logger = new Logger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
        System.out.println();
    }
}
