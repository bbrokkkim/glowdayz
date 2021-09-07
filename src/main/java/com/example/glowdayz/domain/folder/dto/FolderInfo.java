package com.example.glowdayz.domain.folder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
public class FolderInfo {
    private final String name;
    private final List<ImageInfo> images;
}
