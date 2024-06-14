import java.io.Serializable;

public class Patron implements Serializable{
    String name;
    String address;
    String phone;
    String list;
    boolean isEmployee;

    public Patron(String name, String address, String phone, String list, boolean isEmployee){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.list = list; 
        this.isEmployee = isEmployee;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setList(String list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    @Override
    public String toString() {
        if(this.isEmployee){
            return name+" is an employee, | "+phone+" | "+address+" | Borrowed: "+list;
        } else {
            return name+" is a student, | "+phone+" | "+address+" | Borrowed: "+list;
        }
    }
}
