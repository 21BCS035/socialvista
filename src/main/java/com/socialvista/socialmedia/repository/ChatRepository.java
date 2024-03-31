package com.socialvista.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialvista.socialmedia.models.Chat;
import com.socialvista.socialmedia.models.User;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
    
    public List<Chat> findByUsersId(Integer userId);

    @Query("select c from Chat c Where : user2 Member of c.users And : user1 Member of c.users")
    public Chat findChatByUsersId(@Param("user2") User user2 , @Param("user1") User user1);

}
