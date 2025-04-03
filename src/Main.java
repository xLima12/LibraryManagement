import br.com.codenoir.Author;
import br.com.codenoir.Book;
import br.com.codenoir.Client;
import br.com.codenoir.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exec = true;
        String option;
        String bookId;
        String clientName;
        Scanner scan = new Scanner(System.in);

        Library library = new Library();

        Client client1 = new Client(1, "Felipe", LocalDate.of(1996, 2, 20), "felipe@gmail.com");
        Client client2 = new Client(2, "Julia", LocalDate.of(2020, 6, 24), "felipe@gmail.com");
        library.addClient(client1);
        library.addClient(client2);

        Author author1 = new Author(1, "José Saramago", LocalDate.of(1922, 11, 16));
        Author author2 = new Author(2, "Clarice Lispector", LocalDate.of(1920, 12, 10));
        Author author3 = new Author(3, "Edgar Allan Poe", LocalDate.of(1809, 1, 19));
        Author author4 = new Author(4, "Fiódor Dostoiévski", LocalDate.of(1821, 11, 11));
        Author author5 = new Author(5, "William Shakespeare", LocalDate.of(1564, 4, 23));
        Author author6 = new Author(6, "Marcel Proust", LocalDate.of(1871, 7, 10));
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);
        library.addAuthor(author6);

        Book book1 = new Book(1, "Memorial do convento", library.getAuthor(1));
        Book book2 = new Book(2, "Laços de família", library.getAuthor(2));
        Book book3 = new Book(3, "O poço e o pêndulo", library.getAuthor(3));
        Book book4 = new Book(4, "Crime e Castigo", library.getAuthor(4));
        Book book5 = new Book(5, "Hamlet", library.getAuthor(5));
        Book book6 = new Book(6, "Em busca do tempo perdido", library.getAuthor(6));
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        System.out.println("Deseja verificar os livros disponíveis?");
        while (exec) {
            option = scan.nextLine().toLowerCase();
            switch (option) {
                case "sim":
                    library.getAvailableBooks();
                    System.out.println("Informe o ID do livro que deseja");
                    bookId = scan.nextLine();
                    System.out.println("Informe o seu nome?");
                    clientName = scan.nextLine();
                    library.getLoanBook(Integer.parseInt(bookId), clientName);
                    break;
                case "nao":
                    System.out.println("Encerrando o programa. Obrigado por usar.");
                    exec = false;
                    break;
                case "emprestados":
                    library.getListLoanBook();
                default:
                    System.out.println("Opcao inválida! Por favor digite Sim ou Nao");
            }
        }
    }
}