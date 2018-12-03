package com.antulev.storage.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.antulev.storage.lib.AbstractService;
import com.antulev.storage.model.AttachmentModel;
import com.antulev.storage.repository.AttachmentRepository;

@Service
public class AttachmentService extends AbstractService<AttachmentModel, UUID, AttachmentRepository, AttachmentFactory> {
}
