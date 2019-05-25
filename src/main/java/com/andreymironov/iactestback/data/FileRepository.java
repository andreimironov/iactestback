package com.andreymironov.iactestback.data;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FileRepository extends CrudRepository<SubDir, UUID> {
}
