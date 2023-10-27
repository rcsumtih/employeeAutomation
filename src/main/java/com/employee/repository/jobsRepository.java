package com.employee.repository;

import com.employee.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jobsRepository extends JpaRepository<Jobs,Long> {
}
