package cms.hub.belogistics.repository;

import cms.hub.belogistics.entity.PageSections;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageSectionsRepository extends JpaRepository<PageSections, Long> {
    List<PageSections> findByPagesId(Long pageId);
}
