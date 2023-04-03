package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Реализация интерфейса взаимодействия с хранилищем, загрузка и сохранение результата в файл */
public class FileStorageImpl implements FileStorage {
    private final String fileLoadPath = "src/main/resources/input.txt";
    private final String fileSavePath = "src/main/resources/output.txt";
    private final String templateWrite = "%s:%s\n";

    private final List<String> wordListStart = new ArrayList<>();
    private final List<String> wordListFinish = new ArrayList<>();


    public void load() {
        wordListStart.clear();
        wordListFinish.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(fileLoadPath))) {
            int startCountLine = Integer.parseInt(br.readLine());

            for (int i = 0; i < startCountLine; i++) {
                wordListStart.add(br.readLine());
            }

            int finishCountLine = Integer.parseInt(br.readLine());

            for (int i = 0; i < finishCountLine; i++) {
                wordListFinish.add(br.readLine());
            }
        } catch (IOException ioException) {
            System.out.println("Файл загрузки записей не найден");
        }
    }

    public void save(Map<String, String> mapWords) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileSavePath))) {

            for (Map.Entry<String, String> entry : mapWords.entrySet()) {
                fileWriter.write(String.format(templateWrite, entry.getKey(), entry.getValue()));
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка записи в файл");
        }
    }

    public List<String> getWordListStart() {
        return wordListStart;
    }

    public List<String> getWordListFinish() {
        return wordListFinish;
    }
}
