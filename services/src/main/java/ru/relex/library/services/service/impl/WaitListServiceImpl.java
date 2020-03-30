package ru.relex.library.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.WaitListMapper;
import ru.relex.library.services.dto.booksmoving.WaitListDto;
import ru.relex.library.services.mapstruct.WaitListStruct;
import ru.relex.library.services.service.IWaitListService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class WaitListServiceImpl implements IWaitListService {

  private final WaitListMapper waitListMapper;
  private final WaitListStruct waitListStruct;

  @Autowired
  public WaitListServiceImpl(WaitListMapper waitListMapper, WaitListStruct waitListStruct) {
    this.waitListMapper = waitListMapper;
    this.waitListStruct = waitListStruct;
  }

  @Override
  public List<WaitListDto> findWaitLists(final String search) {
    var waitLists = waitListMapper.getWaitLists();
    return waitListStruct.toDto(waitLists);
  }

  @Override
  public WaitListDto findById(int id) {
    var waitList = waitListMapper.findById(id);
    return waitListStruct.toDto(waitList);
  }

  @Override
  public WaitListDto create(@Valid final WaitListDto waitListDto) {
    var waitList = waitListStruct.fromDto(waitListDto);
    waitListMapper.insert(waitList);
    return waitListStruct.toDto(waitList);
  }

  @Override
  public WaitListDto update(@Valid final WaitListDto waitListDto) {
    var waitList = waitListStruct.fromDto(waitListDto);
    waitListMapper.update(waitList);
    return waitListStruct.toDto(waitList);
  }

  @Override
  public void remove(final int waitListId) {
    waitListMapper.delete(waitListId);
  }
}
