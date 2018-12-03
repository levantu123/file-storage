package com.antulev.storage.lib;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractController<M extends Model<ID>, ID, R extends PagingAndSortingRepository<M, ID>, S extends AbstractService<M, ID, R, F>, F extends AbstractFactory<M, ID>> {

	@Autowired
	S baseService;
	
	@PostMapping(value = "/{id}/upload", consumes = {"multipart/form-data"},
			produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> handleFileUpload(@PathVariable("id") ID id, @RequestParam("file") MultipartFile file) {
		return baseService.uploadFile(id, file);
    }
	
	@GetMapping("/model")
    public M getModel() {
		return baseService.getModel();
    }
	
	@PostMapping("")
    public M create(@RequestBody M model) {
		return baseService.create(model);
    }
	
	@PostMapping("/blindedCreate")
    public M blindedCreate() {
		return baseService.blindedCreate();
    }
}
