package com.example.spring01.repository;

import com.example.spring01.model.Content;
import com.example.spring01.model.Status;
import com.example.spring01.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList =new ArrayList<>();
    public ContentCollectionRepository(){

    }
    public  List<Content> findAll(){
        return contentList;
    }
     public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c->c.id().equals(id)).findFirst();
     }

     @PostConstruct
    private  void init(){
        Content c=new Content(1,"my first post",
                "My first bloo", Status.IDEA,
                Type.ARTICLE, LocalDateTime.now(),null,"" +
                "");
        contentList.add(c);
     }

    public void save(Content content) {
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(c->c.id().equals(id)).count()==1;
    }
}
