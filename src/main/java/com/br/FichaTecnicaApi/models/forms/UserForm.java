package com.br.FichaTecnicaApi.models.forms;

import com.br.FichaTecnicaApi.models.AppUser;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserForm {
    @NotNull @Length(min = 5)
    private String username;
    @NotNull @Length(min = 3)
    private String password;
    @NotNull @Length(min = 2)
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUser convert() {
        return new AppUser(this.username, this.password, this.name);
    }
}
