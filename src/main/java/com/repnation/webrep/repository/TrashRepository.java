package com.repnation.webrep.repository;

import com.repnation.webrep.domain.model.TrashEntry;
import org.springframework.data.repository.CrudRepository;

public interface TrashRepository extends CrudRepository<TrashEntry, Long> {

}
