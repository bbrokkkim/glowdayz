package com.example.glowdayz.domain.folder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class SaveImageCommand {
    private final List<String> urlList;
    private final String folderName;
    private final Long userId;
}
