package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.model.ElectronicBook;
import ru.relex.library.db.model.ElectronicBookFile;
import ru.relex.library.services.dto.book.ElectronicBookDto;
import ru.relex.library.services.dto.book.ElectronicBookFileDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ElectronicBookStruct {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookStruct bookStruct;

    @AfterMapping
    protected void updateBook(ElectronicBook electronicBook, @MappingTarget ElectronicBookDto electronicBookDto) {
        electronicBookDto.setBookDto(
                bookStruct.toDto(
                        bookMapper.findById(electronicBook.getBooksId())
                )
        );
    }

    public abstract ElectronicBookDto toDto(ElectronicBook electronicBook);

    public abstract ElectronicBook fromDto(ElectronicBookDto electronicBookDto);

    public abstract List<ElectronicBookDto> toDto(List<ElectronicBook> electronicBooks);

    public abstract List<ElectronicBook> fromDto(List<ElectronicBookDto> electronicBookDtos);

    public abstract ElectronicBookFile fromDto(ElectronicBookFileDto fileDto);

    public abstract ElectronicBookFileDto toDto(ElectronicBookFile fileDto);
}
