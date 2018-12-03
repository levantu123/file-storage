/**
 * 
 */
package com.antulev.storage.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antulev.storage.lib.AbstractFactory;
import com.antulev.storage.model.AttachmentModel;
import com.antulev.storage.model.MetaData;
import com.antulev.storage.repository.MetaDataRepository;

/**
 * @author levan
 *
 */

@Service
public class AttachmentFactory implements AbstractFactory<AttachmentModel, UUID> {

	@Autowired
	MetaDataRepository metaDataRepository;
	
	@Override
	public AttachmentModel initBluePrint() {
		AttachmentModel empty = new AttachmentModel();
		empty.setMetaData(new MetaData());
		return empty;
	}

	@Override
	public AttachmentModel buildElements(AttachmentModel newModel) {
		MetaData metaData = newModel.getMetaData();
		if(metaData!= null) {
			metaData = metaDataRepository.save(metaData);
		}
		newModel.setMetaData(metaData);
		return newModel;
	}

	@Override
	public AttachmentModel deleteElements(AttachmentModel model) {
		MetaData metaData = model.getMetaData();
		metaDataRepository.deleteById(metaData.getId());
		model.setMetaData(null);
		return model;
	}

}
