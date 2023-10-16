package info.java.stream.datasetUp;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationForTransaction {

    public static void main(String[] args) {
        List<Transaction> transactionList = getTr2011();
        System.out.println("transactionList -> " + transactionList);
        System.out.println("--------------------------------------");
        Set<String> cities = getCities();
        System.out.println("cities -> " + cities);
        System.out.println("--------------------------------------");
        System.out.println("traders from Cambridge -> " + getTraders());
        System.out.println("--------------------------------------");
        System.out.println("traders name sort Alphabetically -> " + getNames());
        System.out.println("--------------------------------------");
        System.out.println("traders name sort Alphabetically using joining -> " + getNamesUsingJoining());
        System.out.println("--------------------------------------");
        System.out.println("traders from milan -> " + isAnyTraderInMilan());
        System.out.println("--------------------------------------");
        System.out.println("trasaction group by currency --> " + getTransactionsBasedOnCurrency());
    }

    //Get transaction in 2011 and sort by value.
    private static List<Transaction> getTr2011() {
        return SetUp.getTransactions()
                .stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .collect(Collectors.toList());
    }

    //Get all the cities of all the traders.
    private static Set<String> getCities() {
        return SetUp.getTransactions()
                .stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet());
    }

    //Finds all traders from Cambridge and sort them by name
    private static List<Trader> getTraders() {
        return SetUp.getTransactions()
                .stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    //Returns a string of all traders’ names sorted alphabetically
    private static String getNames() {
        return SetUp.getTransactions()
                .stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

    }

    //Returns a string of all traders’ names sorted alphabetically using joining
    private static String getNamesUsingJoining() {
        return SetUp.getTransactions()
                .stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }

    //Any trader from Milan
    private static boolean isAnyTraderInMilan() {
        return SetUp.getTransactions()
                .stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Milan"));
    }

    //Prints all transactions’ values from the traders living in Cambridge
    private static void printTransactionsFromCambridge() {
        SetUp.getTransactions()
                .stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static Optional<Integer> getHighestTransaction() {
        return SetUp.getTransactions()
                .stream().map(Transaction::getValue)
                .reduce(Integer::max);

    }

    private static Optional<Integer> getLowestTransaction() {
        return SetUp.getTransactions()
                .stream().map(Transaction::getValue)
                .reduce(Integer::min);

    }

    //Group by currencies
    private static Map<Currency, List<Transaction>> getTransactionsBasedOnCurrency() {
        return SetUp.getTransactions()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
    }


}
