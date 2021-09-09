package com.example.glowdayz.interfaces.file;

import com.example.glowdayz.domain.file.dto.FolderInfo;
import com.example.glowdayz.domain.file.dto.ImageInfo;
import com.example.glowdayz.facade.FolderFacade;
import com.example.glowdayz.interfaces.file.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class FileController {
    private final FolderFacade folderFacade;
    FileMapper mapper = FileMapper.INSTANCE;

    @PostMapping("folder")
    public boolean createFolder (CreateFolderRequestDto dto) {
        return folderFacade.createFolder(mapper.convertFrom(dto));
    }

    @PostMapping("image")
    public boolean createImage (SaveImageRequestDto dto) {
        return folderFacade.saveImage(mapper.convertFrom(dto));
    }

    @GetMapping("folder")
    public List<ShowFolderListResponseDto> showFolderList(ShowFolderListRequestDto dto){
        List<FolderInfo> folderInfoList = folderFacade.showFolderList(mapper.convertFrom(dto));
        return folderInfoList.stream().map(mapper::convertFrom).collect(Collectors.toList());
    }

    @GetMapping("image")
    public List<ShowImageListResponseDto> showImageList(ShowImageListRequestDto dto){
        List<ImageInfo> imageInfoList = folderFacade.showImageList(mapper.convertFrom(dto));
        return imageInfoList.stream().map(mapper::convertFrom).collect(Collectors.toList());
    }

    @GetMapping("image/tag")
    public List<ShowImageListResponseDto> showImageListByTagSize() {
        List<ImageInfo> imageInfoList = folderFacade.showImageListByTagSize();
        return imageInfoList.stream().map(mapper::convertFrom).collect(Collectors.toList());
    }
}