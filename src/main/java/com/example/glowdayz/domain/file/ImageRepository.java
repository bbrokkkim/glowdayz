package com.example.glowdayz.domain.file;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long>{

    public List<Image> findTop10ByOrderByTagSizeDesc();

}
