package com.DriveAuto.adminservice.model;



import org.springframework.data.annotation.Id;


public class File {
    @Id
    private String id;
    private String name;
    private String description;
    private String filePath;

    public File() {
    }

    public File(String id, String name, String description, String filePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.filePath = filePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
