package com.example.glowdayz.domain.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ImageInfo {
    private final String name;
    private final Integer tagSize;
    private final String tags;
}
