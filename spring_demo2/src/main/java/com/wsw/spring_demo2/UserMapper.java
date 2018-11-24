package com.wsw.spring_demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<User,Long> {

    @Query(value = "SELECT COUNT(*) FROM t_user where name=?1",nativeQuery=true)
    int selectCount(String name);
}
