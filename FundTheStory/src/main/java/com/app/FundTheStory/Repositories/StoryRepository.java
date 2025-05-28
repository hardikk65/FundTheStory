package com.app.FundTheStory.Repositories;


import com.app.FundTheStory.Entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {

}
