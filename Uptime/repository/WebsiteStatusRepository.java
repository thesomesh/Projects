package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Website;
import com.app.entities.WebsiteStatus;

public interface WebsiteStatusRepository extends JpaRepository<WebsiteStatus, Long> {
	List<WebsiteStatus> findByWebsite(Website web);
}
