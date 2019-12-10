spring-framework-5.0.10.RELEASE  
使用的gradle版本: 4.10.3  

A：注释掉spring-beans.gradle中的两行依赖  
```
compileGroovy.dependsOn = compileGroovy.taskDependencies.values - "compileJava"
compileKotlin.dependsOn(compileGroovy)
```

B: 注释掉settings.gradle中的spring-aspects
```
//include "spring-aspects"
```

C: 如果报错为：The provided plugin org.jetbrains.kotlin.scripting.compiler.plugin.
         ScriptingCompilerConfigurationComponentRegistrar is not compatible with this version of compiler  
   请更新kotlin插件为最新版本
   
D：报错：找不到InstrumentationSavingAgent  

  	1.首先找到报错的模块。我这里是：spring-context
 
  	2.找到报错模块的gradle文件。我这里是：spring-context.gradle
  
  	3.找到引入InstrumentationSavingAgent所在模块的地方。
  	在这里做修改，把optional(project(":spring-instrument"))改为
  	compile(project(":spring-instrument"))
  	
  	4.再重新build，成功。
  	
  	
这个时候就可以愉快地写测试项目了。。。。。。
