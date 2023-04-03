package storage;

import java.util.List;
import java.util.Map;

/** Интерфейс взаимодействия с хранилищем, загрузка и сохранение результата в файл */

public interface FileStorage {

    void save(Map<String, String> mapWords);

    void load();

    List<String> getWordListStart();

    List<String> getWordListFinish();
}
