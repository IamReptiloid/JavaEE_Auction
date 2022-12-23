package ru.rsreu.auction.data;

public class Auction {
    private Long id;
    private Long idCreator;
    private String description;
    private String name;
    private String status;

    public Auction(Long id, Long idCreator, String description, String name, String status) {
        this.id = id;
        this.idCreator = idCreator;
        this.description = description;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(Long idCreator) {
        this.idCreator = idCreator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
