/*Your application requires a custom immutable class to store configurations.
Implement an immutable Configuration class that stores databaseUrl, username, and password.
Ensure no setter methods exist, and values cannot be changed once assigned.
Example Usage:
Configuration config = new Configuration("jdbc:mysql://localhost", "admin", "password123");
System.out.println(config.getDatabaseUrl());
 */

public final class Configuration {
    private final String databaseUrl;
    private final String username;
    private final String password;

    public Configuration(String databaseUrl, String username, String password) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
