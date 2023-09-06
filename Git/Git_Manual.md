# Git Notebook

## 1. GitHub仓库clone 到本地

​		任意文件夹下，打开terminal `git clone + 仓库地址`（https那个即可）

## 2. 本地文件连接github仓库

[Git的使用--如何将本地项目上传到Github（三种简单、方便的方法）（二）（详解） - 腾讯云开发者社区-腾讯云 (tencent.com)](https://cloud.tencent.com/developer/article/1504684)

1. 初始化本地仓库

   进入本地文件（放置代码的目录），`git init` 初始化本地仓库。

2. 添加远程连接：`git remote add origin https://github.com/hongduhong/test.git` 后面为github仓库地址。

## 3. 连接多个远程仓库

1. 添加多个远程仓库        `git remote add (远程仓库名称) (远程仓库地址)`

   **注意： 添加的地址前不要加`git@`** 

   ```git
   // 例子
   git remote add gitee https://gitee.com/cetacean517/Knowledge-Base.git
   git remote add gitee https://github.com/Cetacean517/Knowledge-Base.git
   ```

2. 拉去远程仓库的分支      `git fetch (远程仓库名字)` 

   ```git
   git fetch gitee     // 这里 gitee 是远程仓库名字
   ```

3. 检查是否添加成功

   查看 连接远程仓库的具体信息    `git remote -v`

   ![image-20220827162108607](Notepic/image-20220827162108607.png)

​		查看是否能够成功推送到新仓库     `git push gitee (远程仓库名字) main`

​      <img src="Notepic/image-20220827162209566.png" alt="image-20220827162209566" style="zoom:70%;" /> 



## 4. Error 解决方法

### a. OpenSSL SSL_read: Connection was reset, errno 10054

**Solution1**

- `git config --global http.sslVerify false`

**Solution2**

> ##### Error Notes
>
> - remote: Support for password authentication was removed on August 13, 2021.
>
> - remote: Please see https://docs.github.com/en/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.

1. 在GitHub上申请token
2. `git remote set-url origin https://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@github.com/Cetacean517/FacePreprocessMTCNN.git`
3. `git push -u origin main`

https://blog.csdn.net/qq_42592823/article/details/123913963

**Solution3**

```cmd
git config --global http.proxy http://127.0.0.1:1080
git config --global --unset http.proxy
git push -u origin main
```

https://blog.csdn.net/Hodors/article/details/103226958

## 5. 配置Github链接方式

#### 在管理Git项目上，有两种克隆到本地的方法。

- 直接使用https url克隆到本地
- 使用SSH url克隆到本地

**这两种方式的主要区别在于**：

使用https url对初学者来说会比较方便，复制https url然后到git Bash里面直接用clone命令克隆到本地就好了，但是每次fetch和push代码都需要输入账号和密码，这也是https方式的麻烦之处。
 使用SSH url需要在只用之前先配置和添加好SSH key。每次fetch和push代码都不需要输入账号和密码，如果你想要每次都输入账号密码才能进行fetch和push也可以另外进行设置。

链接：https://www.jianshu.com/p/6d8afc2315bc

## 6. 修改本地仓库（Git 仓库）的名字

你可以执行以下步骤：

1. 打开命令行终端（Command Prompt、Git Bash 等）。

2. 使用 `cd` 命令导航到你的本地仓库所在的目录。

3. 通过以下命令查看当前的远程仓库地址：

   ```
   git remote -v
   ```

   

   这将显示当前仓库的远程 URL，类似于：

   ```
   origin  https://github.com/your-username/your-repository.git (fetch)
   origin  https://github.com/your-username/your-repository.git (push)
   ```

   

4. 如果你只想修改本地仓库的名字，而不影响远程仓库，请执行以下命令：

   ```
   git branch -m new-local-repository-name
   ```

   

   替换

    

   ```
   new-local-repository-name
   ```

    

   为你想要为本地仓库设置的新名字。

5. 如果你还想同步更新远程仓库的名字，请执行以下命令：

   ```
   git remote rename origin new-remote-repository-name
   ```

   

   替换

    

   ```
   new-remote-repository-name
   ```

    

   为你想要为远程仓库设置的新名字。

6. 使用以下命令验证是否成功修改了本地仓库的名字：

   ```
   git remote -v
   ```

   

   这次应该显示更新后的仓库 URL：

   ```
   new-remote-repository-name  https://github.com/your-username/your-repository.git (fetch)
   new-remote-repository-name  https://github.com/your-username/your-repository.git (push)
   ```

   

请确保小心操作，并在执行任何更改之前备份重要的仓库数据。

# 常用

git 
