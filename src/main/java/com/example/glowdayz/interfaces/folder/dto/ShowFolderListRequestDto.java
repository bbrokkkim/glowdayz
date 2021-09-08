package com.example.glowdayz.interfaces.folder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ShowFolderListRequestDto {
    private final Long userId;
}
