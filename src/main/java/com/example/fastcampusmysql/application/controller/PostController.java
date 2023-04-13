package com.example.fastcampusmysql.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.dto.PostCommand;
import com.example.fastcampusmysql.domain.post.service.PostReadService;
import com.example.fastcampusmysql.domain.post.service.PostWriteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
	final private PostWriteService postWriteService;
	final private PostReadService postReadService;

	@PostMapping()
	public Long create(PostCommand command) {
		return postWriteService.create(command);
	}

	@PostMapping("/daily-post-counts")
	public List<DailyPostCount> getDailyPostCounts(@RequestBody DailyPostCountRequest request) {
		System.out.println(request);
		return postReadService.getDailyPostCount(request);
	}

}