package library;

import datastructures.lists.CustomLinkedList;

public class Member {
    private String memberId;
    private String name;
    private CustomLinkedList<Transaction> transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactions = new CustomLinkedList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            this.transactions.addLast(transaction);
        }
    }

    public Transaction getLastTransaction() {
        if (this.transactions.isEmpty()) {
            return null;
        }
        return this.transactions.getLast();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}