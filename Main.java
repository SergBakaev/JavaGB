import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner number1 = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        int randomNumber;

        int range = 9;
        randomNumber = (int) (Math.random() * range);
        playLevel(randomNumber, range);
        int x1 = 0, x2 = 1;

        while (true) {
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            randomNumber = (int) (Math.random() * range);
            Scanner choise = new Scanner((System.in));
            int input_choise = Integer.parseInt(choise.nextLine());
            if (input_choise == x2) {
                playLevel(randomNumber, range);
            }else if (input_choise == x1) {
                break;
            }
        }
        guessFruit();


    }

    private static void playLevel(int randomNumber, int range){

            System.out.println("Угадайте число от 0 до 9. У вас есть 3 попытки");
            int input_number1 = number1.nextInt();
            for(int i = 0, j = 2; i < 2; i++,j--){
            if(input_number1 == randomNumber) {
                System.out.println("Вы угадали!!!");
                break;
            }else {
            System.out.println("Вы не угадали. Попыток = " + j);}
                input_number1 = number1.nextInt();
            }
    }

    private static void guessFruit() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //загадаем слово из массива
        int indWord = random.nextInt(words.length - 1);
        String word = words[indWord];
        int lenWord = word.length();
        System.out.println("Я загадал слово, попробуй отгадать его из списка" + Arrays.toString(words));

        //инициализируем сканер
        Scanner scanner = new Scanner(System.in);
        do {
            //спрашиваем ответ
            System.out.println("Введи свой ответ: (для выхода из игры, просто нажмите Enter)");
            String answer = scanner.nextLine();
            //если нам надоес играть то мы выйдем
            if (answer.equals("")) break;
            else if (word.equals(answer)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            //так как наш игрок не угадал то будем готовить для него подсказку
            char[] charsAnswer = answer.toCharArray();
            for (int i = 0; i < lenWord; i++) {
                if (i >= charsAnswer.length) break;
                if (word.charAt(i) != charsAnswer[i]) charsAnswer[i] = '#';
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
            for (int i = comment.length(); i < 15; i++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
    }


}