package com.upgrad.ublog.dao;

import com.upgrad.ublog.db.Database;
import com.upgrad.ublog.dtos.Post;
import com.upgrad.ublog.dtos.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 3.19. Implement the PostsDAO interface and implement this class using the Singleton pattern.
 *  (Hint: Should have a private no-arg Constructor, a private static instance attribute of type
 *  PostDAOImpl and a public static getInstance() method which returns the instance attribute.)
 * TODO: 3.20. Define the following methods and return null for each of them. You will provide a
 *  proper implementation for each of these methods, later in this project.
 *  a. findByEmailId()
 *  b. findByTag()
 *  c. findAllTags()
 *  d. findByPostId()
 *  e. deleteByPostId() (return false for this method for now)
 * TODO: 3.21. create() method should take post details as input and insert these details into
 *  the POST table. Return the same Post object which was passed as an input argument.
 *  (Hint: You should get the connection using the DatabaseConnection class)
 */
public class PostDAOImpl implements PostDAO{

    private static PostDAOImpl instance;

    private PostDAOImpl(){

    }
    public static PostDAOImpl getInstance() {
        if(instance == null){
            instance = new PostDAOImpl();
        }
        return instance;
    }

    @Override
    public Post create(Post post) throws SQLException, ClassNotFoundException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO user (postId, emailId) VALUES (" +
                post.getPostId() + ", '" +
                post.getEmailId() + "', " +
                ")";
        statement.executeUpdate(sql);
        return post;
    }

    @Override
    public List<Post> findByEmailId(String emailId) throws SQLException, ClassNotFoundException {
        List<Post> post = new ArrayList<>();
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Post WHERE emailId = " + emailId;


        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Post temp = new Post();
            temp.setPostId(resultSet.getInt("postId"));
         //   temp.setTimestamp(resultSet.getTimestamp("title"));
            temp.setTitle(resultSet.getString("title"));
            temp.setTag(resultSet.getString("tag"));
            temp.setEmailId(resultSet.getString("EmailId"));
            temp.setDescription(resultSet.getString("Description"));
            post.add(temp);

        }
        return post;
    }

    @Override
    public List<Post> findByTag(String tag) throws SQLException, ClassNotFoundException {
        List<Post> post = new ArrayList<>();
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Post WHERE tag = " + tag;


        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Post temp = new Post();
            temp.setPostId(resultSet.getInt("postId"));
            //   temp.setTimestamp(resultSet.getTimestamp("title"));
            temp.setTitle(resultSet.getString("title"));
            temp.setTag(resultSet.getString("tag"));
            temp.setEmailId(resultSet.getString("EmailId"));
            temp.setDescription(resultSet.getString("Description"));
            post.add(temp);

        }
        return post;
    }

    @Override
    public Post findByPostId(int postId) throws SQLException, ClassNotFoundException {

        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM post WHERE postId = " + postId;


        ResultSet resultSet = statement.executeQuery(sql);
        Post post = new Post();

        if (resultSet.next()) {

            post.setPostId(resultSet.getInt("PostId"));
            post.setEmailId(resultSet.getString("EmailId"));
            post.setTitle(resultSet.getString("Title"));
            post.setTag(resultSet.getString("Tag"));
        }

        return post;
    }

    @Override
    public List<String> findAllTags() throws SQLException, ClassNotFoundException {
        List<String> postList = new ArrayList<>();
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT tag FROM Post";


        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            Post temp = new Post();
            temp.setPostId(resultSet.getInt("postId"));
            //   temp.setTimestamp(resultSet.getTimestamp("title"));
            temp.setTitle(resultSet.getString("title"));
            temp.setTag(resultSet.getString("tag"));
            temp.setEmailId(resultSet.getString("EmailId"));
            temp.setDescription(resultSet.getString("Description"));
            postList.add(temp.getTag());

        }
        return postList;
    }

    @Override
    public boolean deleteByPostId(int postId) throws SQLException, ClassNotFoundException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM post WHERE postId = " + postId;
        String sql1 = "SELECT * FROM post WHERE postId = " + postId;
        statement.executeUpdate(sql);
        if(statement.executeQuery(sql1) == null){
            return true;
        }
        return false;
    }
/**
 * TODO: 4.1. Implement findByEmailId() method which takes email id as an input parameter and
 *  returns all the posts corresponding to the email id from the Post table defined
 *  in the database.
 */

/**
 * TODO: 4.4. Implement the deleteByPostId() method which takes post id as an input argument and delete
 *  the corresponding post from the database. If the post was deleted successfully, then return true,
 *  otherwise, return false. (Hint: The executeUpdate() method returns the count of rows affected by the
 *  query.)
 * TODO: 4.5. Implement the findByPostId() method which takes post id as an input argument and return the
 *  post details from the database. If no post exists for the given id, then return a Post object
 *  without setting any of its attributes.
 */

/**
 * TODO: 4.8. Implement findAllTags() method which returns a list of all tags in the POST table.
 * TODO: 4.9. Implement findByTag() method which takes "tag" as an input argument and returns all the
 *  posts corresponding to the input "tag" from the POST table defined in the database.
 */


}
