package me.toyoill.stringbootblog.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "id", updatable= false)
    private long id;

    @Column(name= "title", nullable= false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
