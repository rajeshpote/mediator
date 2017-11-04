package com.command.mediator.handler;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.command.mediator.persistent.NeoImageRepository;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.NeoImageForm;

@Service
public class NeoImageHandler extends BaseHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);

	@Resource
	private NeoImageRepository neoImageRepository;

	public NeoImageData uploadImage(NeoImageForm neoImageForm) {
		NeoImageData neoImage = createImageObject(neoImageForm);
		neoImage = neoImageRepository.save(neoImage);
		LOGGER.info("Uploaed image: {} ", neoImage);
		return neoImage;
	}

	public List<NeoImageData> getImageList() {
		List<NeoImageData> neoImageList = (List<NeoImageData>) neoImageRepository.findAll();
		LOGGER.info("List of all imagesL: {} ", neoImageList);
		return neoImageList;// new BmResponse(true, neoImageList.toString());
	}

}
