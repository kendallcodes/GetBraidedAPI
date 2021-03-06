package com.getbraided.repository;

import org.springframework.data.repository.CrudRepository;

import com.getbraided.entity.Style;

public interface StyleRepository extends CrudRepository<Style, Long> {

	public Iterable<Style> findByStyleName(String styleName);

	//public Style findByStyleId(Long styleId);
}
