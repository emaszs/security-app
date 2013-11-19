package nortal.lab.security.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import nortal.lab.security.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    @Autowired
    private DataSource dataSource;
    
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Returns user by specified email or null if not found 
     */
    @Transactional
    public User getUserByEmail(final String email) {
    	try {
    		return (User) em.createQuery("from User where email = :email").setParameter("email", email).getSingleResult();
    	} catch (NoResultException e) {
    		return null;
    	}
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    /**
     * For some reasons, someone left plain JDBC implementation - which is very very bad.
     * @param lastName
     * @return
     */
    public List<User> filterUsersByEmail(final String lastName) {

        // TODO: user hibernate query to remove SQL injection vulnerability

        List<User> resultList = new ArrayList<>();
        
        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            try (Statement statement = connection.createStatement()) {
                    
                String query = "select * from insecure_user";
                
                if (lastName != null && !lastName.isEmpty()) {
                    query = query + " where email like '%" + lastName + "%'";
                }

                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    User user = new User();
                    user.setId(result.getLong("id"));
                    user.setEmail(result.getString("email"));
                    user.setFirstName(result.getString("first_name"));
                    user.setLastName(result.getString("last_name"));
                    user.setPasswordHash(result.getString("password_hash"));

                    resultList.add(user);
                }
                result.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
        return resultList;
    }

    @Transactional
    public void save(final User user) {
        em.persist(user);
    }
}
