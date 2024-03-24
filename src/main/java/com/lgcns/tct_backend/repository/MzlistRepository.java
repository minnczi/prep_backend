package com.lgcns.tct_backend.repository;

import com.lgcns.tct_backend.model.Mzlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MzlistRepository extends JpaRepository<Mzlist, Long> {
    List<Mzlist> findAllByUserId(Long userId);
}
