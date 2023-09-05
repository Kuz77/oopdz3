package org.example;

//Занятие 3: Некоторые стандартные интерфейсы Java и примеры их использования.
//
//        1) Создать класс календарь (поработать с перечислениями)
//        2) Практика перечислений :
//        Создать перечисление фруктов, сравнить их значение в switch case с различным выводом по каждому типу.
//        3) Разработка игры “быки - коровы” (игрок против компьютера)
//        a)	Интерфейс взаимодействий Game (должны быть описаны сигнатуры методов start, inputValue,getGameStatus)
//        b)	Абстрактный класс AbstractGame (который предзаполняет слово компьютера - generateWord(), на основе generateCharList() - который является абстрактным методом)
//        c)	Статусная модель с помощью перечислений(GameStatus)
//        d)	Класс ответа Answer
//        e)	Классы реализующие AbstractGame(предполагается игра на числах,англ буквах, русских буквах)
//        f)	* реализовать restart().
//
//        Правила игры:
//        Быки и коровы — логическая игра, в ходе которой
//        за несколько попыток один из игроков должен определить,
//        что задумал другой игрок. Варианты игры могут зависеть
//        от типа отгадываемой последовательности — это могут быть
//        числа, цвета, пиктограммы или слова. После каждой попытки
//        задумавший игрок выставляет «оценку», указывая количество
//        угаданного без совпадения с их позициями (количество «коров»)
//        и полных совпадений (количество «быков»). Роли участников игры
//        не равнозначны — угадывающий должен анализировать сделанные попытки
//        и полученные оценки, то есть его роль активна. Его партнёр лишь
//        сравнивает очередной вариант с задуманным и выставляет оценку по
//        формальным правилам, то есть его роль пассивна. Для уравновешивания
//        ролей одновременно играют две встречные партии.
//
//        Пример (загадываемое слово 1234)
//        Ввод 1243
//        Вывод 4 коровы 2 быка



import java.util.Scanner;

public class Main {
    private static final String LOG_TXT = "game_log.txt";

    public static void main(String[] args) {
        Logger logger = new Logger(LOG_TXT);

        Game game = new EngGame();
        game.start(3, 2);

        Scanner scanner = new Scanner(System.in);
        while (!game.getGameStatus().equals(GameStatus.WINNER) && !game.getGameStatus().equals(GameStatus.LOSE)) {
            String scannerWord = scanner.nextLine();
            Answer answer = game.inputValue(scannerWord);

            logger.log("User input: " + scannerWord);
            logger.log("Answer: " + answer);

            System.out.println("answer = " + answer);
        }

        logger.log("Game status: " + game.getGameStatus());
        logger.close();

        System.out.println(game.getGameStatus());
    }
}