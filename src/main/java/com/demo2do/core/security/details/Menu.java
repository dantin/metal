package com.demo2do.core.security.details;

import java.util.List;

/**
 * Menu object
 */
public class Menu {

    private String id;

    private String key;

    private String name;

    private String description;

    private String icon;

    private String url;

    private String authority;

    private List<Menu> submenus;

    /**
     * default constructor
     */
    public Menu() {

    }

    /**
     * constructor using id
     *
     * @param id
     */
    public Menu(String id) {
        this.id = id;
    }

    /**
     * get the last part after '-' of id as the alias
     *
     * @return
     */
    public String getAlias() {
        return this.id.substring(id.lastIndexOf("-") + 1);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @return the submenus
     */
    public List<Menu> getSubmenus() {
        return submenus;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * @param submenus
     */
    public void setSubmenus(List<Menu> submenus) {
        this.submenus = submenus;
    }
}
