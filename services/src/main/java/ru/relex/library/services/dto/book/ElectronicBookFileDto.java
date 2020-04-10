package ru.relex.library.services.dto.book;

import ru.relex.library.services.constraint.ConstraintMessage;

import javax.validation.constraints.Positive;

public class ElectronicBookFileDto {

    private byte[] file;

    @Positive(message = ConstraintMessage.Field.ELECTRONIC_BOOK_ID + ConstraintMessage.Constraint.NOT_POSITIVE)
    private int electronicBookId;

    private String fileType;

    public ElectronicBookFileDto(byte[] file, int id) {
        this.file = file;
        this.electronicBookId = id;
    }

    //Constructor for compiler and spring
    public ElectronicBookFileDto() {}

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public int getElectronicBookId() {
        return electronicBookId;
    }

    public void setElectronicBookId(int electronicBookId) {
        this.electronicBookId = electronicBookId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
