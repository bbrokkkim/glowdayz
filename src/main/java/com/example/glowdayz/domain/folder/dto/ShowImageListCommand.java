package com.example.glowdayz.domain.folder.dto;

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
