package org.example;

import java.io.FileWriter;
import java.io.IOException;
public class Logger {
    private FileWriter fileWriter;

    public Logger(String logFilePath) {
        try {
            fileWriter = new FileWriter(logFilePath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        try {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
