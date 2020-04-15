package com.hz.kafka2mysql.repository;

import com.hz.kafka2mysql.domain.ReportContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportContentRepository extends JpaRepository<ReportContent,Integer> {
}
