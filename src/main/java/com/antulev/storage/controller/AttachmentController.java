package com.antulev.storage.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antulev.storage.lib.AbstractController;
import com.antulev.storage.model.AttachmentModel;
import com.antulev.storage.repository.AttachmentRepository;
import com.antulev.storage.service.AttachmentFactory;
import com.antulev.storage.service.AttachmentService;

@RestController
@RequestMapping(value="/attachments")
public class AttachmentController extends AbstractController<AttachmentModel, UUID, AttachmentRepository, AttachmentService, AttachmentFactory>{
	
	@GetMapping("about")
	public Map<String, String> about(){
		Map<String, String> map = new HashMap<>();
		map.put("mss", "extra service");
		return map;
	}
}
