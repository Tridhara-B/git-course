package com.ey.cms.Repository;

import com.ey.cms.Entity.CompEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<CompEntity,Long> {
}
