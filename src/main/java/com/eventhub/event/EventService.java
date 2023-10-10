package com.eventhub.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository repository;

    public List<Event> findAll() {
        return repository.findAll();
    }

    public boolean delete(Long id) {
        var event = repository.findById(id);
        if (event.isEmpty())
            return false;
        repository.deleteById(id);
        return true;
    }

}
