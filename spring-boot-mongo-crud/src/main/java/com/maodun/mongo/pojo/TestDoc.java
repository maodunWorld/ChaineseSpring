package com.maodun.mongo.pojo;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author tongjian
 * @version 1.0
 * @date 2020/5/12 16:35
 */

// lombok简化代码注解
@Data
// 代表pojo对应一个Mongo表 collection = "指定表名字" collation = "指定排序方式"
@Document
public class TestDoc {
    // @Id 映射为mongodb默认字段 _id
    private String id;

    //    @Field("doc_code") 指定映射到某个字段
    @Indexed(unique = true) // 指定索引 唯一，背后创建，是否稀疏，过期时间，详细可以看注释
    private String docCode;

    //    @Field("doc_text")
    private String docText;

    //    @Field("create_time")
    @CreatedDate // spring-data的注解
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //    @Field("creator_id")
    @CreatedBy
    private String creatorId;

    //    @Field("modify_time")
    @LastModifiedDate
    private Date modifyTime;

    //    @Field("modifier_id")
    @LastModifiedBy
    private String modifierId;

}
