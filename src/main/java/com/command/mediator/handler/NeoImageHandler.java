package com.command.mediator.handler;

import java.awt.font.ImageGraphicAttribute;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.command.mediator.cmn.CommandExecutor;
import com.command.mediator.persistent.NeoImageRepository;
import com.command.mediator.pojo.NeoImageData;
import com.command.mediator.webservice.form.NeoImageForm;

@Service
public class NeoImageHandler extends BaseHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(CobblerHandler.class);
	
	private String MOUNT_COMMAND = "/home/neo/scripts/mountImage.sh";
	
	@Resource
	private NeoImageRepository neoImageRepository;
	
	@Resource
	private CommandExecutor commandExecutor;

	public NeoImageData uploadImage(NeoImageForm neoImageForm) {
		NeoImageData neoImage = createImageObject(neoImageForm);
		if(storeFile(neoImageForm.getFile(), neoImage.getIsoPath())){
			neoImage = neoImageRepository.save(neoImage);
			LOGGER.info("Running mount script");
			CommandExecutor.execute(MOUNT_COMMAND + " " + neoImage.getImageName() + " " + neoImage.getId());
			LOGGER.info("Mounted the image: {} ", neoImage);
			return neoImage;
		}
		return null;
		
	}
	
	private boolean storeFile(MultipartFile file,String location){
		try {
			Path rootLocation = Paths.get(location);
			long count = Files.copy(file.getInputStream(),rootLocation.resolve(file.getOriginalFilename()));
			LOGGER.info("File:{} successfully uploaded at loaction:{}",file.getOriginalFilename(),location);
			return count>0?true:false;
		} catch (Exception e) {
        	throw new RuntimeException("Fail to upload file");
        }
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

	public NeoImageData uploadImage(MultipartFile file, String imageName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteImage(String imageId) {
		neoImageRepository.delete(Integer.valueOf(imageId));
		return "Success";
	}

}
