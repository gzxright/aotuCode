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
@RequestMapping("/brokerMessageLog")
public interface BrokerMessageLogFeign {

    /***
     * BrokerMessageLog分页条件搜索实现
     * @param brokerMessageLog
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) BrokerMessageLog brokerMessageLog, @PathVariable  int page, @PathVariable  int size);

    /***
     * BrokerMessageLog分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param brokerMessageLog
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<BrokerMessageLog>> findList(@RequestBody(required = false) BrokerMessageLog brokerMessageLog);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable  id);

    /***
     * 修改BrokerMessageLog数据
     * @param brokerMessageLog
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody BrokerMessageLog brokerMessageLog,@PathVariable  id);

    /***
     * 新增BrokerMessageLog数据
     * @param brokerMessageLog
     * @return
     */
    @PostMapping
    Result add(@RequestBody BrokerMessageLog brokerMessageLog);

    /***
     * 根据ID查询BrokerMessageLog数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<BrokerMessageLog> findById(@PathVariable  id);

    /***
     * 查询BrokerMessageLog全部数据
     * @return
     */
    @GetMapping
    Result<List<BrokerMessageLog>> findAll();
}