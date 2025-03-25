
package library.utils;

import java.util.UUID;
 
public class Utility {
    public static String generateId() {
        return UUID.randomUUID().toString(); // Generates a random unique ID
    }
}
