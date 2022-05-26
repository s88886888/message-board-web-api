package model;

public class User {

    public int id;
    public String Phone;
    public String Email;
    public String Name;
    public String PassWord;

    public  String img;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
