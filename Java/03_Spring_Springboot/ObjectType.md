# 区分各类Object

## I. 概念定义

>  PO、BO、DTO、VO、DAO

#### 1. PO = Persistant Object 持久对象

数据表字段 + getter + setter

| TYPE       | id   | name | age  | sex  | birthday |
| ---------- | ---- | ---- | ---- | ---- | -------- |
| 个人信息表 | √    | √    | √    | √    | √        |
| PO         | √    | √    | √    | √    | √        |

#### 2. BO = Business Object 业务对象

在PO基础上扩充，多个PO根据业务流程凑成BO。

| TYPE       | id   | name | age  | sex  | birthday | school | educational_background |
| ---------- | ---- | ---- | ---- | ---- | -------- | ------ | ---------------------- |
| 个人信息表 | √    | √    | √    | √    | √        |        |                        |
| 个人学历表 | √    |      |      |      |          | √      | √                      |
| BO         | √    | √    | √    | √    | √        | √      | √                      |

> 合并了两个字段。

#### 3. DTO = Data Transfer Object 数据传输对象

对于已有数据，删除部分字段。

| TYPE       | id   | name | age  | sex  | birthday |
| ---------- | ---- | ---- | ---- | ---- | -------- |
| 个人信息表 | √    | √    | √    | √    | √        |
| PO         | √    | √    | √    | √    |          |

> 去除了 birthday 字段。

#### 4. VO = Value Object 值对象

展示使用的数据，可能需要合并字段，展示为易于理解含义。

| TYPE       | id   | name | age  | sex  | birthday | type          |
| ---------- | ---- | ---- | ---- | ---- | -------- | ------------- |
| 个人信息表 | √    | √    | √    | √    | √        |               |
| VO         | √    | √    |      |      | √        | √ = age + sex |

#### 5. DAO = Data Access Object 数据访问对象

存储访问数据库完成数据处理操作的方法的对象。



## II. 对象间关系

1. DAO -- PO ---`业务对象`--- BO ---`数据过滤删减`--- DTO ---`处理`--- VO  

> 该流程也可能会被删减。