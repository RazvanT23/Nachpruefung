public class Student {
    int id;
    String name;
    String haus;
    String autoritat;
    int puncte;

    public Student(int id, String name, String haus, String autoritat, int puncte) {
        this.id = id;
        this.name = name;
        this.haus = haus;
        this.autoritat = autoritat;
        this.puncte = puncte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHaus() {
        return haus;
    }

    public void setHaus(String haus) {
        this.haus = haus;
    }

    public String getAutoritat() {
        return autoritat;
    }

    public void setAutoritat(String autoritat) {
        this.autoritat = autoritat;
    }

    public int getPuncte() {
        return puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte = puncte;
    }
}
