package cms.hub.belogistics.controller;

import cms.hub.belogistics.common.ApiResponse;
import cms.hub.belogistics.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileStorageService fileStorageService;

    /**
     * Upload một ảnh
     * POST /api/v1/files/upload
     */
    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<Map<String, String>>> uploadFile(
            @RequestParam("file") MultipartFile file) {
        
        log.info("Uploading file: {}", file.getOriginalFilename());
        
        String fileUrl = fileStorageService.storeFile(file);
        
        return ResponseEntity.ok(ApiResponse.success(
            "Upload thành công",
            Map.of("url", fileUrl)
        ));
    }

    /**
     * Upload nhiều ảnh
     * POST /api/v1/files/upload-multiple
     */
    @PostMapping("/upload-multiple")
    public ResponseEntity<ApiResponse<Map<String, List<String>>>> uploadMultipleFiles(
            @RequestParam("files") List<MultipartFile> files) {
        
        log.info("Uploading {} files", files.size());
        
        List<String> fileUrls = fileStorageService.storeFiles(files);
        
        return ResponseEntity.ok(ApiResponse.success(
            "Upload thành công " + files.size() + " file(s)",
            Map.of("urls", fileUrls)
        ));
    }

    /**
     * Xóa ảnh
     * DELETE /api/v1/files?url=...
     */
    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteFile(@RequestParam String url) {
        
        log.info("Deleting file: {}", url);
        
        fileStorageService.deleteFile(url);
        
        return ResponseEntity.ok(ApiResponse.success("Xóa file thành công", null));
    }

    /**
     * Kiểm tra file tồn tại
     * GET /api/v1/files/exists?url=...
     */
    @GetMapping("/exists")
    public ResponseEntity<ApiResponse<Map<String, Boolean>>> checkFileExists(@RequestParam String url) {
        
        boolean exists = fileStorageService.fileExists(url);
        
        return ResponseEntity.ok(ApiResponse.success(
            Map.of("exists", exists)
        ));
    }
}
