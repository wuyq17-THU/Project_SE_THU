package mysqlData.repository;

import mysqlData.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    public User findByUser_name(String user_name);
}

