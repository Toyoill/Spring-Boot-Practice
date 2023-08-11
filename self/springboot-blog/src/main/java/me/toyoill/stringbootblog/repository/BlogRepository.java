package me.toyoill.stringbootblog.repository;

import me.toyoill.stringbootblog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
