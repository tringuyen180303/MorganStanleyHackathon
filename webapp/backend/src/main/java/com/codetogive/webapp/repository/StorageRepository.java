package com.codetogive.webapp.repository;

import com.codetogive.webapp.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StorageRepository extends JpaRepository<FileData,Long> {


    Optional<FileData> findByName(String fileName);
}
