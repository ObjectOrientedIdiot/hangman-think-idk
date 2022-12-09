public class Main {
    public static void main(String[] args) {
        Hangman game = new Hangman("hello world", 6);
        game.guess('l');
        game.guess('k');
        System.out.println(game);
    }
}