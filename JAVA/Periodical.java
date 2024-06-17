public class Periodical extends Item{
    boolean isPrinted;

    public Periodical(String id, String title, String author, String ISBN, String publisher, int amt, boolean isPrinted) {
        super(id, title, author, ISBN, publisher, amt);
        this.isPrinted = isPrinted;
    }

    @Override
    public String toString() {
        return "Department: Periodicals | "+title+" by "+author+" | ISBN: "+ISBN+" | Publisher: "+publisher+" | ID: "+id+" | Amount: "+amt+" | Is Printed?: "+isPrinted;
    }
}
