package com.example.glowdayz.interfaces.folder;

import com.example.glowdayz.domain.folder.dto.*;
import com.example.glowdayz.interfaces.folder.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FolderMapper {
    FolderMapper INSTANCE = Mappers.getMapper( FolderMapper.class );

    CreateFolderCommand convertFrom(CreateFolderRequestDto dto);
    SaveImageCommand convertFrom(SaveImageRequestDto dto);
    ShowFolderListCommand convertFrom(ShowFolderListRequestDto dto);
    ShowFolderListResponseDto convertFrom(FolderInfo info);

    ShowImageListCommand convertFrom(ShowImageListRequestDto dto);
    ShowImageListResponseDto convertFrom(ImageInfo info);
}
