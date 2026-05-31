package cms.hub.belogistics.dto.request;

import cms.hub.belogistics.dto.DescriptionItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageSectionsRequest implements Serializable {

    private Long pageId;

    private String title;

    private List<DescriptionItem> description;

    private List<String> images;

    private Integer sortIndex;

    private Boolean active;
}
