package cms.hub.belogistics.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "file.storage")
@Getter
@Setter
public class FileStorageProperties {
    
    /**
     * Đường dẫn thư mục gốc để lưu file
     * - Local: D:/Gallery/images
     * - Production: /var/www/uploads hoặc S3 bucket
     */
    private String uploadDir;
    
    /**
     * URL base để truy cập file
     * - Local: http://localhost:8111/files
     * - Production: https://api.yourdomain.com/files hoặc CDN URL
     */
    private String baseUrl;
    
    /**
     * Các loại file cho phép
     */
    private String[] allowedTypes = {
        "image/jpeg", 
        "image/png", 
        "image/gif", 
        "image/webp"
    };
    
    /**
     * Kích thước tối đa (bytes)
     */
    private long maxFileSize = 10 * 1024 * 1024; // 10MB
}
