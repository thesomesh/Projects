package com.app.service;

import java.util.List;

import com.app.dto.WebsiteStatusDto;

public interface WebsiteStatusService {
public List<WebsiteStatusDto> getWebsiteStatus(Long id);
}
