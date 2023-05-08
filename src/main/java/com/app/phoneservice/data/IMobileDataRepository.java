package com.app.phoneservice.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IMobileDataRepository extends CrudRepository<MobileData, Integer> {

    Optional<MobileData> findFirst1ByNameAndIsAvailable(String name, boolean isAvailable);
    Optional<MobileData> findFirst1ByNameAndOwnerAndIsAvailable(String name, String owner, boolean isAvailable);

    List<MobileData> findByName(String name);
    List<MobileData> findAll();
}
