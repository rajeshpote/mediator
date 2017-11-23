package com.command.mediator.persistent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.command.mediator.pojo.BmsProfileHistoryData;

public interface BmsProfileHistoryRepository extends CrudRepository<BmsProfileHistoryData, Integer>{

	public List<BmsProfileHistoryData> findByBmServerId(Integer bmServerId);
}
