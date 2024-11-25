package sg.edu.nus.iss.vttp5a_ssf_day15l.model;

public class Person {
    //put in the necessary validations
    private Integer id;
    private String name;
    private String email;

    public Person() {

    }

    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return id + "," + name + "," + email;
    }

    
    // @Override
    // public String toString() {
    //     return id + ", " + name + ", " + email;
    // }

    
    
}
