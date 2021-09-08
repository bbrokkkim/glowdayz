package com.example.glowdayz.domain.folder;

import com.example.glowdayz.domain.folder.dto.FolderInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
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

    private static List<FolderInfo> makeFolderList(File files[]) {
        File subDir;
        List<FolderInfo> folderInfoList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            System.out.println("file: " + files[i]);
            subDir = new File(String.valueOf(files[i]));

            FolderInfo folderInfo = FolderInfo.builder()
                    .imageSize(subDir.listFiles().length)
                    .name(String.valueOf(files[i]))
                    .build();
            folderInfoList.add(folderInfo);
        }
        return folderInfoList;
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

    public static List<FolderInfo> showDirList (Long userId) {
        File dirList[] = new File("resources/static/"+ userId).listFiles();
        return makeFolderList(dirList);
    }


}
