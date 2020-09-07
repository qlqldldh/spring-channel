package com.jinsu.first.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinsu.first.vo.StudentVO;

@Repository
public interface StudentRepository extends JpaRepository<StudentVO,Integer>{

}
