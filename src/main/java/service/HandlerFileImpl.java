package service;

import storage.FileStorage;
import storage.FileStorageImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Реализация интерфейса сервиса обработки файла */
public class HandlerFileImpl implements HandlerFile {

    private final Map<String, String> mapResult = new LinkedHashMap<>();
    private final FileStorage fileStorage = new FileStorageImpl();

    @Override
    public void handle(List<String> firstList, List<String> secondList) {
        mapResult.clear();

        if (secondList.size() == 1 && firstList.size() == 1) {
            mapResult.put(firstList.get(0), secondList.get(0));
            return;
        }

        for (int i = 0; i < firstList.size(); i++) {

            int maxCount = 0;
            int indexLine = 0;
            String[] tempListFirst = firstList.get(i).split(" ");

            for (int j = 0; j < secondList.size(); j++) {
                int count = 0;
                for (String str : tempListFirst) {
                    if (secondList.get(j).toLowerCase().contains(str.toLowerCase())) {
                        count++;
                        break;
                    }
                }
                if (count > maxCount) {
                    indexLine = j;
                    maxCount = count;
                }
            }
            if (maxCount == 0) {
                mapResult.put(firstList.get(i), "?");
            } else {
                mapResult.put(firstList.get(i), secondList.get(indexLine));
                secondList.remove(indexLine);
            }
        }
        if (!secondList.isEmpty()) {
            for (String str : secondList) {
                mapResult.put(str, "?");
            }
        }
    }

    public void uploadAndProcessFile() {
        fileStorage.load();
        handle(fileStorage.getWordListStart(), fileStorage.getWordListFinish());
        fileStorage.save(mapResult);
    }

    @Override
    public void printResultToConsole() {
        uploadAndProcessFile();
        System.out.println("Результат выполнения");
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        mapResult.entrySet().forEach(System.out::println);
    }

}
