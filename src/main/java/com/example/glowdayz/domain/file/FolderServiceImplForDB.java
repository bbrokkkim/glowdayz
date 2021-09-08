package com.example.glowdayz.domain.file;

import com.example.glowdayz.domain.file.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FolderServiceImplForDB implements FolderService  {
    private final ImageRepository imageRepository;
    FileMapper mapper = FileMapper.INSTANCE;

    // 폴더가 이미 존재하면 false, 존재하지 않으면 true
    @Override
    public boolean createFolder(CreateFolderCommand commend) {
        Folder folder = Folder.builder()
                .name(commend.getTitle())
                .userId(commend.getUserId())
                .build();
        return folder.makeDir();
    }

    // 폴더가 존재하지 않으면 false, 있으면 파일 만들고 true
    @Override
    public boolean saveImage(SaveImageCommand commend) {
        String tags = "";
        for(String tag: commend.getTagList()) {
            tags += "|" + tag;
        }
        Image image = Image.builder()
                .folderName(commend.getFolderName())
                .userId(commend.getUserId())
                .tags(tags)
                .tagSize(commend.getTagList().size())
                .build();

        imageRepository.save(image);
        return image.makeFiles(commend.getUrlList());
    }

    @Override
    public List<FolderInfo> showFolderList(ShowFolderListCommand commend) {
        return Folder.showDirList(commend.getUserId());
    }

    @Override
    public List<ImageInfo> showImageList(ShowImageListCommand commend) {
        Image image = Image.builder()
                .folderName(commend.getFolderName())
                .userId(commend.getUserId())
                .build();
        return image.showImageList();
    }

//    @Override
    public List<ImageInfo> showImageListByTagSize(ShowImageListCommand commend) {
        Image image = Image.builder()
                .folderName(commend.getFolderName())
                .userId(commend.getUserId())
                .build();
        List<Image> imageList = imageRepository.findTop10ByOrderByTagSizeDesc();

        return imageList.stream().map(mapper::convertFrom).collect(Collectors.toList());
    }


}
