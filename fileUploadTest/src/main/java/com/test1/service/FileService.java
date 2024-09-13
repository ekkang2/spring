package com.test1.service;

import com.test1.dto.FileDTO;
import com.test1.entity.FileEntity;
import com.test1.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    @Value("${file.upload.path}")
    private String fileUploadPath;

    public void insertFile(FileDTO fileDTO) {
        FileEntity fileEntity = fileUpload(fileDTO);
        fileRepository.save(fileEntity);
    }

    public List<FileEntity> selectAllFile(){
        List<FileEntity> files = fileRepository.findAll();
        return files;
    }


    public FileEntity fileUpload(FileDTO fileDTO){

        // 파일 업로드 시스템 경로 구하기
        String path = new File(fileUploadPath).getAbsolutePath();

        // 파일
        MultipartFile multipartFile = fileDTO.getThumb();
        log.info("fileUpload...1");
        String oName = multipartFile.getOriginalFilename();
        log.info("fileUpload...2 : " + oName);

        String ext = oName.substring(oName.lastIndexOf("."));
        String sName = UUID.randomUUID().toString() + ext;
        log.info("fileUpload...3 : " + sName);

        try {
            // 저장
            multipartFile.transferTo(new File(path, sName));
        } catch (IOException e) {
            log.error("fileUpload : " + e.getMessage());
        }

        return FileEntity
                .builder()
                .title(fileDTO.getTitle())
                .thumb(sName)
                .build();
    }
}
