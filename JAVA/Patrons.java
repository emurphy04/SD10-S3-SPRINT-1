import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patrons extends Object implements Serializable {
    private List<Patron> patrons;

    public Patrons(){
        patrons = new ArrayList<Patron>();
    }

    public void addPatron(Patron patron){
        patrons.add(patron);
    }

    public void editName(String name, String newName){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.get(i).setName(newName);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void editAddress(String name, String newAddress){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.get(i).setAddress(newAddress);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void editPhone(String name, String newPhone){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.get(i).setPhone(newPhone);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void editIsEmployee(String name, boolean employeeStatus){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.get(i).setIsEmployee(employeeStatus);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public void editList(String name, String newList){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.get(i).setList(newList);
            } else {
                System.out.println("Author not found");
            }
        }
    }

    public String addToList(String name, String title){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.get(i).addToList(title);
                return "valid";
            }
        }
        return "Patron not found, Please sign up before borrowing a book.";
    }

    public String removeFromList(String name, String title){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                String listList[] = patrons.get(i).list.split(",", 0);
                String newList = "";
                for(String a : listList){
                    if(a.equals(" "+title)){
                        //pass
                    } else if (a.equals(",")){
                        //pass
                    } else {
                        newList = newList + a;
                    }
                }
                patrons.get(i).setList(newList);
                return "valid";
            }
        }
        return "Patron not found, Please sign up before borrowing a book.";
    }

    public void removePatron(String name){
        for(int i = 0; i<patrons.size(); i++){
            if(patrons.get(i).name.equals(name)){
                patrons.remove(i);
            } else {
                System.out.println("Patron not found");
            }
        }
    }

    public String getPatron(String phone){
        for(int i = 0; i<patrons.size();i++){
            if(patrons.get(i).phone.equals(phone)){
                return patrons.get(i).toString();
            }
        }
        return "No Patron Available.";
    }

    @Override
    public String toString() {
        String patList = "";
        for(int i = 0; i<patrons.size();i++){
            patList = patList + "\n"+patrons.get(i).toString(); 
        }
        return patList;
    }
}
