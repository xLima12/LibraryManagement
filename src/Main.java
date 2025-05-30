import br.com.codenoir.Author;
import br.com.codenoir.Book;
import br.com.codenoir.Client;
import br.com.codenoir.Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option = -1;
        String userName;
        String userBirth;
        String userEmail;
        String authorName;
        String authorBirth;
        String bookTitle;
        int bookId;

        header();
        while (option != 0) {
            menu();

            option = scan.nextInt();
            switch (option) {
                case 1:
                    scan.nextLine();
                    System.out.println("Informe o seu nome: ");
                    userName = scan.nextLine();
                    System.out.println("Informe o seu nascimento (dd/MM/aaaa): ");
                    userBirth = scan.nextLine();
                    System.out.println("Informe o seu e-mail: ");
                    userEmail = scan.nextLine();
                    registerUser(userName, userBirth, userEmail);
                    break;
                case 2:
                    scan.nextLine();
                    System.out.println("Informe o nome do autor: ");
                    authorName = scan.nextLine();
                    System.out.println("Informe o nascimento do autor: ");
                    authorBirth = scan.nextLine();
                    registerAuthor(authorName, authorBirth);
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Informe o título do livro: ");
                    bookTitle = scan.nextLine();
                    System.out.println("Informe o nome do autor: ");
                    authorName = scan.nextLine();
                    registerBook(bookTitle, authorName);
                    break;
                case 4:
                    getAvailableBook();
                    break;
                case 5:
                    getLoanBook();
                    break;
                case 6:
                    if(getListBooks()) {
                        System.out.println("Informe o id do livro que deseja pegar emprestado: ");
                        bookId = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Informe o seu nome cadastrado: ");
                        userName = scan.nextLine();
                        registerLoanBook(bookId, userName);
                    }
                    System.out.println("Nenhum livro cadastro para emprestimo!");
                    break;
                case 7:
                    getListClients();
                    break;
                case 8:
                    getListAuthors();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o sistema.");
                    break;
            }
        }
    }

    public static void header() {
        System.out.println("----------------------");
        System.out.println("| Library Management |");
        System.out.println("----------------------");
        System.out.println("Bem vindo ao sistema");
    }

    public static void menu() {
        System.out.println("----------------------");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Cadastrar Autor");
        System.out.println("3 - Cadastrar livro");
        System.out.println("4 - Consultar livros disponíveis");
        System.out.println("5 - Consultar livros emprestados");
        System.out.println("6 - Solicitar empréstimo de livro(s)");
        System.out.println("7 - Consultar usuarios");
        System.out.println("8 - Consultar autores");
        System.out.println("0 - Sair");
        System.out.println("----------------------");
    }

    public static void registerUser(String name, String birth, String email) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birth, formatter);
        Client client = new Client(name, date, email);
        useLibrary().addClient(client);
    }

    public static void registerAuthor(String name, String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(birth, formatter);
        Author author = new Author(name, date);
        useLibrary().addAuthor(author);
    }

    public static void registerBook(String title, String name) {
        Author author = useLibrary().findAuthorByName(name);

        if(author == null) {
            System.out.println("Autor não encontrado!");
            return;
        }

        Book book = new Book(title, author);
        useLibrary().addBook(book);
        System.out.println("Livro registrado com sucesso!");
    }

    public static void registerLoanBook(int id, String name) {
        useLibrary().getLoanBook(id, name);
    }

    public static void getAvailableBook() {
        useLibrary().getAvailableBooks();
    }

    public static void getLoanBook() {
        useLibrary().getListLoanBook();
    }

    public static void getListAuthors() {
        System.out.println(useLibrary().getListAuthor());
    }

    public static boolean getListBooks() {
        return useLibrary().getListBook();
    }

    public static void getListClients() {
        useLibrary().getListClients();
    }

    public static Library useLibrary() {
        return Library.getInstance();
    }
}