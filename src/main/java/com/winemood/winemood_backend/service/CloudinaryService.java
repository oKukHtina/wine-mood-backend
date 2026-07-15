package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.UploadedImageResultDto;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    UploadedImageResultDto upload(MultipartFile image);

    void delete(String publicId);
}
