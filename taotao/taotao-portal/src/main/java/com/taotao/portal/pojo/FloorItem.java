package com.taotao.portal.pojo;

import java.util.List;

/**
 * 封装楼层信息
 */
public class FloorItem {
    //楼层编号
    private Integer floorId;
    //楼层名称
    private String cateName;
    //所有左侧分类
    private List<LeftCate> leftCateList;
    //所有tab分类
    private List<TabCate> tabCateList;
    //右侧品牌广告
    private List<BrandAd> brandAdList;

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<LeftCate> getLeftCateList() {
        return leftCateList;
    }

    public void setLeftCateList(List<LeftCate> leftCateList) {
        this.leftCateList = leftCateList;
    }

    public List<TabCate> getTabCateList() {
        return tabCateList;
    }

    public void setTabCateList(List<TabCate> tabCateList) {
        this.tabCateList = tabCateList;
    }

    public List<BrandAd> getBrandAdList() {
        return brandAdList;
    }

    public void setBrandAdList(List<BrandAd> brandAdList) {
        this.brandAdList = brandAdList;
    }

    //左侧列表分类
    public static class LeftCate {
        //名称
        private String name;
        //链接
        private String url;

        public LeftCate(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    //中间标签分类
    public static class TabCate {
        //名称
        private String name;
        //对于Data_Tabs.json中的id
        private Integer tabId;

        public TabCate(String name, Integer tabId) {
            this.name = name;
            this.tabId = tabId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getTabId() {
            return tabId;
        }

        public void setTabId(Integer tabId) {
            this.tabId = tabId;
        }
    }

    //右侧品牌广告
    public static class BrandAd{
        private String title;
        private String url;
        private String imageUrl;

        public BrandAd(String title, String url, String imageUrl) {
            this.title = title;
            this.url = url;
            this.imageUrl = imageUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

}
