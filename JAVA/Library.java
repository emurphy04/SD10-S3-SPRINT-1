import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library extends Object implements Serializable{
    private List<Book> books;

    public Library(){
        books = new ArrayList<Book>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void editTitle(String title, String newTitle){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setTitle(newTitle);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void editID(String title, String newID){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setId(newID);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void editAuthor(String title, String newAuthor){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setAuthor(newAuthor);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void editPublisher(String title, String newPub){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setPublisher(newPub);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void editAmt(String title, int newAmt){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setAmt(newAmt);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void editISBN(String title, String newISBN){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setISBN(newISBN);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void editFormFactor(String title, String newFormFactor){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(title)){
                books.get(i).setFormFactor(newFormFactor);
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void removeBook(String query){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(query)){
                books.remove(i);
                System.out.println("Book deleted");
            } else if(books.get(i).id.equals(query)){
                books.remove(i);
                System.out.println("Book deleted");
            } else if(books.get(i).ISBN.equals(query)){
                books.remove(i);
                System.out.println("Book deleted");
            } else {
                System.out.println("Book not found.");
            }
        }
    }

    public void returnLib(String query){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(query)){
                books.get(i).returnBook(1);
                System.out.println(books.get(i).amt);
                System.out.println("Book returned!");
            } else if(books.get(i).id.equals(query)){
                books.get(i).returnBook(1);
                System.out.println(books.get(i).amt);
                System.out.println("Book returned!");
            } else if(books.get(i).ISBN.equals(query)){
                books.get(i).returnBook(1);
                System.out.println(books.get(i).amt);
                System.out.println("Book returned!");
            } else {
                System.out.println("Book not found.");
            }
        }
    }

    public void borrowLib(String query){
        for(int i = 0; i<books.size(); i++){
            if(books.get(i).title.equals(query)){
                books.get(i).borrow(1);
                System.out.println(books.get(i).amt);
                System.out.println("Book borrowed!");
            } else if(books.get(i).id.equals(query)){
                books.get(i).borrow(1);
                System.out.println(books.get(i).amt);
                System.out.println("Book borrowed!");
            } else if(books.get(i).ISBN.equals(query)){
                books.get(i).borrow(1);
                System.out.println(books.get(i).amt);
                System.out.println("Book borrowed!");
            } else {
                System.out.println("Book not found.");
            }
        }
    }

    @Override
    public String toString() {
        String bookList = "";
        for(int i = 0; i<books.size();i++){
            if(books.get(i).amt > 0){
                bookList = bookList + "\n"+books.get(i).toString();
            }
        }
        return bookList;
    }
}
