package com.tsys.retail.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tsys.retail.entity.LineItem;

public interface LineItemRepository extends CrudRepository<LineItem, Long> {
	
	public List<LineItem> findByProduct_id(long prodId);

}
