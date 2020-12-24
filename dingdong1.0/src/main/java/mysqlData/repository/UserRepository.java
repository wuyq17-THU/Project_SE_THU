package mysqlData.repository;

import mysqlData.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    public User findByUser_name(String user_name);
}

