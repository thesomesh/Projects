package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.WebsiteStatusDto;
import com.app.service.WebsiteStatusService;

@CrossOrigin
@RequestMapping("/users")
@RestController
public class WebsiteStatusConrtoller {
@Autowired
private WebsiteStatusService websiteStatusService;
@GetMapping("/monitoring-dashboard/{id}")
public ResponseEntity<List<WebsiteStatusDto>> getMethodName(@PathVariable Long id) {
    return ResponseEntity.ok(websiteStatusService.getWebsiteStatus(id));
}

}
