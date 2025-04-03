import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Stock {
    private String symbol;
    private double price;
    private int volume;
    private LocalDateTime lastTradeTime;

    public Stock(String symbol, double price, int volume, LocalDateTime lastTradeTime) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.lastTradeTime = lastTradeTime;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public int getVolume() { return volume; }
    public LocalDateTime getLastTradeTime() { return lastTradeTime; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Stock: " + symbol + " | Price: ₹" + price + " | Volume: " + volume +
               " | Last Trade: " + lastTradeTime.format(formatter);
    }
}

class StockMarketAnalyzer {
    private List<Stock> stocks;

    public StockMarketAnalyzer(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Optional<Stock> getHighestPricedStock() {
        return stocks.stream()
                .max(Comparator.comparingDouble(Stock::getPrice));
    }

    public double getAverageStockPrice() {
        return stocks.stream()
                .mapToDouble(Stock::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<Stock> getRecentTrades() {
        LocalDateTime now = LocalDateTime.now();
        return stocks.stream()
                .filter(stock -> stock.getLastTradeTime().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(
            new Stock("RELIANCE", 2780.50, 500000, LocalDateTime.now().minusHours(3)),
            new Stock("TCS", 3565.25, 300000, LocalDateTime.now().minusDays(2)),
            new Stock("HDFC", 1520.75, 400000, LocalDateTime.now().minusHours(10)),
            new Stock("TECHM", 1440.45, 350000, LocalDateTime.now().minusHours(2)),
            new Stock("ICICIBANK", 950.99, 450000, LocalDateTime.now().minusMinutes(45))
        );

        StockMarketAnalyzer analyzer = new StockMarketAnalyzer(stocks);

        Optional<Stock> highestStock = analyzer.getHighestPricedStock();
        System.out.println("\nHighest-Priced Stock:");
        System.out.println(highestStock.map(Stock::toString).orElse("No stocks available!"));

        System.out.println("\nAverage Stock Price: ₹" + analyzer.getAverageStockPrice());

        System.out.println("\nStocks Traded in Last 24 Hours:");
        List<Stock> recentTrades = analyzer.getRecentTrades();
        if (recentTrades.isEmpty()) {
            System.out.println("No stocks traded in the last 24 hours.");
        } else {
            recentTrades.forEach(System.out::println);
        }
    }
}
