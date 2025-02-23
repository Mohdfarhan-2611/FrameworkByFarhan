package org.example.POJO;

public class LoginQKartUser {

   private String validusername;
   private String validpassword;
   private String invalidusername;
   private String invalidpassword;

   public LoginQKartUser(String validusername, String validpassword, String invalidusername, String invalidpassword) {
        this.validusername = validusername;
        this.validpassword = validpassword;
        this.invalidusername = invalidusername;
        this.invalidpassword = invalidpassword;
    }


    public String getInvalidpassword() {
        return invalidpassword;
    }

    public void setInvalidpassword(String invalidpassword) {
        this.invalidpassword = invalidpassword;
    }

    public String getInvalidusername() {
        return invalidusername;
    }

    public void setInvalidusername(String invalidusername) {
        this.invalidusername = invalidusername;
    }

    public String getValidpassword() {
        return validpassword;
    }

    public void setValidpassword(String validpassword) {
        this.validpassword = validpassword;
    }

    public String getValidusername() {
        return validusername;
    }

    public void setValidusername(String validusername) {
        this.validusername = validusername;
    }


    @Override
    public String toString() {
        return "LoginQKartUser{" +
                "validusername='" + validusername + '\'' +
                ", validpassword='" + validpassword + '\'' +
                ", invalidusername='" + invalidusername + '\'' +
                ", invalidpassword='" + invalidpassword + '\'' +
                '}';
    }
}
