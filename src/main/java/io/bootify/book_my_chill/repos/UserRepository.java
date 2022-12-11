package io.bootify.book_my_chill.repos;

import io.bootify.book_my_chill.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
