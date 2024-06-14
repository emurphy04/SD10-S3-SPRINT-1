
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        Library lib = new Library();
        Authors auth = new Authors();
        Scanner scan = new Scanner(System.in);

        int choice;
        do {
             

            System.out.println("\nWelcome to the Library mangement system - Remember to save! :)");
            System.out.println("0. Load Library (ONLY USE AFTER FIRST SAVE AND EXIT)");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Display all available books");
            System.out.println("7. Authors");
            System.out.println("8. Patrons");
            System.out.println("9. Exit");
            System.out.println("Enter your choice (0.6): ");
            choice = scan.nextInt();
            
            switch(choice){
                case 0:
                    FileInputStream fis = null;
                    ObjectInputStream in = null;
        
                    File file = new File("books.ser");
                    if (file.exists()) {
                        try{
                            fis = new FileInputStream(file);
                            in = new ObjectInputStream(fis);
                            lib = (Library) in.readObject();
                            fis.close();
                            in.close();
                        } catch (IOException e){
                            e.printStackTrace();
                        } catch (ClassNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Library Loaded!");
                    break;
                case 1:
                    String id;
                    String title;
                    String author;
                    String ISBN;
                    String publisher;
                    int amt;
                    String formFactor;

                    System.out.println("Enter the Title: ");
                    title = scan.next();

                    System.out.println("Enter the ID: ");
                    id = scan.next();

                    System.out.println("Enter the Author Name: ");
                    author = scan.next();

                    System.out.println("Enter the ISBN: ");
                    ISBN = scan.next();

                    System.out.println("Enter the Publisher: ");
                    publisher = scan.next();

                    System.out.println("Enter the amount: ");
                    amt = scan.nextInt();

                    System.out.println("Enter the form factor (printed, electronic, audio): ");
                    formFactor = scan.next();
                    
                    Book book = new Book(id, title, author, ISBN, publisher, amt, formFactor);
                    lib.addBook(book);

                    System.out.println("Add Successful!");
                    break;

                case 2:
                    System.out.println("\nWhat attribute would you like to edit?");
                    System.out.println("1. ID");
                    System.out.println("2. Title");
                    System.out.println("3. Author");
                    System.out.println("4. ISBN");
                    System.out.println("5. Publisher");
                    System.out.println("6. Quantity on hand");
                    System.out.println("7. Form Factor");
                    choice = scan.nextInt();
                    switch(choice){
                        case 1:
                            System.out.println("\nEnter the name and new id of the book you would like to edit:");
                            title = scan.next();
                            id = scan.next();
                            lib.editID(title, id);
                            break;
                        case 2:
                            System.out.println("\nEnter the title and the new title of the book you would like to edit:");
                            title = scan.next();
                            String newTitle = scan.next();
                            lib.editTitle(title, newTitle);
                            break;
                        case 3:
                            System.out.println("\nEnter the name and new author of the book you would like to edit:");
                            title = scan.next();
                            String newAuthor = scan.next();
                            lib.editAuthor(title, newAuthor);
                            break;
                        case 4:
                            System.out.println("\nEnter the name and new ISBN of the book you would like to edit:");
                            title = scan.next();
                            String newISBN = scan.next();
                            lib.editISBN(title, newISBN);
                            break;
                        case 5:
                            System.out.println("\nEnter the name and new publisher of the book you would like to edit:");
                            title = scan.next();
                            String newPublisher = scan.next();
                            lib.editPublisher(title, newPublisher);
                            break;
                        case 6:
                            System.out.println("\nEnter the name and new quantity of the book you would like to edit:");
                            title = scan.next();
                            int newQuant = scan.nextInt();
                            lib.editAmt(title, newQuant);
                            break;
                        case 7:
                            System.out.println("\nEnter the name and new form factor of the book you would like to edit:");
                            title = scan.next();
                            String newForm = scan.next();
                            lib.editFormFactor(title, newForm);
                            break;
                    }

                    break;
                case 3:
                    //del item
                    System.out.println("\n<title>");
                    title = scan.next();
                    lib.removeBook(title);
                    break;
                case 4:
                    //borrow item
                    System.out.println("\nType the title of the book you want to borrow");
                    title = scan.next();
                    lib.borrowLib(title);
                    break;
                case 5:
                    //return item
                    System.out.println("\nType the title of the book you want to return");
                    title = scan.next();
                    lib.returnLib(title);
                    break;
                case 6:
                    System.out.println(lib.toString());
                    break;
                case 7:
                    //authors
                    System.out.println("\n1. Add authors");
                    System.out.println("2. Edit Author Name");
                    System.out.println("3. Edit Author Date of Birth");
                    System.out.println("4. Edit Author titles written");
                    System.out.println("5. Remove Author");
                    System.out.println("6. Back");
                    choice = scan.nextInt();
                    switch(choice){
                        case 1:
                            Author authorObj = new Author("Ethan", "May 6th, 2004", "All of the books, no cookbooks");
                            auth.addAuth(authorObj);
                            break;
                        case 2:
                            System.out.println("\n Enter the name of the author, followed by the replacement name: ");
                            String name = scan.next();
                            String newName = scan.next();
                            auth.editName(name, newName);
                            break;
                        case 3:
                            System.out.println("\n Enter the name of the author, followed by the replacement DOB: ");
                            name = scan.next();
                            String newDOB = scan.next();
                            auth.editName(name, newDOB);
                            break;
                        case 4:
                            System.out.println("\n Enter the name of the author, followed by the replacement titles: ");
                            name = scan.next();
                            String newTitles = scan.next();
                            auth.editName(name, newTitles);
                            break;
                        case 5:
                            System.out.println("\n Enter the name of the author to delete. ");
                            name = scan.next();
                            auth.removeAuth(name);
                            break;
                        case 6:
                            break;
                    }

                    break;
                case 8:
                    //patrons
                    System.out.println("\n1. Add Patrons");
                    System.out.println("2. Edit Patron Name");
                    System.out.println("3. Edit Patron Address");
                    System.out.println("4. Edit Patron Phone Number");
                    System.out.println("5. Edit Patron Position");
                    System.out.println("6. Edit Patron borrows");
                    System.out.println("7. Remove Author");
                    System.out.println("8. Back");
                    choice = scan.nextInt();
                    switch(choice){
                        
                    }
                    break;
                case 9:
                    //exit
                    FileOutputStream fos = null;
                    ObjectOutputStream out = null;
                    try {
                        fos = new FileOutputStream("books.ser");
                        out = new ObjectOutputStream(fos);
                        out.writeObject(lib);
                        fos.close();
                        out.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Invalid choice. please enter a number between 0 and 6.");
            }
        } while (choice !=6);
    
    }
}
