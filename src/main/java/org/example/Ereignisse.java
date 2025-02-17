package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ereignisse {
    int Id;
    String Mitgliedsname;
    String Haus;
    String Ereignis;
    String Datum;

    public Ereignisse(@JsonProperty("Id") int Id, @JsonProperty("Mitgliedsname") String Mitgliedsname, @JsonProperty("Haus") String Haus, @JsonProperty("Ereignis") String Ereignis, @JsonProperty("Datum") String Datum) {
        this.Id = Id;
        this.Mitgliedsname = Mitgliedsname;
        this.Haus = Haus;
        this.Ereignis = Ereignis;
        this.Datum = Datum;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMitgliedsname() {
        return Mitgliedsname;
    }

    public void setMitgliedsname(String mitgliedsname) {
        Mitgliedsname = mitgliedsname;
    }

    public String getHaus() {
        return Haus;
    }

    public void setHaus(String haus) {
        Haus = haus;
    }

    public String getEreignis() {
        return Ereignis;
    }

    public void setEreignis(String ereignis) {
        Ereignis = ereignis;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }
}