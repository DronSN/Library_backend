package ru.relex.library.db.model;

public class ElectronicBookFile {

    private byte[] file;

    private int electronicBookId;

    private String fileType;

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
