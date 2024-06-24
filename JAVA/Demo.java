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

        do {
            System.out.println("\nWelcome to the Library Mangement System - Remember to Save! :)");
            System.out.println("1. Add - Library Item");
            System.out.println("2. Edit - Library Item");
            System.out.println("3. Delete - Library Item");
            System.out.println("4. Borrow - Library Item");
            System.out.println("5. Return - Library Item");
            System.out.println("6. Display All Available Books");
            System.out.println("7. Authors");
            System.out.println("8. Patrons");
            System.out.println("9. Save and Exit");
            System.out.println("Enter your Choice (1, 9): ");
            choice = scan.nextInt();
            scan.nextLine();
            
            switch(choice){
                case 1:
                    String id;
                    String title;
                    String author;
                    String ISBN;
                    String publisher;
                    int amt;
                    String formFactor;

                    System.out.println("Enter the Book Title: ");
                    title = scan.nextLine();

                    System.out.println("Enter the ID: ");
                    id = scan.nextLine();

                    System.out.println("Enter the Author Name: ");
                    author = scan.nextLine();

                    System.out.println("Enter the ISBN: ");
                    ISBN = scan.nextLine();

                    System.out.println("Enter the Publisher: ");
                    publisher = scan.nextLine();

                    System.out.println("Enter the Number of Books Available: ");
                    amt = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Is the item a Book or Periodical? ");
                    System.out.println("1. Book");
                    System.out.println("2. Periodical");
                    int choice2 = scan.nextInt();
                    scan.nextLine();

                    switch(choice2){
                        case 1:
                            System.out.println("Enter the Form Factor (printed, electronic, audio): ");
                            formFactor = scan.nextLine();
                            
                            Book book = new Book(id, title, author, ISBN, publisher, amt, formFactor);
                            lib.addBook(book);

                            System.out.println("Add Successful!");
                            break;

                        case 2:
                            System.out.println("Is the periodical printed?: ");
                            System.out.println("Please enter true or false.");

                            Boolean isPrinted = scan.nextBoolean();
                            
                            Periodical periodical = new Periodical(id, title, author, ISBN, publisher, amt, isPrinted);
                            lib.addBook(periodical);

                            System.out.println("Add Successful!");
                            break;
                    }
                    break;
                    
                    

                case 2:
                    System.out.println("\nWhat attribute would you like to edit?");
                    System.out.println("1. ID");
                    System.out.println("2. Title");
                    System.out.println("3. Author");
                    System.out.println("4. ISBN");
                    System.out.println("5. Publisher");
                    System.out.println("6. Quantity On Hand");
                    choice = scan.nextInt();
                    scan.nextLine();
                    switch(choice){
                        case 1:
                            System.out.println("\nEnter the name and new id of the book you would like to edit:");
                            title = scan.nextLine();
                            id = scan.nextLine();
                            lib.editID(title, id);
                            break;
                        case 2:
                            System.out.println("\nEnter the title and the new title of the book you would like to edit:");
                            title = scan.nextLine();
                            String newTitle = scan.nextLine();
                            lib.editTitle(title, newTitle);
                            break;
                        case 3:
                            System.out.println("\nEnter the name and new author of the book you would like to edit:");
                            title = scan.nextLine();
                            String newAuthor = scan.nextLine();
                            lib.editAuthor(title, newAuthor);
                            break;
                        case 4:
                            System.out.println("\nEnter the name and new ISBN of the book you would like to edit:");
                            title = scan.nextLine();
                            String newISBN = scan.nextLine();
                            lib.editISBN(title, newISBN);
                            break;
                        case 5:
                            System.out.println("\nEnter the name and new publisher of the book you would like to edit:");
                            title = scan.nextLine();
                            String newPublisher = scan.nextLine();
                            lib.editPublisher(title, newPublisher);
                            break;
                        case 6:
                            System.out.println("\nEnter the name and new quantity of the book you would like to edit:");
                            title = scan.nextLine();
                            int newQuant = scan.nextInt();
                            scan.nextLine();
                            lib.editAmt(title, newQuant);
                            break;
                    }

                    break;
                case 3:
                    //del item
                    System.out.println("\nType the title, ID, or ISBN of the book you want to delete");
                    String query = scan.nextLine();
                    lib.removeBook(query);
                    break;
                case 4:
                    //borrow item
                    System.out.println("\nType the title, ID, or ISBN of the book you want to borrow");
                    query = scan.nextLine();
                    System.out.println("\nWhat is your name? ");
                    String patronName = scan.nextLine();
                    
                    title = lib.getTitle(query);
                    String isvalid = patrons.addToList(patronName, title);
                    if(isvalid.equals("valid")){
                        lib.borrowLib(query);
                    } else {
                        System.out.println("Please sign up before borrowing a book.");
                    }
                    break;
                case 5:
                    //return item
                    System.out.println("\nType the title, ID, or ISBN of the book you want to return");
                    query = scan.nextLine();
                    System.out.println("\nWhat is your name? ");
                    patronName = scan.nextLine();
                    
                    title = lib.getTitle(query);
                    isvalid = patrons.removeFromList(patronName, title);
                    if(isvalid.equals("valid")){
                        lib.returnLib(query);
                    } else {
                        System.out.println("Please sign up before returning a book.");
                    }
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
                    scan.nextLine();
                    switch(choice){
                        case 1:
                            System.out.println("Enter the name of the author: ");
                            String name = scan.nextLine();

                            System.out.println("Enter the author date of birth: ");
                            String dob = scan.nextLine();

                            System.out.println("Enter the authors list of written books: ");
                            String list = scan.nextLine();

                            Author authorObj = new Author(name, dob, list);
                            auth.addAuth(authorObj);
                            break;
                        case 2:
                            System.out.println("\n Enter the name of the author, followed by the replacement name: ");
                            name = scan.nextLine();
                            String newName = scan.nextLine();
                            auth.editName(name, newName);
                            break;
                        case 3:
                            System.out.println("\n Enter the name of the author, followed by the replacement DOB: ");
                            name = scan.nextLine();
                            String newDOB = scan.nextLine();
                            auth.editName(name, newDOB);
                            break;
                        case 4:
                            System.out.println("\n Enter the name of the author, followed by the replacement titles: ");
                            name = scan.nextLine();
                            String newTitles = scan.nextLine();
                            auth.editName(name, newTitles);
                            break;
                        case 5:
                            System.out.println("\n Enter the name of the author to delete. ");
                            name = scan.nextLine();
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
                    System.out.println("9. Get Patron by Phone");
                    System.out.println("10. Back");
                    choice = scan.nextInt();
                    scan.nextLine();
                    switch(choice){
                        case 0:
                            System.out.println("Enter a phone number to get patron information.");
                            String phone = scan.nextLine();
                            System.out.println(patrons.getPatron(phone));
                            break;
                        case 1:
                            System.out.println("Enter the name of the patron: ");
                            String name = scan.nextLine();

                            System.out.println("Enter the patron address: ");
                            String address = scan.nextLine();

                            System.out.println("Enter the patron phone number: ");
                            phone = scan.nextLine();

                            System.out.println("Is the patron an employee? true or false ");
                            boolean isEmployee = scan.nextBoolean();

                            Patron patron = new Patron(name, address, phone, isEmployee);
                            patrons.addPatron(patron);
                            break;
                        case 2:
                            System.out.println("Enter the name, followed by the new name");
                            name = scan.nextLine();
                            String newName = scan.nextLine();
                            patrons.editName(name, newName);
                            break;
                        case 3:
                            System.out.println("Enter the name, followed by the new address");
                            name = scan.nextLine();
                            String newAddr = scan.nextLine();
                            patrons.editAddress(name, newAddr);
                            break;
                        case 4:
                            System.out.println("Enter the name, followed by the new phone number");
                            name = scan.nextLine();
                            String newPhone = scan.nextLine();
                            patrons.editName(name, newPhone);
                            break;
                        case 5:
                            System.out.println("Enter the name, followed by the new position");
                            name = scan.nextLine();
                            boolean newPostion = scan.nextBoolean();
                            patrons.editIsEmployee(name, newPostion);
                            break;
                        case 6:
                            System.out.println("Enter the name, followed by the new list");
                            name = scan.nextLine();
                            String newList = scan.nextLine();
                            patrons.editName(name, newList);
                            break;
                        case 7:
                            System.out.println("Enter the name of the patron you want to delete");
                            String patronDel = scan.nextLine();
                            patrons.removePatron(patronDel);
                            break;
                        case 8:
                            System.out.println(patrons.toString());
                            break;
                        case 10:
                            break;
                    }
                    break;
                case 9:
                    System.out.println("Saving and Exiting...");
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
        } while (choice !=9);
    
    }
}
