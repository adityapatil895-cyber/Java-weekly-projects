import java.util.Scanner;

public class OnlineQuiz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. Java is a ____?",
            "2. Which keyword is used to inherit a class?",
            "3. JVM stands for?"
        };

        String[][] options = {
            {"A. Language", "B. OS", "C. Hardware", "D. Browser"},
            {"A. super", "B. this", "C. extends", "D. implements"},
            {"A. Java Virtual Machine", "B. Java Visual Model", "C. Just VM", "D. None"}
        };

        char[] answers = {'A', 'C', 'A'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String opt : options[i]) {
                System.out.println(opt);
            }
            System.out.print("Enter Answer: ");
            char ans = sc.next().toUpperCase().charAt(0);

            if (ans == answers[i]) {
                score++;
            }
        }

        System.out.println("\nYour Score: " + score + "/" + questions.length);
    }
}