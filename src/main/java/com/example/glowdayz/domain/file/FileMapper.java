package com.example.glowdayz.domain.file;

import com.example.glowdayz.domain.file.dto.ImageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper( FileMapper.class );
    @Mapping(source = "folderName", target = "name")
    ImageInfo convertFrom(Image image);
}
