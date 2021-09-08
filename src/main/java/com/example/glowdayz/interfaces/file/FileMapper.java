package com.example.glowdayz.interfaces.file;

import com.example.glowdayz.domain.file.dto.*;
import com.example.glowdayz.interfaces.file.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper( FileMapper.class );

    CreateFolderCommand convertFrom(CreateFolderRequestDto dto);
    SaveImageCommand convertFrom(SaveImageRequestDto dto);
    ShowFolderListCommand convertFrom(ShowFolderListRequestDto dto);
    ShowFolderListResponseDto convertFrom(FolderInfo info);

    ShowImageListCommand convertFrom(ShowImageListRequestDto dto);
    ShowImageListResponseDto convertFrom(ImageInfo info);
}
