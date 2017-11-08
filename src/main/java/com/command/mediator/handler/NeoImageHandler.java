package com.command.mediator.handler;

import java.awt.font.ImageGraphicAttribute;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.NeoImageRepository;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.NeoImageForm;

@Service
public class NeoImageHandler extends BaseHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);
	
	private String MOUNT_COMMAND = "./scripts/mountImage.sh";

	@Resource
	private NeoImageRepository neoImageRepository;
	
	@Resource
	private CommandExecutor commandExecutor;

	public NeoImageData uploadImage(NeoImageForm neoImageForm) {
		NeoImageData neoImage = createImageObject(neoImageForm);
		neoImage = neoImageRepository.save(neoImage);
		LOGGER.info("Running mount script");
		CommandExecutor.execute(MOUNT_COMMAND + " " + neoImage.getImageName() + " " + neoImage.getId());
		LOGGER.info("Mounted the image: {} ", neoImage);
		return neoImage;
	}

	public List<NeoImageData> getImageList() {
		List<NeoImageData> neoImageList = (List<NeoImageData>) neoImageRepository.findAll();
		LOGGER.info("List of all imagesL: {} ", neoImageList);
		return neoImageList;// new BmResponse(true, neoImageList.toString());
	}

	public NeoImageData getImage(String imageId) {
		NeoImageData data = neoImageRepository.findOne(Integer.valueOf(imageId));
		LOGGER.info("Found images: {} ", data);
		return data;
	}

}
