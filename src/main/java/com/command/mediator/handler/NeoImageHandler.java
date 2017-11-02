package com.command.mediator.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.mongo.NeoImageRepository;
import com.command.mediator.pojo.BmResponse;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.ImageForm;

@Service
public class NeoImageHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);
	
	@Resource
	private NeoImageRepository neoImageRepository;
	
	public BmResponse uploadImage(NeoImageData neoImageData) {
		NeoImageData neoImage = new NeoImageData();
		neoImage.setName(neoImageData.getName());
		neoImage.setDescription(neoImageData.getDescription());
		neoImage.setMountPath(neoImageData.getMountPath());
		neoImage.setIsoPath(neoImageData.getIsoPath());
		
		NeoImageData savedImage = neoImageRepository.insert(neoImage);
		LOGGER.info("Uploaed image " +neoImageData.getName());
		// TODO: Upload image to location: /home/neo/iso-images
		//Run mnt command to mount to path /mnt/neo
		return new BmResponse(true, savedImage.toString());
	}
	
	public BmResponse getImageList() {
		List<NeoImageData> neoImageList = neoImageRepository.findAll();
		LOGGER.info("List of all images " +neoImageList.toString());
		return new BmResponse(true, neoImageList.toString());
	}

}
