package com.example.glowdayz.domain.file;

import com.example.glowdayz.domain.file.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FolderService {
    boolean createFolder(CreateFolderCommand commend);
    boolean saveImage(SaveImageCommand commend);
    List<FolderInfo> showFolderList(ShowFolderListCommand commend);
    List<ImageInfo> showImageList(ShowImageListCommand commend);
}
