package com.omertasci.passvault.repository;

import com.omertasci.passvault.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

    Optional<Entry> findById(Long id);

    List<Entry> findAll();

}
