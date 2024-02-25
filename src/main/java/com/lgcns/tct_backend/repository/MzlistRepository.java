package com.lgcns.tct_backend.repository;

import com.lgcns.tct_backend.model.Mzlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MzlistRepository extends JpaRepository<Mzlist, Long> {
}
