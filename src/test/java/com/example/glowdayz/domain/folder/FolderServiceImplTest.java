package com.example.glowdayz.domain.folder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.example.glowdayz.domain.folder.dto.*;
import com.example.glowdayz.domain.folder.dto.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FolderServiceImplTest {
    @Autowired
    FolderServiceImpl service;

    @Test
    @DisplayName("폴더 생성")
    public void createFolderTest() {
        CreateFolderCommand commend = CreateFolderCommand.builder()
                .title("testname")
                .userId(1L)
                .build();

        boolean result = service.createFolder(commend);


//
//
//
        Assertions.assertEquals(false, result);
//        Assertions.assertEquals(commend.getGrade(), info.getGrade());
    }
}