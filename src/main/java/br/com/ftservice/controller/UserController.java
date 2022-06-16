package br.com.ftservice.controller;

import br.com.ftservice.model.AppUser;
import br.com.ftservice.model.dto.UserDto;
import br.com.ftservice.model.form.UserForm;
import br.com.ftservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Page<UserDto> getList(@PageableDefault(page = 0, size = 10, sort = "id")
                                         Pageable pagination) {
    Page<AppUser> users = userRepository.findAll(pagination);
    return UserDto.convert(users);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> post(@RequestBody @Valid UserForm form,
                                        UriComponentsBuilder uriBuilder) {
        AppUser appUser = form.convert();
        userRepository.save(appUser);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(appUser.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(appUser));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<AppUser> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
