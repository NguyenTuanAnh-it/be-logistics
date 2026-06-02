package cms.hub.belogistics.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService {
    
    /**
     * Lưu một file và trả về URL truy cập
     */
    String storeFile(MultipartFile file);
    
    /**
     * Lưu nhiều file và trả về danh sách URL
     */
    List<String> storeFiles(List<MultipartFile> files);
    
    /**
     * Xóa file theo URL
     */
    void deleteFile(String fileUrl);
    
    /**
     * Kiểm tra file có tồn tại không
     */
    boolean fileExists(String fileUrl);
}
