package ru.relex.library.services.service;

import ru.relex.library.services.dto.booksmoving.WaitListDto;

import javax.validation.Valid;
import java.util.List;

public interface IWaitListService {

  List<WaitListDto> findWaitLists(String search);

  WaitListDto findById(int id);

  WaitListDto create(@Valid WaitListDto waitListDto);

  WaitListDto update(@Valid WaitListDto waitListDto);

  void remove(int waitListId);

}
