package br.com.codenoir;

import java.time.LocalDate;

public class LoanBook {
    private Book book;
    private Client client;
    private LocalDate loanAt;
    private LocalDate returnAt;

    public LoanBook(Book book, Client client, LocalDate loanAt, LocalDate returnAt) {
        this.book = book;
        this.client = client;
        this.loanAt = loanAt;
        this.returnAt = returnAt;
    }

    public LoanBook(Book book, LocalDate loanAt, LocalDate returnAt) {
        this.book = book;
        this.loanAt = loanAt;
        this.returnAt = returnAt;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getLoanAt() {
        return loanAt;
    }

    public void setLoanAt(LocalDate loanAt) {
        this.loanAt = loanAt;
    }

    public LocalDate getReturnAt() {
        return returnAt;
    }

    public void setReturnAt(LocalDate returnAt) {
        this.returnAt = returnAt;
    }
}
