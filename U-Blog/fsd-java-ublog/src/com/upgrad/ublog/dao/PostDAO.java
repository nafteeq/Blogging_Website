package com.upgrad.ublog.dao;

import com.upgrad.ublog.dtos.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostDAO {
    public Post create(Post post) throws SQLException, ClassNotFoundException;
    public List<Post> findByEmailId(String emailId) throws SQLException, ClassNotFoundException;
    public List<Post> findByTag(String tag) throws SQLException, ClassNotFoundException;
    public Post findByPostId(int postId) throws SQLException, ClassNotFoundException;
    public List<String> findAllTags() throws SQLException, ClassNotFoundException;
    public boolean deleteByPostId(int postId) throws SQLException, ClassNotFoundException;
}
