package fr.campus.donjondragon;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import fr.campus.donjondragon.personnage.Personnage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connexion {

    private static final String URL = "jdbc:mysql://localhost:3306/D&D_java_db";
    private static final String USER = "lucas";
    private static final String PASSWORD = "lucas";

    // Méthode pour établir la connexion à la base de données
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion établie avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode pour récupérer tous les héros
    public List<Personnage> getHeroes() {
        List<Personnage> heroes = new ArrayList<>();
        String sql = "SELECT * FROM Hero";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int idHero = rs.getInt("idHero");
                String nom = rs.getString("Nom");
                String type = rs.getString("Type");
                int niveauVie = rs.getInt("NiveauVie");
                int niveauForce = rs.getInt("NiveauForce");
                String armeSort = rs.getString("Arme/Sort");
                String bouclier = rs.getString("Bouclier");


                Personnage hero = new Personnage(nom, type, niveauVie, niveauForce, armeSort, bouclier);
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    // Méthode pour créer un héros
    public void createHero(Personnage personnage) {
        String mysql = "INSERT INTO Hero (Type, Nom, NiveauVie, NiveauForce, `Arme/sort`, Bouclier) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(mysql)) {

            pstmt.setString(1, personnage.getTypePersonnage());
            pstmt.setString(2, personnage.getNom());
            pstmt.setInt(3, personnage.getpDv());
            pstmt.setInt(4, personnage.getAttaque());
            pstmt.setString(5, personnage.getEquipementOffensif());
            pstmt.setString(6, personnage.getEquipementDefensif());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Personnage ajouté avec succès !");
            } else {
                System.out.println("Aucun personnage n'a été ajouté.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void editHero(Personnage personnage, String ancienNom) {
        if (personnage == null) {
            System.out.println("Erreur : le personnage est null.");
            return;
        }

        String sql = "UPDATE Hero SET Type = ?, Nom = ?, NiveauVie = ?, NiveauForce = ?, `Arme/sort` = ?, Bouclier = ? WHERE Nom = ?";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, personnage.getTypePersonnage());
            pstmt.setString(2, personnage.getNom());
            pstmt.setInt(3, personnage.getpDv());
            pstmt.setInt(4, personnage.getAttaque());
            pstmt.setString(5, personnage.getEquipementOffensif());
            pstmt.setString(6, personnage.getEquipementDefensif());
            pstmt.setString(7, ancienNom);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Personnage modifié avec succès !");
            } else {
                System.out.println("Aucun personnage n'a été modifié.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
