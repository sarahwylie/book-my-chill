package io.bootify.book_my_chill.service;

import io.bootify.book_my_chill.model.User;
import io.bootify.book_my_chill.repos.UserRepository;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User get(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final User user) {
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final User user) {
        final User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }
}
