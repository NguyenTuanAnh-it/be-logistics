package cms.hub.belogistics.dto.request;

import cms.hub.belogistics.dto.DescriptionItem;
import cms.hub.belogistics.dto.TitleItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageSectionsRequest implements Serializable {

    private Long pageId;

    private List<TitleItem> title;

    private List<DescriptionItem> description;

    private List<String> images;

    private String icon;

    private Integer sortIndex;

    private Boolean active;
}
