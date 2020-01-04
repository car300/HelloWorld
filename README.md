# HelloWorld
A demo for private maven repository

## 登录到管理后台
   * web访问http://192.168.1.107:8081
   * 登陆 
    ```
     developer che300
    ```

## 提交到仓库
* 将helloworld/gradle-mvn-push*.gradle拷贝到目标module
* 在gradle.properties内配置
    ```
    # 服务器配置
    NEXUS_USERNAME=developer
    NEXUS_PASSWORD=che300
    # 正式仓库地址
    RELEASE_REPOSITORY_URL=http://192.168.1.107:8081/repository/maven-releases/
    # SNAPSHOT仓库,发布SNAPSHOT版本需要声明版本为(版本号-SNAPSHOT)
    SNAPSHOT_REPOSITORY_URL=http://192.168.1.107:8081/repository/maven-snapshots/
    
    # 项目配置
    POM_NAME=helloworld
    POM_ARTIFACT_ID=helloworld
    POM_PACKAGING=aar
    # SNAPSHOT版本
    VERSION_NAME=1.0.0-SNAPSHOT
    # 简版上传可以不配置
    VERSION_CODE=1
    GROUP=com.car300.helloworld
    
    POM_DESCRIPTION=这是上传的第一个私有仓库
    POM_URL=https://github.com/car300/HelloWorld
    
    # 以下配置使用简版上传可以不配置
    POM_SCM_URL=https://github.com/car300/HelloWorld
    POM_SCM_CONNECTION=scm:git@github.com/car300/HelloWorld.git
    POM_SCM_DEV_CONNECTION=scm:git@github.com/car300/HelloWorld.git
    
    POM_LICENCE_NAME=The Apache Software License, Version 2.0
    POM_LICENCE_URL=http://www.apache.org/licenses/LICENSE-2.0.txt
    POM_LICENCE_DIST=repo
    
    POM_DEVELOPER_ID=dede
    POM_DEVELOPER_NAME=hsh
    ```
* 上传
    ```
    Windows gradlew.bat uploadArchives
    macOS or Linux ./gradlew uploadArchives
    ```
    
### 各仓库区别

| name  |     |      |
|   ---    |   ---  |    ---    |
| maven-releases  | 不允许上传相同版本 | 不允许上传相同版本   |
| maven-snapshots  | 允许上传相同版本 | 允许上传相同版本    |
| maven-public  | 代理仓库组(多个代理仓库集合) | 不可上传    |
| ~~hello-world~~  | ~~测试仓库~~ |  ~~允许上传相同版本~~   |
