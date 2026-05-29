package cms.hub.belogistics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CellItem implements Serializable {
    private String text;
    private Integer colspan; // gộp bao nhiêu cột
    private Integer rowspan; // gộp bao nhiêu dòng
    private Integer startRow; // dòng bắt đầu (0-based)
}