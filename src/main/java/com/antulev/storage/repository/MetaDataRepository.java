package com.antulev.storage.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.antulev.storage.model.MetaData;

public interface MetaDataRepository extends PagingAndSortingRepository<MetaData, UUID>{

}
