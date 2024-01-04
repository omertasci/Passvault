package com.omertasci.passvault.service;

import com.omertasci.passvault.dto.EntryDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EntryService {

    EntryDto getById(Long id);

    Collection<EntryDto> findAll();

    EntryDto saveEntry(EntryDto entry);
}
