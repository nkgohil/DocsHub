package thesevenitsolutions.com.docshub.pojo;

public class hospital {
   private String City,name,email,department;

    public hospital(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public hospital(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public hospital(String city) {
        this.City = city;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
