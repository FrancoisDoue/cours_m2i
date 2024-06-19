package exercice_6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    private String fileName;

    public Image() {}
    public Image(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return path + "/" + fileName;
    }
}
