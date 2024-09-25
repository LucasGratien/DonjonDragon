import java.util.Random;

public class Game {
    private Random random;
    private int position; // Ajout de la position ici

    public Game() {
        random = new Random();
        position = 0; // Initialise la position
    }

    public int lancer() {
        return random.nextInt(6) + 1;
    }

    public void jouer() {
        try {
            int resultat = lancer(); // Lancer le dé
            System.out.println("Vous avez obtenu : " + resultat);
            position += resultat; // Met à jour la position

            // Si la position dépasse 64, corrige-la
            if (position > 64) {
                throw new Exception("La position dépasse la limite de 64 cases !");
            }

            // Affichage de la position
            if (position == 64) {
                System.out.println("Vous avez atteint la case " + position + " sur 64 !");
            } else {
                System.out.println("Vous êtes maintenant à la case " + position + " sur 64.");
            }
        } catch (Exception e) {
           // je gére l'exception
            position = 64;
            System.out.println(e.getMessage());
            System.out.println("Votre position est maintenant à la case " + position + ".");
        }
    }

    public int getPosition() {
        return position;
    }

    public void resetPosition() {
        position = 0; // Réinitialise la position pour une nouvelle partie
    }
}
