package cms.hub.belogistics.entity;

import cms.hub.belogistics.common.BaseEntity;
import cms.hub.belogistics.dto.DescriptionItem;
import cms.hub.belogistics.dto.TitleItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "page_sections")
public class PageSections extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "page_id")
    private Pages pages;

    @Column(name = "title", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<TitleItem> title;

    @Column(name = "description", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<DescriptionItem> description;

    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> images;

    @Column(name = "sort_index")
    private Integer sortIndex;

    @Column(name = "active")
    private Boolean active;

}
