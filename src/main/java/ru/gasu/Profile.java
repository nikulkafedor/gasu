package ru.gasu;

import java.util.UUID;

public class Profile<S> {
    private int idProfile;
    private String name;
    private String lastName;
    private int age;
    private Sex sex;
    private boolean like;

    public Profile() {
        this.idProfile = idProfile;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex =  sex;
        this.like = like;
    }

    public int getIdProfile(Integer idProfile, String name, String lastName, Integer age, boolean like) {
        return this.idProfile;
    }

    public String getName() {
        return name;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public boolean isLike() {
        return like;
    }
    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
