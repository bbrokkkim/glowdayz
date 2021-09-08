package com.example.glowdayz.facade;

import com.example.glowdayz.domain.file.FolderService;
import com.example.glowdayz.domain.file.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FolderFacade {
    private final FolderService folderService;

    public boolean createFolder(CreateFolderCommand commend) {
        var result = folderService.createFolder(commend);
        return result;
    }

    public boolean saveImage(SaveImageCommand commend) {
        var result = folderService.saveImage(commend);
        return result;
    }

    public List<FolderInfo> showFolderList(ShowFolderListCommand commend) {
        var result = folderService.showFolderList(commend);
        return result;
    }

    public List<ImageInfo> showImageList(ShowImageListCommand commend) {
        var result = folderService.showImageList(commend);
        return result;
    }


}
