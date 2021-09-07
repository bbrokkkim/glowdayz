package com.example.glowdayz.domain.folder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Folder {
    private Long userId;
    private String name;
    private List<Image> images;


    private String newPath () {
        return "/"+ String.valueOf( userId )+"/"+ name;
    }

    public boolean makeDir() {
        System.out.println("newPath(): " + newPath());
        File dirPath = new File("resources/static/" + newPath());
        if (!dirPath.exists()) {
            dirPath.mkdirs();
            return true;
        } else {
            return false;
        }

    }
}
