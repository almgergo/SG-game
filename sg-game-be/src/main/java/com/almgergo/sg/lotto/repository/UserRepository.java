package com.almgergo.sg.lotto.repository;

import com.almgergo.sg.lotto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
