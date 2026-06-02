package cms.hub.belogistics.service.impl;

import cms.hub.belogistics.common.config.FileStorageProperties;
import cms.hub.belogistics.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {

    private final FileStorageProperties fileStorageProperties;

    @Override
    public String storeFile(MultipartFile file) {
        // Validate file
        validateFile(file);

        // Tạo tên file unique
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = getFileExtension(originalFileName);
        String storedFileName = UUID.randomUUID().toString() + "." + fileExtension;

        try {
            // Tạo thư mục nếu chưa tồn tại
            Path uploadPath = Paths.get(fileStorageProperties.getUploadDir());
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
                log.info("Created upload directory: {}", uploadPath);
            }

            // Lưu file
            Path targetLocation = uploadPath.resolve(storedFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Trả về URL
            String fileUrl = fileStorageProperties.getBaseUrl() + "/" + storedFileName;
            log.info("Stored file: {} -> {}", originalFileName, fileUrl);
            
            return fileUrl;

        } catch (IOException ex) {
            log.error("Could not store file {}. Error: {}", originalFileName, ex.getMessage());
            throw new RuntimeException("Could not store file " + originalFileName + ". Please try again!", ex);
        }
    }

    @Override
    public List<String> storeFiles(List<MultipartFile> files) {
        List<String> fileUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            fileUrls.add(storeFile(file));
        }
        return fileUrls;
    }

    @Override
    public void deleteFile(String fileUrl) {
        try {
            // Lấy tên file từ URL
            String fileName = extractFileNameFromUrl(fileUrl);
            if (fileName == null) {
                log.warn("Could not extract filename from URL: {}", fileUrl);
                return;
            }

            Path filePath = Paths.get(fileStorageProperties.getUploadDir()).resolve(fileName);
            boolean deleted = Files.deleteIfExists(filePath);
            
            if (deleted) {
                log.info("Deleted file: {}", filePath);
            } else {
                log.warn("File not found for deletion: {}", filePath);
            }
        } catch (IOException ex) {
            log.error("Could not delete file {}. Error: {}", fileUrl, ex.getMessage());
            throw new RuntimeException("Could not delete file. Please try again!", ex);
        }
    }

    @Override
    public boolean fileExists(String fileUrl) {
        try {
            String fileName = extractFileNameFromUrl(fileUrl);
            if (fileName == null) {
                return false;
            }
            Path filePath = Paths.get(fileStorageProperties.getUploadDir()).resolve(fileName);
            return Files.exists(filePath);
        } catch (Exception e) {
            log.error("Error checking file existence: {}", fileUrl, e);
            return false;
        }
    }

    private void validateFile(MultipartFile file) {
        // Kiểm tra file rỗng
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // Kiểm tra loại file
        String contentType = file.getContentType();
        if (contentType == null || !Arrays.asList(fileStorageProperties.getAllowedTypes()).contains(contentType)) {
            throw new IllegalArgumentException(
                "File type not allowed. Allowed types: " + 
                String.join(", ", fileStorageProperties.getAllowedTypes())
            );
        }

        // Kiểm tra kích thước
        if (file.getSize() > fileStorageProperties.getMaxFileSize()) {
            throw new IllegalArgumentException(
                "File size exceeds maximum allowed size of " + 
                (fileStorageProperties.getMaxFileSize() / (1024 * 1024)) + "MB"
            );
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "jpg"; // Default extension
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }

    private String extractFileNameFromUrl(String fileUrl) {
        if (fileUrl == null || !fileUrl.startsWith(fileStorageProperties.getBaseUrl())) {
            return null;
        }
        return fileUrl.substring(fileStorageProperties.getBaseUrl().length() + 1);
    }
}
