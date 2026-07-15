package com.winemood.winemood_backend.constants;

import java.util.Set;

public final class FileConstants {
    public static final long MAX_AVATAR_SIZE = 10 * 1024 * 1024;

    public static final Set<String> ALLOWED_IMAGE_TYPES = Set.of(
            "image/jpeg",
            "image/png",
            "image/webp"
    );

    private FileConstants() {
    }
}
