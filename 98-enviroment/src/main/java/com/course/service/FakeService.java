package com.course.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class FakeService implements IService {

	@Override
	public String getData() {
		return "我是假的";
	}

}
