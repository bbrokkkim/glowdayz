package com.example.glowdayz.interfaces.folder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ShowImageListRequestDto {
    private final Long userId;
    private final String folderName;
}
