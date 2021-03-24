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
@RequestMapping("/filmText")
public interface FilmTextFeign {

    /***
     * FilmText分页条件搜索实现
     * @param filmText
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) FilmText filmText, @PathVariable  int page, @PathVariable  int size);

    /***
     * FilmText分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param filmText
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<FilmText>> findList(@RequestBody(required = false) FilmText filmText);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改FilmText数据
     * @param filmText
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody FilmText filmText,@PathVariable  id);

    /***
     * 新增FilmText数据
     * @param filmText
     * @return
     */
    @PostMapping
    Result add(@RequestBody FilmText filmText);

    /***
     * 根据ID查询FilmText数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<FilmText> findById(@PathVariable  id);

    /***
     * 查询FilmText全部数据
     * @return
     */
    @GetMapping
    Result<List<FilmText>> findAll();
}