import com.fasterxml.jackson.annotation.JsonProperty;

public class Ninja {
    int id;
    String charaktername;
    String stufe;
    String beschreibung;
    String datum;
    double punkte;

    public Ninja(@JsonProperty("Id") int id, @JsonProperty("Charaktername") String charaktername, @JsonProperty("Stufe") String stufe, @JsonProperty("Beschreibung") String beschreibung, @JsonProperty("Datum") String datum, @JsonProperty("Kraftpunkte") double punkte) {
        this.id = id;
        this.charaktername = charaktername;
        this.stufe = stufe;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.punkte = punkte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharaktername() {
        return charaktername;
    }

    public void setCharaktername(String charaktername) {
        this.charaktername = charaktername;
    }

    public String getStufe() {
        return stufe;
    }

    public void setStufe(String stufe) {
        this.stufe = stufe;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
}
