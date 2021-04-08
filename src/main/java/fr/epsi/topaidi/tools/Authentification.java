package fr.epsi.topaidi.tools;

import org.mindrot.jbcrypt.BCrypt;

public class Authentification {
    private static int workload = 10;

    public static String hash(String motdepasse) {
        String salt = BCrypt.gensalt(workload);
        String hash = BCrypt.hashpw(motdepasse, salt);
        return hash;
    }

    public static boolean checkMotdepasse(String formInput, String storedHash) {
        return BCrypt.checkpw(formInput, storedHash);
    }
}
