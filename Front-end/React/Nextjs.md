# Next.js

Create a Next.js App: https://nextjs.org/learn/basics/create-nextjs-app/setup



## 1. 创建项目

#### 1.1 安装

- Node.js 10.13  ([安装连接](https://nodejs.org/en/))

- [Git](https://gitforwindows.org/) bash / [WSL](https://docs.microsoft.com/en-us/windows/wsl/install-win10)



#### 1.2 创建 Next.js 项目

```]
npx create-next-app@latest nextjs-blog --use-npm --example "https://github.com/vercel/next-learn/tree/master/basics/learn-starter"
```

`create-next-app` 工具 ：调用Next.js 项目模板

`--example` ：设置模板



#### 1.3 运行开发服务器

进入`nextjs-blog`

```cmd
cd nextjs-blog
```

运行指令

```cmd
npm run dev
```

运行项目，并把服务放在了3000端口上。

打开 http://localhost:3000/ 查看服务。



#### 1.4 修改页面

- 确保Next.js服务器在运行。
- 在编辑器中打开`pages/index.js`。
- 把**“Welcome to”** 改成 **"Learn"**
- 保存文件。



## 2. 页面间导航

在Next.js中，每个页面是一个从`pages`文件夹导出的React组件。页面都是基于他们的文件名被练习成路径。



#### 2.1 创建一个新页面

- 在`pages`文件夹下创建`posts` 文件夹

- 在`posts`中创建`first-post.js`，包含以下内容。

  ```js
  export default function FirstPost() {
    return <h1>First Post</h1>;
  }
  ```

- 保存后，可以在`localhost:3000/posts/first-post` 路径下显示改页面。

#### 2.2 Link组件

在网页中，可以使用`<a>` 标签进行导航。而在Next.js中，`<link>`组件允许你进行客户端的导航，并且接受参数传递。

**使用<Link\>** 

- 打开 `pages/index.js`，引入组件

  ```js
  import Link from 'next/link';
  ```

- 修改h1标签中的内容。

  ```html
  <h1 className="title">
    Read <Link href="/posts/first-post">this page!</Link>
  </h1>
  ```

- 打开`pages/posts/first-post.js` ，并且替换成以下内容。

  ```js
  import Link from 'next/link';
  
  export default function FirstPost() {
    return (
      <>
        <h1>First Post</h1>
        <h2>
          <Link href="/">Back to home</Link>
        </h2>
      </>
    );
  }
  ```



## 3. Assets(资源)，Metadata（元数据）和CSS

## 4. 预渲染 和 数据获取

#### Pre-rendering vs No Pre-rendering

<img src="https://nextjs.org/static/images/learn/data-fetching/pre-rendering.png" alt="img" style="zoom:33%;" />

<img src="https://nextjs.org/static/images/learn/data-fetching/no-pre-rendering.png" alt="img" style="zoom:33%;" />

预渲染：先渲染HTML，再导入JS， 如果JS不能使用，依旧可以展示静态页面。

无预渲染：一起导入，如果JS不能使用，那么就不能展示静态页面。

#### 两种预渲染类型

- [**Static Generation**](https://nextjs.org/docs/basic-features/pages#static-generation-recommended) is the pre-rendering method that generates the HTML at **build time**. The pre-rendered HTML is then *reused* on each request.
- [**Server-side Rendering**](https://nextjs.org/docs/basic-features/pages#server-side-rendering) is the pre-rendering method that generates the HTML on **each request**.

<img src="https://nextjs.org/static/images/learn/data-fetching/static-generation.png" alt="img" style="zoom:33%;" />

<img src="https://nextjs.org/static/images/learn/data-fetching/server-side-rendering.png" alt="img" style="zoom:33%;" />

#### 创建一个简易的博客构架

