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
@RequestMapping("/language")
public interface LanguageFeign {

    /***
     * Language分页条件搜索实现
     * @param language
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Language language, @PathVariable  int page, @PathVariable  int size);

    /***
     * Language分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param language
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Language>> findList(@RequestBody(required = false) Language language);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改Language数据
     * @param language
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Language language,@PathVariable  id);

    /***
     * 新增Language数据
     * @param language
     * @return
     */
    @PostMapping
    Result add(@RequestBody Language language);

    /***
     * 根据ID查询Language数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Language> findById(@PathVariable  id);

    /***
     * 查询Language全部数据
     * @return
     */
    @GetMapping
    Result<List<Language>> findAll();
}