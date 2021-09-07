package com.example.glowdayz.domain.folder.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class CreateFolderCommand {
    private final String title;
    private final Long userId;
}
