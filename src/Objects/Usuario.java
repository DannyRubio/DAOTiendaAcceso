/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author MULTI
 */
public class Usuario {
    private String user;
    private String password;
    private String nivel;
    
    public Usuario(String user,String password){
    this.user=user;
    this.password=password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setNull(){
        user=null;
        password=null;
    }
}