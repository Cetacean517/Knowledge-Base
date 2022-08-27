# Elastic Search

https://www.knowledgedict.com/tutorial/elasticsearch-index-mapping.html

[painless](https://www.elastic.co/guide/en/elasticsearch/reference/master/modules-scripting-using.html)

[boolean query](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-bool-query.html)

[constant score](https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-constant-score-query.html)

[Script Score](https://www.elastic.co/guide/en/elasticsearch/reference/8.3/query-dsl-script-score-query.html#decay-functions-date-fields)

[Function Score](https://www.elastic.co/guide/en/elasticsearch/reference/8.3/query-dsl-function-score-query.html#score-functions)

#### 索引别名 [alias](https://www.knowledgedict.com/tutorial/elasticsearch-index-management.html)

- 用于平滑数据

#### 索引分析

- 文本分析成单词，标准化。
- 分析器
  - 字符过滤：取出html标记，转换 & 为 and
  - 分词器：根据"," 或者"  "将单词分块
  - 标记过滤器：大写 -- 小写，去掉连接词（a the and...)

#### 索引配置

#### 索引映射

定义一个文档，及其中字段如何被存储和索引。字段类型，字段权重，分词器...



##### 动态索引

- 自动匹配类型
- 可以设置类型判断，dynamic字段。

```json
PUT books 
GET books/_mapping
```

获取结果为空

```
{
  "books": {
    "mappings": {}
  }
}
```

写入文档

```
PUT books/_doc/1
{
  "id":1,
  "publish_date":"2019-11-10",
  "context":"<p>hello></p>",
  "name":"elasticsearch"
}
```

再次查看

```
{
  "books" : {
    "mappings" : {
      "properties" : {
        "context" : {
          "type" : "text",			// 类型
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        },
        "id" : {
          "type" : "long"			// 类型
        },
        "name" : {
          "type" : "text",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        },
        "publish_date" : {
          "type" : "date"
        }
      }
    }
  }
}

```

类型

**字符：**

- string：es 5.x 之后不支持

- text：被全文搜索。

  - 字段内容被分析，分解成term。不用于排序
  - 映射指定相关分析选项：index = analyzed ( 默认 ) / not_analyzed / no
    - analyzed：小写，字符串--- 单词，单词被完整匹配
    - not_analyzed：字段整体被搜索。
    - no 无需在该字段上搜索

- keyword：

  适用于：结构化字段。用于过滤。

mapping的字段

- norms：true/false。无需对某字段打分

#### 响应体字段含义

```json
{
  "took" : 10,					// 请求花费时间
  "timed_out" : false,			// 是否超时
  "_shards" : {					// 搜索分片信息
    "total" : 1,				// 分片总数
    "successful" : 1,			// 搜索成功
    "skipped" : 0,				// 没搜索的
    "failed" : 0				// 搜索失败
  },
  "hits" : {					// 搜索结果集
    "total" : {					// 返回总条数
      "value" : 1,
      "relation" : "eq"
    },
    "max_score" : 10.0,			// 返回结果集中，最大的匹配度分值
    "hits" : [					// 默认查询前十条，按分值降序
      {
        "_shard" : "[mock_data][0]",	// 分片
        "_node" : "U9ZUI9qIQE6mA9yVGUt-Cg",	// 结点名
        "_index" : "mock_data",			// 索引库名
        "_id" : "112",					// 数据id
        "_score" : 10.0,				// 数据分值
        "_ignored" : [
          "acceptance_criteria.keyword"
        ],
        "_source" : {					// 返回字段
          "number" : "SFSTRY0016905",
          "sys_updated_on" : "2022-03-31 02:21:01",
          "description" : "....",
          "acceptance_criteria" : "...",
          "task" : "...",
          "u_update_set" : "",
          "sys_id" : "6625cf901b843410e41ec9936b4bcb60"
        },
        "_explanation" : {
          "value" : 10.0,
          "description" : "script score function, computed with script:\"Script{type=inline, lang='painless', idOrCode='10', options={}, params={}}\"",
          "details" : [ ]
        }
      }
    ]
  }
}
```

