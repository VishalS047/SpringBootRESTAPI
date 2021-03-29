package com.rest.book.restbootdemo.FileUpload;

import java.io.File;
import java.io.IOException;
// import java.io.FileOutputStream;
// import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
    // public static final String FILE_UPLOAD_DIR = "C:\\Users\\Vishal Sharma\\Desktop\\SpringBoot\\restbootdemo\\src\\main\\resources\\static\\images";
    public  final String FILE_UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUpload()throws IOException
    {

    }
    public boolean isFileUploaded(MultipartFile file) {
        boolean f = false;
        try {

            // InputStream is = file.getInputStream();
            // byte[] data = new byte[is.available()];
            // is.read(data);

            // FileOutputStream fos = new
            // FileOutputStream(FILE_IPLOAD_DIR+File.separator+file.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();
            // f = true;

            Files.copy(file.getInputStream(), Paths.get(FILE_UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
