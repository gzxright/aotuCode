package com.changgou.content.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/configTagsRelation")
public interface ConfigTagsRelationFeign {

    /***
     * ConfigTagsRelation分页条件搜索实现
     * @param configTagsRelation
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) ConfigTagsRelation configTagsRelation, @PathVariable  int page, @PathVariable  int size);

    /***
     * ConfigTagsRelation分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param configTagsRelation
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<ConfigTagsRelation>> findList(@RequestBody(required = false) ConfigTagsRelation configTagsRelation);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改ConfigTagsRelation数据
     * @param configTagsRelation
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody ConfigTagsRelation configTagsRelation,@PathVariable  id);

    /***
     * 新增ConfigTagsRelation数据
     * @param configTagsRelation
     * @return
     */
    @PostMapping
    Result add(@RequestBody ConfigTagsRelation configTagsRelation);

    /***
     * 根据ID查询ConfigTagsRelation数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<ConfigTagsRelation> findById(@PathVariable  id);

    /***
     * 查询ConfigTagsRelation全部数据
     * @return
     */
    @GetMapping
    Result<List<ConfigTagsRelation>> findAll();
}