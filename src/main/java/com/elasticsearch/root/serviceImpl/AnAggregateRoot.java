package com.elasticsearch.root.serviceImpl;

import java.util.Collection;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

public class AnAggregateRoot {
	@DomainEvents
	Collection<Object> domainEvents() {
		// … return events you want to get published here
		return null;
	}

	@AfterDomainEventPublication
	void callbackMethod() {
		// … potentially clean up domain events list
	}
}
