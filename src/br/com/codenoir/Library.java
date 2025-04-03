package br.com.codenoir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<LoanBook> loanBooks = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addLoanBook(LoanBook loanBook) {
        this.loanBooks.add(loanBook);
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void getLoanBook(int id, String name) {
        if(!this.books.get(id -1).isAvailable()){
            System.out.println("O livro informado não está disponível.");
        }

        if(this.clients.contains(name)) {
            System.out.println("Necessário realizar o cadastro no sistema para prosseguir com o emprestimo do livro escolhido.");
        }

        this.books.get(id -1).setAvailable(false);

        int client = this.clients.indexOf(name);

        LoanBook loanBook = new LoanBook(this.books.get(id -1), this.clients.get(client + 1), LocalDate.now(), LocalDate.now().plusDays(3));
        this.addLoanBook(loanBook);
        System.out.println("Livro emprestado com sucesso.");
    }

    public void getListLoanBook() {
        for(LoanBook loanBook : loanBooks) {
            System.out.println(String.format("Livro %s emprestado para %s em %td/%<tm/%<ty até %tD ", loanBook.getBook().getTitle(), loanBook.getClient().getName(), loanBook.getLoanAt(), loanBook.getReturnAt()));
        }
    }

    public Author getAuthor(int id) {
        return this.authors.get(id -1);
    }

    public void getAvailableBooks() {
        List<Book> booksAvailable = new ArrayList<>();
        for(Book book: books) {
            if(book.isAvailable()) {
                booksAvailable.add(book);
                displayInfo(book.getId(), book.getTitle(), book.getAuthor().getName());
            }
        }
    }

    public void displayInfo(int id, String title, String author) {
        String result = String.format("ID: %d | Titulo: %-30.30s | Autor: %s", id, title, author);
        System.out.println(result);
    }
}
