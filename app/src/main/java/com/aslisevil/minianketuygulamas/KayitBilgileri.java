package com.aslisevil.minianketuygulamas;

public class KayitBilgileri {

    String[] nicnames = new String[20];
    String[] passwords = new String[20];
    int i=0;

    public KayitBilgileri() { }

    public void setUser(String nicname,String password) {
        this.nicnames[i] = nicname;
        this.passwords[i] = password;
        i++;
    }

    public boolean checkUser(String name, String password)
    {
        for(int j=0; j<20; j++)
        {
            if(nicnames[j]==name && passwords[j]==password)
                return true;
        }
        return false;
    }
}
