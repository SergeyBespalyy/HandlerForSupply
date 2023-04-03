package service;

import java.util.List;

/** Интерфейс сервиса обработки файла */

public interface HandlerFile {
    void handle(List<String> firstList, List<String> secondList);

    void uploadAndProcessFile();
    void printResultToConsole();
}
