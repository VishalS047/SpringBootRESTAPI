package com.rest.book.restbootdemo.Controllers;

import com.rest.book.restbootdemo.FileUpload.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private FileUpload fileUpload;

    @PostMapping(path = "/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("profile") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        System.out.println("Yo Yo Honey Singh");
        try {
            boolean status = fileUpload.isFileUploaded(file);
            System.out.println(status);
            if(status){
                // return ResponseEntity.ok("File is successfully written in the disk............");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong......");
    }
}
