package com.rockbite.bootcamp.item;

/**
 * Describes a type of an item
 */
public class ItemType {
    /**
     * Unique identifier
     */
    private int id;
    /**
     * Item name
     */
    private String name;
    /**
     * Item description
     */
    private String description;
    /**
     * Icon URL
     */
    private String iconURL;
    /**
     * Max possible count
     */
    private int maxCount;

    public ItemType(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getIconURL() { return iconURL; }

    public void setIconURL(String iconURL) { this.iconURL = iconURL; }

    public int getMaxCount() { return maxCount; }

    public void setMaxCount(int maxCount) { this.maxCount = maxCount; }
}
