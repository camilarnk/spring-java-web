package com.cr.spring_security.repositories;

import com.cr.spring_security.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Model, Long> {
}
