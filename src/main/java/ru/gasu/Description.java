package ru.gasu;

public class Description {
    private int idDescription;
    private String hobby;
    private String profession;

    public Description (int idDescription, String  hobby, String profession) {
        this.idDescription = idDescription;
        this.hobby = hobby;
        this.profession = profession;
    }

    public int getIdDescription() {
        return idDescription;
    }

    public String getHobby() {
        return hobby;
    }

    public String getProfession() {
        return profession;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

