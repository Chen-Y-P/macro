package com.macro.garden.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
public class Category {

    /**
     * id : 6a5b1476238d3b4dd5000048
     * slug : gardening-tools
     * ancestors : [{"name":"Home","id":"8b87fb1476238d3b4dd50003","slug":"home"},{"name":"Outdoors","id":"9a9fb1476238d3b4dd500001","slug":"outdoors"}]
     * parentId : 9a9fb1476238d3b4dd500001
     * name : Gardening Tools
     * description : Gardening gadgets galore!
     */
    @Id
    private String id;
    private String slug;
    private String parentId;
    private String name;
    private String description;
    private List<Ancestor> ancestors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public List<Ancestor> getAncestors() {
        return ancestors;
    }

    public void setAncestors(List<Ancestor> ancestors) {
        this.ancestors = ancestors;
    }

    public static class Ancestor {
        /**
         * name : Home
         * id : 8b87fb1476238d3b4dd50003
         * slug : home
         */

        private String name;
        private String id;
        private String slug;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }
}
