package com.example.glowdayz.interfaces.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class SaveImageRequestDto {
    private final List<String> urlList;
    private final String folderName;
    private final Long userId;
}
