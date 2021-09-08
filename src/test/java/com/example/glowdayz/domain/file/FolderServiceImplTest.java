package com.example.glowdayz.domain.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.example.glowdayz.domain.folder.dto.*;
import com.example.glowdayz.domain.file.dto.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FolderServiceImplTest {
    @Autowired
    FolderServiceImplForDB service;

    @Test
    @DisplayName("폴더 생성")
    public void createFolderTest() {
        CreateFolderCommand commend = CreateFolderCommand.builder()
                .title("testname")
                .userId(1L)
                .build();


        File dirPath = new File("resources/static/1/testname");

        boolean expect = !dirPath.exists();
        boolean result = service.createFolder(commend);

        Assertions.assertEquals(expect, result);
    }


    @Test
    @DisplayName("파일 생성")
    public void createImageTest() {
        List<String> urlList = new ArrayList<>();
        urlList.add("filename");
        urlList.add("filename2");
        SaveImageCommand commend = SaveImageCommand.builder()
                .urlList(urlList)
                .folderName("testname")
                .userId(1L)
                .build();

        boolean expect = true;

        boolean result = service.saveImage(commend);
        File dirPath = new File("resources/static/1/testname");
        if (dirPath.exists()) {
            File filePath = new File("resources/static/1/testname/filename");
            expect = filePath.exists();
        } else {
            expect = false;
        }

        Assertions.assertEquals(expect, result);
    }


    @Test
    @DisplayName("폴더 정보 확인")
    public void showFolderTest() {
        ShowFolderListCommand commend = ShowFolderListCommand.builder()
                .userId(1L)
                .build();

        List<FolderInfo> result = service.showFolderList(commend);

        Assertions.assertEquals("resources\\static\\1\\testname", result.get(0).getName());
    }

    @Test
    @DisplayName("이미지 정보 확인")
    public void showImageTest() {
        ShowImageListCommand commend = ShowImageListCommand.builder()
                .userId(1L)
                .folderName("testname")
                .build();

        List<ImageInfo> result = service.showImageList(commend);

        Assertions.assertEquals("filename", result.get(0).getName());
    }

}
