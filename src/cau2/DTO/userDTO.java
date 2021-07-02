package cau2.DTO;

public class userDTO {
    String userName;
    String password;
    String name;
    

    public userDTO(String userName, String password, String name)
    {
        this.userName = userName;
        this.password = password;
        this.name = name;
        
    }

    public userDTO(){
        this.userName = null;
        this.password = null;
        this.name = null;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
