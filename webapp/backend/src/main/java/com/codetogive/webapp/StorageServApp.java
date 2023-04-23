package com.codetogive.webapp;

import com.codetogive.webapp.service.StorageServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@SpringBootApplication
@RestController
@RequestMapping("/files")
public class StorageServApp {

    @Autowired
    private StorageServ.StorageService service;

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        String uploadFile = service.uploadFile(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadFile);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName){
        byte[] fileData=service.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("file/pdf"))
                .body(fileData);
    }

    public static void main(String[] args) {
        SpringApplication.run(StorageServApp.class, args);
    }

}