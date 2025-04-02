import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    // Shared data structure for real-time balance updates
    private static final Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // Initialize accounts
        for (int i = 1; i <= 3; i++) {
            accounts.put(i, new Account(i, 1000));
        }

        // Create multiple threads to simulate money transfers
        Thread t1 = new Thread(() -> transferMoney(1, 2, 200));
        Thread t2 = new Thread(() -> transferMoney(2, 3, 300));
        Thread t3 = new Thread(() -> transferMoney(3, 1, 150));

        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();

        // Display final balances
        System.out.println("\nFinal Balances:");
        accounts.values().forEach(account -> 
            System.out.println("Account " + account.getId() + ": " + account.getBalance()));
    }

    // Transfer money between accounts
    public static void transferMoney(int fromId, int toId, int amount) {
        // Lock ordering: acquire locks in consistent order to prevent deadlock
        Account fromAccount = accounts.get(fromId);
        Account toAccount = accounts.get(toId);
        Account firstLock = fromId < toId ? fromAccount : toAccount;
        Account secondLock = fromId < toId ? toAccount : fromAccount;

        // Use ReentrantLock for fine-grained locking
        firstLock.getLock().lock();
        try {
            secondLock.getLock().lock();
            try {
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                    System.out.println("Transferred " + amount + " from Account " + fromId + " to Account " + toId);
                } else {
                    System.out.println-("Insufficient funds in Account " + fromId + " for transfer of " + amount);
                }
            } finally {
                secondLock.getLock().unlock();
            }
        } finally {
            firstLock.getLock().unlock();
        }
    }
 
    static class Account {
        private final int id;
        private int balance;
        private final Lock lock = new ReentrantLock(); // ReentrantLock for thread-safe access

        public Account(int id, int initialBalance) {
            this.id = id;
            this.balance = initialBalance;
        }

        public int getId() {
            return id;
        }

        public int getBalance() {
            return balance;
        }

        public Lock getLock() {
            return lock;
        }

        public boolean withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public void deposit(int amount) {
            balance += amount;
        }
    }
}
