package com.macro.garden.web;

import com.macro.garden.domain.Category;
import com.macro.garden.repository.CategoryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macro on 2018/7/27.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody Category category) {
        if (StringUtils.isEmpty(category.getParentId())) {
            categoryRepository.save(category);
        } else {
            Category parentCategory = categoryRepository.findOne(category.getParentId());
            if (parentCategory == null) {
                return "failed";
            } else {
                category.setParentId(parentCategory.getId());
                List<Category.Ancestor> ancestors = generateAncestors(parentCategory);
                category.setAncestors(ancestors);
                categoryRepository.save(category);
            }
        }
        return "success";
    }

    @ApiOperation("更新操作，可以更改父子关系")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@RequestBody Category category) {
        Category oldCategory = categoryRepository.findOne(category.getId());
        if (!hasEqualParent(oldCategory.getParentId(), category.getParentId())) {
            //修该本分类信息
            Category parentCategory = categoryRepository.findOne(category.getParentId());
            if (parentCategory != null) {
                category.setAncestors(generateAncestors(parentCategory));
                //修改本分类的子分类继承关系
                Query query = new Query();
                query.addCriteria(Criteria.where("ancestors.id").is(category.getId()));
                List<Category> categories = mongoTemplate.find(query, Category.class);
                for (Category cat : categories) {
                    List<Category.Ancestor> ancestors = generateAncestors(category);
                    cat.setAncestors(ancestors);
                    Query tempQuery = new Query();
                    tempQuery.addCriteria(Criteria.where("_id").is(cat.getId()));
                    Update update = new Update().set("ancestors", cat.getAncestors());
                    mongoTemplate.updateFirst(query, update, Category.class);
                }
            } else {
                category.setParentId(null);
            }
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(category.getId()));
        Update update = getCategoryUpdate(category);
        mongoTemplate.updateFirst(query, update, Category.class);
        return "success";
    }

    private Update getCategoryUpdate(Category category) {
        Update update = new Update();
        update.set("parentId", category.getParentId());
        update.set("slug", category.getSlug());
        update.set("name", category.getName());
        update.set("description", category.getDescription());
        if (!CollectionUtils.isEmpty(category.getAncestors())) {
            update.set("ancestors", category.getAncestors());
        }
        return update;
    }

    private boolean hasEqualParent(String oldParentId, String newParentId) {
        boolean result;
        if (oldParentId != null) {
            result = oldParentId.equals(newParentId);
        } else {
            result = newParentId == null;
        }
        return result;
    }

    /**
     * 生产父级分类
     *
     * @param parentCategory 直接父级分类
     * @return 父级分类从叶子到根
     */
    private List<Category.Ancestor> generateAncestors(Category parentCategory) {
        List<Category.Ancestor> ancestors = new ArrayList<>();
        while (parentCategory != null) {
            Category.Ancestor ancestor = new Category.Ancestor();
            ancestor.setId(parentCategory.getId());
            ancestor.setName(parentCategory.getName());
            ancestor.setSlug(parentCategory.getSlug());
            ancestors.add(ancestor);
            parentCategory = getParentCategory(parentCategory.getParentId());
        }
        return ancestors;
    }

    private Category getParentCategory(String parentId) {
        if (StringUtils.isEmpty(parentId)) {
            return null;
        } else {
            return categoryRepository.findOne(parentId);
        }
    }

}
