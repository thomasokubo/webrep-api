package com.repnation.webrep.service;

import com.repnation.webrep.domain.model.TrashEntry;
import com.repnation.webrep.repository.TrashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrashService {

    private final TrashRepository trashRepository;

    @Autowired
    public TrashService(TrashRepository trashRepository) {
        this.trashRepository = trashRepository;
    }

    public TrashEntry save(TrashEntry entry) {
        return trashRepository.save(entry);
    }
}
