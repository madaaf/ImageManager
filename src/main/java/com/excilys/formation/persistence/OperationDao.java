package com.excilys.formation.persistence;

import com.excilys.formation.model.Operation;
import org.springframework.data.repository.CrudRepository;

/**
 * OperationDao
 * DAO interface for table "operations" to be implemented
 */
public interface OperationDao extends CrudRepository<Operation, Long> {

  Operation save(Operation o);

}
