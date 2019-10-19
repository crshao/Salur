package Models;

public class User {
    private String nama;
    private String username;
    private String email;
    private String password;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public User(String nama, String username, String email, String password) {
        this.nama = nama;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}