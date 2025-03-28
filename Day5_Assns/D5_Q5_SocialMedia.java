import java.util.*;

class User {
    private String username;
    private HashSet<String> followers;

    public User(String username) {
        this.username = username;
        this.followers = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void addFollower(String follower) {
        if (followers.add(follower)) {
            System.out.println(follower + " started following " + username);
        } else {
            System.out.println(follower + " is already following " + username);
        }
    }

    public void displayFollowers() {
        if (followers.isEmpty()) {
            System.out.println(username + " has no followers.");
        } else {
            System.out.println("Followers of " + username + " (sorted alphabetically):");
            for (String follower : new TreeSet<>(followers)) {
                System.out.println("- " + follower);
            }
        }
    }

    public void suggestFriends(User otherUser) {
        HashSet<String> uniqueToOther = new HashSet<>(otherUser.followers);
        uniqueToOther.removeAll(followers);

        System.out.println("\nFriend suggestions for " + username + " based on " + otherUser.getUsername() + ":");
        if (uniqueToOther.isEmpty()) {
            System.out.println("No new friend suggestions.");
        } else {
            for (String suggestion : uniqueToOther) {
                System.out.println("- " + suggestion);
            }
        }
    }

    public void traverseFollowers() {
        System.out.println("\nTraversing followers of " + username + ":");
        Iterator<String> iterator = followers.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }
}

public class D5_Q5_SocialMedia {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        user1.addFollower("Charlie");
        user1.addFollower("Dave");
        user1.addFollower("Eve");

        user2.addFollower("Charlie");
        user2.addFollower("Frank");
        user2.addFollower("Grace");

        user1.displayFollowers();
        user2.displayFollowers();

        user1.suggestFriends(user2);
        user2.suggestFriends(user1);

        user1.traverseFollowers();
        user2.traverseFollowers();
    }
}
