package com.example.glowdayz.interfaces.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class CreateFolderRequestDto {
    private final String title;
    private final Long userId;
}
