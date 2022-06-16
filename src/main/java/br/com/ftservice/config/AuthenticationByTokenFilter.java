package br.com.ftservice.config;

import br.com.ftservice.model.AppUser;
import br.com.ftservice.repository.UserRepository;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationByTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    public AuthenticationByTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException,
            IOException {
        String token = tokenRecovery(request);
        boolean valid = tokenService.isValidToken(token);
        if (valid) {
            athenticateClient(token);
        }

        filterChain.doFilter(request, response);
    }

    private void athenticateClient(String token) {
        Long userId = tokenService.getUserId(token);
        AppUser appUser = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(appUser, null,
                        appUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String tokenRecovery(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7, token.length());
    }
}
