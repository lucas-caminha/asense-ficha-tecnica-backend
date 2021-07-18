package com.br.FichaTecnicaApi.controllers;

import com.br.FichaTecnicaApi.models.dto.TokenDto;
import com.br.FichaTecnicaApi.config.TokenService;
import com.br.FichaTecnicaApi.models.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken loginData = form.convert();
        try {
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.tokenGenerate(authentication);

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
