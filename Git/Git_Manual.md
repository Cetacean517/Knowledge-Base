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

参考方案： https://blog.csdn.net/qq_42592823/article/details/123913963
