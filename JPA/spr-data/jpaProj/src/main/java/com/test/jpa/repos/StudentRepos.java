package com.test.jpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.jpa.vo.StudentVO;

@Repository
public interface StudentRepos extends JpaRepository<StudentVO, Integer> {

	@Query("select s from StudentVO s where s.studid=:studid") // implement by using @Query
	StudentVO selectStudByID(@Param("studid") int studid); // have to use @Param to bind parameters
}
