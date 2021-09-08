package com.example.glowdayz.domain.file;

import com.example.glowdayz.domain.file.dto.ImageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    private Integer tagSize;
    private String tags;

    private Long userId;
    private String folderName;

    private String setFilePath (String imageName) {
        return "resources/static/" + String.valueOf( userId )+"/"+ folderName+"/"+ imageName;
    }

    private String setFilePath () {
        return "resources/static/" + String.valueOf( userId )+"/"+ folderName;
    }

    private boolean isExistedFolder () {
        File file = new File("resources/static/"+ String.valueOf( userId )+"/"+ folderName);
        return file.exists();
    }

    private List<ImageInfo> makeImageList(){
        List<ImageInfo> imageInfoList = new ArrayList<>();
        File fileList[] = new File(setFilePath()).listFiles();

        for (File file: fileList) {
            ImageInfo imageInfo = ImageInfo.builder()
                    .name(file.getName())
                    .build();
            imageInfoList.add(imageInfo);
        }
        return imageInfoList;
    }

    public boolean makeFiles(List<String> imageList) {
        if (isExistedFolder()) {
            for (String image : imageList) {
                File file = new File(setFilePath(image));
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public List<ImageInfo> showImageList() {
        if (isExistedFolder()) {
            return makeImageList();
        } else {
            return null;
        }
    }


}
