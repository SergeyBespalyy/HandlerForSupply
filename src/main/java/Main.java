import service.HandlerFile;
import service.HandlerFileImpl;
import service.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Menu menu = new Menu();
       HandlerFile handlerFile = new HandlerFileImpl();
       Scanner scanner = new Scanner(System.in);
       System.out.println("Приложение «Обработчик заявок» приветствует Вас!");

        while (true){
            menu.printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1" : {
                    handlerFile.uploadAndProcessFile();
                    System.out.println("Файл успешно обработан. Результаты в файле outpup.exe в директории: src/main/resources");
                    break;
                }
                case "2" : {
                    handlerFile.printResultToConsole();
                    break;
                }
                case "3" : {
                    System.out.println("Программа завершена. До новых встреч!");
                    scanner.close();
                    return;
                }
                default : System.out.println("Извините, такой программы не существует! Введите команду из списка.");
            }
        }
    }
}