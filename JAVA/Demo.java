
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
        Patrons patrons = new Patrons();
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
            System.out.println("10. Save and Exit");
            System.out.println("Enter your choice (0, 10): ");
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

                    //

                    FileInputStream fis1 = null;
                    ObjectInputStream in1 = null;
        
                    File file1 = new File("authors.ser");
                    if (file1.exists()) {
                        try{
                            fis1 = new FileInputStream(file1);
                            in1 = new ObjectInputStream(fis1);
                            auth = (Authors) in1.readObject();
                            fis1.close();
                            in1.close();
                        } catch (IOException e){
                            e.printStackTrace();
                        } catch (ClassNotFoundException e){
                            e.printStackTrace();
                        }
                    }

                    //

                    FileInputStream fis2 = null;
                    ObjectInputStream in2 = null;
        
                    File file2 = new File("patrons.ser");
                    if (file2.exists()) {
                        try{
                            fis2 = new FileInputStream(file2);
                            in2 = new ObjectInputStream(fis2);
                            patrons = (Patrons) in2.readObject();
                            fis2.close();
                            in2.close();
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
                    System.out.println("6. List Authors");
                    System.out.println("7. Back");
                    choice = scan.nextInt();
                    switch(choice){
                        case 1:
                            System.out.println("Enter the name of the author: ");
                            String name = scan.next();

                            System.out.println("Enter the author date of birth: ");
                            String dob = scan.next();

                            System.out.println("Enter the authors list of written books: ");
                            String list = scan.next();

                            Author authorObj = new Author(name, dob, list);
                            auth.addAuth(authorObj);
                            break;
                        case 2:
                            System.out.println("\n Enter the name of the author, followed by the replacement name: ");
                            name = scan.next();
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
                            System.out.println(auth.toString());
                            break;
                        case 7:
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
                    System.out.println("7. Remove Patron");
                    System.out.println("8. List Patrons");
                    System.out.println("9. Back");
                    choice = scan.nextInt();
                    switch(choice){
                        case 1:
                            System.out.println("Enter the name of the patron: ");
                            String name = scan.next();

                            System.out.println("Enter the patron address: ");
                            String address = scan.next();

                            System.out.println("Enter the patron phone number: ");
                            String phone = scan.next();

                            System.out.println("Enter the list of items this patron has borrowed: ");
                            String list = scan.next();

                            System.out.println("Is the patron an employee? true or false ");
                            boolean isEmployee = scan.nextBoolean();

                            Patron patron = new Patron(name, address, phone, list, isEmployee);
                            patrons.addPatron(patron);
                            break;
                        case 2:
                            System.out.println("Enter the name, followed by the new name");
                            name = scan.next();
                            String newName = scan.next();
                            patrons.editName(name, newName);
                            break;
                        case 3:
                            System.out.println("Enter the name, followed by the new address");
                            name = scan.next();
                            String newAddr = scan.next();
                            patrons.editAddress(name, newAddr);
                            break;
                        case 4:
                            System.out.println("Enter the name, followed by the new phone number");
                            name = scan.next();
                            String newPhone = scan.next();
                            patrons.editName(name, newPhone);
                            break;
                        case 5:
                            System.out.println("Enter the name, followed by the new position");
                            name = scan.next();
                            boolean newPostion = scan.nextBoolean();
                            patrons.editIsEmployee(name, newPostion);
                            break;
                        case 6:
                            System.out.println("Enter the name, followed by the new list");
                            name = scan.next();
                            String newList = scan.next();
                            patrons.editName(name, newList);
                            break;
                        case 7:
                            System.out.println("Enter the name of the patron you want to delete");
                            String patronDel = scan.next();
                            patrons.removePatron(patronDel);
                            break;
                        case 8:
                            System.out.println(patrons.toString());
                            break;
                        case 9:
                            break;
                    }
                    break;
                case 10:
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

                    //

                    FileOutputStream fos2 = null;
                    ObjectOutputStream out2 = null;
                    try {
                        fos2 = new FileOutputStream("patrons.ser");
                        out2 = new ObjectOutputStream(fos2);
                        out2.writeObject(patrons);
                        fos2.close();
                        out2.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //

                    FileOutputStream fos1 = null;
                    ObjectOutputStream out1 = null;
                    try {
                        fos1 = new FileOutputStream("authors.ser");
                        out1 = new ObjectOutputStream(fos1);
                        out1.writeObject(auth);
                        fos1.close();
                        out1.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    System.out.println("Invalid choice. please enter a number between 0 and 6.");
            }
        } while (choice !=10);
    
    }
}
