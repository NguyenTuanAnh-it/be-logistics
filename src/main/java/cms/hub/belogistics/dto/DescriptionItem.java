package cms.hub.belogistics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionItem implements Serializable {
    private String type; // "text", "table", "warning", "note", "image"
    private String icon;
    private String img; // đường dẫn ảnh
    private String text;
    private List<String> boldParts; // các phần text cần in đậm (áp dụng cho type="text")
    private List<String> headers; // header cột
    private List<List<CellItem>> cellRows; // dữ liệu bảng (hỗ trợ merged cells)
}
