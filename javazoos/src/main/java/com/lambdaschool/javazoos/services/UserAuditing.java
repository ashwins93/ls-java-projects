package com.lambdaschool.javazoos.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class UserAuditing implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("SYSTEM");
	}

}
