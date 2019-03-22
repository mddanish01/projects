package com.tsys.retail.repository;

import org.springframework.data.repository.CrudRepository;
import com.tsys.retail.entity.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {

}
