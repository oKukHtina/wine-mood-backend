package com.winemood.winemood_backend.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.winemood.winemood_backend.constants.ExceptionMessageConstant;
import com.winemood.winemood_backend.constants.FileConstants;
import com.winemood.winemood_backend.dto.response.UploadedImageResultDto;
import com.winemood.winemood_backend.exceptions.FileUploadException;
import com.winemood.winemood_backend.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    @Override
    public UploadedImageResultDto upload(MultipartFile image) {
        validateImage(image);

        try {
            Map<String, Object> result = cloudinary.uploader().upload(
                    image.getBytes(),
                    ObjectUtils.emptyMap()
            );
            return new UploadedImageResultDto(
                    (String) result.get("secure_url"),
                    (String) result.get("public_id")
            );

        } catch (IOException e) {
            throw new FileUploadException(
                    ExceptionMessageConstant.FILE_UPLOAD_FAILED,
                    e
            );
        }
    }

    @Override
    public void delete(String publicId) {
        try {
            Map<String, Object> destroyResult =
                    cloudinary.uploader().destroy(
                            publicId,
                            ObjectUtils.emptyMap()
                    );
            String status = (String) destroyResult.get("result");

            if (!"ok".equals(status) && !"not found".equals(status)) {
                throw new FileUploadException(ExceptionMessageConstant.FILE_DELETE_FAILED);
            }

        } catch (IOException e) {
            throw new FileUploadException(
                    ExceptionMessageConstant.FILE_DELETE_FAILED,
                    e
            );
        }
    }

    private void validateImage(MultipartFile image) {
        if (image.isEmpty()) {
            throw new FileUploadException(
                    ExceptionMessageConstant.FILE_IS_EMPTY
            );
        }

        String contentType = image.getContentType();

        if (!FileConstants.ALLOWED_IMAGE_TYPES.contains(contentType)) {
            throw new FileUploadException(
                    ExceptionMessageConstant.UNSUPPORTED_IMAGE_TYPE
            );
        }

        if (image.getSize() > FileConstants.MAX_AVATAR_SIZE) {
            throw new FileUploadException(ExceptionMessageConstant.FILE_TOO_LARGE);
        }
    }
}
