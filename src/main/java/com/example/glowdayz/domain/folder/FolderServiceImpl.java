package com.example.glowdayz.domain.folder;

import com.example.glowdayz.domain.folder.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService  {

    @Override
    public boolean createFolder(CreateFolderCommand commend) {
        Folder folder = Folder.builder()
                .name(commend.getTitle())
                .userId(commend.getUserId())
                .build();
        return folder.makeDir();
    }

    @Override
    public boolean saveImage(SaveImageCommand commend) {
        return false;
    }

    @Override
    public List<FolderInfo> showFolderList(ShowFolderListCommand commend) {
        return null;
    }

    @Override
    public List<ImageInfo> showImageList(ShowImageListCommand commend) {
        return null;
    }
}
