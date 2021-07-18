package com.br.FichaTecnicaApi.models.dto;

import com.br.FichaTecnicaApi.models.AppUser;
import org.springframework.data.domain.Page;

public class UserDto {

    private Long id;
    private String username;
    private String name;
    //TODO incluir no DTO a lista de perfis.

    public UserDto(AppUser appUser) {
        this.id = appUser.getId();
        this.username = appUser.getUsername();
        this.name = appUser.getName();
    }

    public static Page<UserDto> convert(Page<AppUser> users) {
        return users.map(UserDto::new);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return name;
    }
}
