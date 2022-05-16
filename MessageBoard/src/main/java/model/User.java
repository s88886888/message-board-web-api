package model;

public class User {

    @Override
    public String toString() {
        return "User{" +
                "Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                ", PassWord='" + PassWord + '\'' +
                '}';
    }

    public  String Phone;

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String Email;
    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String PassWord;
}
