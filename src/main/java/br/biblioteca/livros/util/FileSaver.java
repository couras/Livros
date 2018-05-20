package br.biblioteca.livros.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	public String write(String baseFolder, MultipartFile file) {
		
		//Windows
		//String realPath = "D:/POS/" + baseFolder;
		
		//Linux
		String realPath = "/POS/" + baseFolder;

		File folder = new File(realPath);
		if(!folder.exists()){
			folder.mkdirs();
		}
		try {
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			return baseFolder + "/" + file.getOriginalFilename();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public String read(String basicPath) {
		String realPath = "/POS/";
		return realPath + basicPath;
	}
}
