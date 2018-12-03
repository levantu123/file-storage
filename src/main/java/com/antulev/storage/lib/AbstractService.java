package com.antulev.storage.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractService<M extends Model<ID>, ID, R extends PagingAndSortingRepository<M, ID>, F extends AbstractFactory<M, ID>> {
	
	@Autowired
	protected R repository;
	
	@Autowired
	protected StorageService storageService;
	
	@Autowired
	protected F factory;
	
	public M getModel() {
		return factory.initBluePrint();
	}
	
	public M create(M model) {
		return repository.save(factory.buildElements(model));
	}
	
	public Map<String, String> uploadFile(ID id, MultipartFile file) {
		Map<String, String> map = new HashMap<>();
		Optional<M> modelOtion = repository.findById(id);
		if(modelOtion.isPresent()) {
			M model = modelOtion.get();
			storageService.store(file);
			repository.save(factory.buildElements(model));
			map.put("message", "Uploaded!");
			return map;
		}
		map.put("message", "Failed!");
		return map;
	}
	
	public M blindedCreate() {
		return repository.save(factory.buildElements(factory.initBluePrint()));
	}
	
	public Map<String, String> delete(ID id){
		Optional<M> modelOtion = repository.findById(id);
		if(modelOtion.isPresent()) {
			M model = modelOtion.get();
			factory.deleteElements(model);
			repository.deleteById(id);
		}
		return null;
	}
}
