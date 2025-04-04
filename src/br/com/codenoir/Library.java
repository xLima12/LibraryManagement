package br.com.codenoir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<LoanBook> loanBooks = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if(instance == null) {
            instance = new Library();
        }
        return instance;
    }

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
        int idBook = id - 1;

        if(!this.books.get(idBook).isAvailable()){
            System.out.println("O livro informado não está disponível.");
        }

        if(this.findClientByName(name) == null) {
            System.out.println("Necessário realizar o cadastro no sistema para prosseguir com o empréstimo do livro escolhido.");
        }

        this.books.get(idBook).setAvailable(false);

        int idClient = this.findClientByName(name).getId();

        LoanBook loanBook = new LoanBook(this.books.get(idBook), this.clients.get(idClient), LocalDate.now(), LocalDate.now().plusMonths(3));
        this.addLoanBook(loanBook);
        System.out.println("Livro emprestado com sucesso!");
    }

    public void getListLoanBook() {
        if(this.loanBooks.isEmpty()) {
            System.out.println("Nenhum livro emprestado no momento.");
        }

        for(LoanBook loanBook : loanBooks) {
            System.out.println(String.format("Livro %s emprestado para %s em %td/%<tm/%<ty até %tD ", loanBook.getBook().getTitle(), loanBook.getClient().getName(), loanBook.getLoanAt(), loanBook.getReturnAt()));
        }
    }

    public List<Author> getListAuthor() {
        return authors;
    }

    public Client findClientByName(String name) {
        for(Client client : clients) {
            if(client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    public Author findAuthorByName(String name) {
        for(Author author : authors) {
            if(author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }

    public void getAvailableBooks() {
        List<Book> booksAvailable = new ArrayList<>();

        if(this.books.isEmpty()){
            System.out.println("Nenhum livro disponível no momento.");
        } else {
            for(Book book: books) {
                if(book.isAvailable()) {
                    booksAvailable.add(book);
                    System.out.println(String.format("ID: %d | Titulo: %-30.30s | Autor: %s",
                            book.getId(), book.getTitle(), book.getAuthor()));
                }
            }
        }
    }

    public boolean getListBook() {
        return !this.books.isEmpty();
    }

    public void getListClients() {
        if(this.clients.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no momento.");
        } else {
            for(Client client : clients) {
                System.out.println(String.format("Id: %d | Nome: %-15.15s | Nascimento: %tD | E-mail: %s",
                        client.getId(), client.getName(), client.getBirth(), client.getEmail()));
            }
        }
    }

}
