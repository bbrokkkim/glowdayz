package com.example.glowdayz.domain.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ShowImageListCommand {
    private final Long userId;
    private final String folderName;
}
