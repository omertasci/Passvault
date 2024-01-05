package com.omertasci.passvault.service.impl;

import com.omertasci.passvault.dto.EntryDto;
import com.omertasci.passvault.entity.Entry;
import com.omertasci.passvault.repository.EntryRepository;
import com.omertasci.passvault.service.EntryService;
import com.omertasci.passvault.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryRepository entryRepository;
    @Autowired
    private MapUtil mapUtil;

    @Override
    public EntryDto getById(Long id) {

        Optional<Entry> oe = entryRepository.findById(id);
        if (oe.isEmpty()) throw new NoSuchElementException("Entry not found!");
        return mapUtil.map(oe.get(), EntryDto.class);
    }

    @Override
    public Collection<EntryDto> findAll() {
        Collection<Entry> entries = entryRepository.findAll();
        return mapUtil.typeCastList(entries, EntryDto.class);
    }

    @Override
    public EntryDto saveEntry(EntryDto entryDto) {

        Entry entry = mapUtil.map(entryDto, Entry.class);
        Entry entrySaved = entryRepository.save(entry);
        return mapUtil.map(entrySaved, EntryDto.class);
    }

}
