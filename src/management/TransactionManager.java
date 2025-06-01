package management;

import library.Book;
import library.Member;
import library.Transaction;

import java.util.Date;

public class TransactionManager {
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {
        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        this.transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        if (index >= 0 && index < this.transactions.size()) {
            return this.transactions.get(index);
        }
        return null;
    }
}