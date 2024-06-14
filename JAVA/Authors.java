import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Authors extends Object implements Serializable {
    private List<Author> authors;

    public Authors(){
        authors = new ArrayList<Author>();
    }

    public void addAuth(Author author){
        authors.add(author);
    }

    public void editName(String name, String newName){
        for(int i = 0; i<authors.size(); i++){
            if(authors.get(i).name.equals(name)){
                authors.get(i).setName(newName);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void editDob(String name, String newDOB){
        for(int i = 0; i<authors.size(); i++){
            if(authors.get(i).name.equals(name)){
                authors.get(i).setDob(newDOB);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void editItems(String name, String newItems){
        for(int i = 0; i<authors.size(); i++){
            if(authors.get(i).name.equals(name)){
                authors.get(i).setItems(newItems);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void removeAuth(String name){
        for(int i = 0; i<authors.size(); i++){
            if(authors.get(i).name.equals(name)){
                authors.remove(i);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    @Override
    public String toString() {
        String authList = "";
        for(int i = 0; i<authors.size();i++){
            authList = authList + "\n"+authors.get(i).toString(); 
        }
        return authList;
    }
}
