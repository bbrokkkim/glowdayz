package com.example.glowdayz.domain.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class SaveImageCommand {
    private final List<String> urlList;
    private final List<String> tagList;
    private final String folderName;
    private final Long userId;
}
