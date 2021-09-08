package com.example.glowdayz.domain.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class ShowFolderListCommand {
    private final Long userId;
}
