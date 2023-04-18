package in.practice.demo.entity;

import org.springframework.data.annotation.Id;

public class Tutorial {

    @Id
    private int id;

    private String title;

    private String description;

    public Tutorial() {}

    public Tutorial(int id) {
        this.title = "title-"+id;
        this.description = "description-"+id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
