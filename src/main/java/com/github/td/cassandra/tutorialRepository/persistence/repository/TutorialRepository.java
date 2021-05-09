package com.github.td.cassandra.tutorialRepository.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import com.github.td.cassandra.tutorialRepository.persistence.model.Tutorial;


public interface TutorialRepository extends CassandraRepository<Tutorial, UUID> {

    @AllowFiltering
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}