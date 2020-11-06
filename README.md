# HelloWorld
A demo for private maven repository

## 登录到管理后台
   * web访问http://172.16.0.236:8081
   * 登录
    ```
     developer che300
    ```

## 提交到仓库
* 在module的build.gradle内添加:
    ```gradle
    apply from: 'https://raw.githubusercontent.com/car300/HelloWorld/master/script/publish-maven-simple.gradle'
    // apply from: 'https://raw.githubusercontent.com/car300/HelloWorld/master/script/publish-maven.gradle'
    ```
* 或者将script/publish-maven*.gradle拷贝到目标module

* 在module/gradle.properties内配置, 没有可以新建文件
    ```
    # 服务器配置
    NEXUS_USERNAME=developer
    NEXUS_PASSWORD=che300
    # 如果没有修改可以不配置
    #RELEASE_REPOSITORY_URL=http://172.16.0.236:8081/repository/maven-releases/
    #SNAPSHOT_REPOSITORY_URL=http://172.16.0.236:8081/repository/maven-snapshots/

    # 项目配置
    GROUP_ID=com.che300.helloworld
    POM_NAME=helloworld
    POM_ARTIFACT_ID=helloworld
    POM_PACKAGING=aar
    VERSION_NAME=1.0.0-SNAPSHOT
    # release版本
    #VERSION_NAME=1.0.0
    POM_DESCRIPTION=这是上传的第一个私有仓库
    POM_URL=https://github.com/car300/HelloWorld

    # 使用simple脚本时可以不配置
    POM_SCM_URL=https://github.com/car300/HelloWorld
    POM_SCM_CONNECTION=scm:git@github.com/car300/HelloWorld.git
    POM_SCM_DEV_CONNECTION=scm:git@github.com/car300/HelloWorld.git

    POM_LICENCE_NAME=The Apache Software License, Version 2.0
    POM_LICENCE_URL=http://www.apache.org/licenses/LICENSE-2.0.txt
    POM_LICENCE_DIST=repo

    POM_DEVELOPER_ID=hsh
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
