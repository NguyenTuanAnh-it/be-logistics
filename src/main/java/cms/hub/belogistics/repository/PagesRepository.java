package cms.hub.belogistics.repository;

import cms.hub.belogistics.entity.Pages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagesRepository extends JpaRepository<Pages, Long> {
    Pages findByUrl(String url);
}
