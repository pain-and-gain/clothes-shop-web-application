/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class AccountError implements Serializable {
    private String uIDError;
    private String usernameError;
    private String passError;
    private String repassError;

    public AccountError() {
    }

    public AccountError(String uIDError, String usernameError, String passError, String repassError) {
        this.uIDError = uIDError;
        this.usernameError = usernameError;
        this.passError = passError;
        this.repassError = repassError;
    }

    public String getuIDError() {
        return uIDError;
    }

    public void setuIDError(String uIDError) {
        this.uIDError = uIDError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPassError() {
        return passError;
    }

    public void setPassError(String passError) {
        this.passError = passError;
    }

    public String getRepassError() {
        return repassError;
    }

    public void setRepassError(String repassError) {
        this.repassError = repassError;
    }


   
}
