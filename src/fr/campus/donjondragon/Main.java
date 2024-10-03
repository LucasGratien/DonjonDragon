package fr.campus.donjondragon;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        Connexion connexion = new Connexion();
        connexion.getHeroes();
    }
}
