package com.codetogive.webapp.service;

import com.codetogive.webapp.entity.FileData;
import com.codetogive.webapp.entity.FileData;
import com.codetogive.webapp.repository.StorageRepository;
import com.codetogive.webapp.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public class StorageServ {

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadFile(MultipartFile file) throws IOException {

        FileData fileData = repository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .pdfData(FileUtils.compressFile(file.getBytes())).build());
        if (fileData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadFile(String fileName) {
        Optional<FileData> dbFileData = repository.findByName(fileName);
        byte[] images = FileUtils.decompressFile(dbFileData.get().getFileData());
        return images;
    }
}
}