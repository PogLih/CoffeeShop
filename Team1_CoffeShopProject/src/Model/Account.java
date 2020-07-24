/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Minh
 */
public class Account {
    private String Username;
    private String DisplayName;
    private String PassWord;
    private boolean Role; 
    public Account() {
    }

    public Account(String Username, String DisplayName, String PassWord, boolean Role) {
        this.Username = Username;
        this.DisplayName = DisplayName;
        this.PassWord = PassWord;
        this.Role = Role;
    }
    
    public String getUsername() {
        return Username;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public boolean isRole() {
        return Role;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setDisplayName(String DisplayName) {
        this.DisplayName = DisplayName;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public void setRole(boolean Role) {
        this.Role = Role;
    }
    
}
