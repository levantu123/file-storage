package com.antulev.storage.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.antulev.storage.model.AttachmentModel;

public interface AttachmentRepository extends PagingAndSortingRepository<AttachmentModel, UUID> {
}
