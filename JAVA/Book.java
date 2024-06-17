public class Book extends Item{
    String formFactor;

    public Book(String id, String title, String author, String ISBN, String publisher, int amt, String formFactor) {
        super(id, title, author, ISBN, publisher, amt);
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "Department: Books | "+title+" by "+author+" | ISBN: "+ISBN+" | Publisher: "+publisher+" | ID: "+id+" | Amount: "+amt+" | Form Factor: "+formFactor;
    }
}
