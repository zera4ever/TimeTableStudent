package org.itstep.dao;

import java.util.List;

import org.itstep.dao.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student, String> {

	@Query(value = "SELECT * FROM STUDENTS WHERE GROUP_NAME = ?1", nativeQuery = true)
	public List<Student> findStudentsByGroup(String group);

	@Query(value = "SELECT * FROM STUDENTS INNER JOIN GROUPS ON "
			+ "STUDENTS.GROUP_NAME =  GROUPS.GROUP_NAME WHERE GROUPS.COURSE = ?1", nativeQuery = true)
	public List<Student> findAllStudentsByCourse(Integer course);
}
