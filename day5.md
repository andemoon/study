# day5学习笔记
---
### 今日总结：刚看vue看的网上的教程，结果整完后才发现是用官方的CLi去整框架的教程。。。。。最后还是老老实实地去看官方文档了。下午还整了一下日志，写了logback的配置文件，为什么要说这个日志呢，我觉得可能是因为我写完logback的配置文件后忘记写力扣的原因啊哈哈


---
### 目录
1. Vue2
2. logback日志框架
---

#### vue2
  yysy，vue语法蛮神奇的。
  记一下几个自己不太清楚的地方:
  
  1. 
  Computed 和 Watch 的区别

对于Computed：

它支持缓存，只有依赖的数据发生了变化，才会重新计算

不支持异步，当Computed中有异步操作时，无法监听数据的变化

computed的值会默认走缓存，计算属性是基于它们的响应式依赖进行缓存的，也就是基于data声明过，或者父组件传递过来的props中的数据进行计算的。

如果一个属性是由其他属性计算而来的，这个属性依赖其他的属性，一般会使用computed

如果computed属性的属性值是函数，那么默认使用get方法，函数的返回值就是属性的属性值；在computed中，属性有一个get方法和一个set方法，当数据发生变化时，会调用set方法。

对于Watch：

它不支持缓存，数据变化时，它就会触发相应的操作

支持异步监听

监听的函数接收两个参数，第一个参数是最新的值，第二个是变化之前的值

当一个属性发生变化时，就需要执行相应的操作

监听数据必须是data中声明的或者父组件传递过来的props中的数据，当发生变化时，会触发其他操作，函数有两个的参数：

2. 
v-if和v-show的区别

手段：v-if是动态的向DOM树内添加或者删除DOM元素；v-show是通过设置DOM元素的display样式属性控制显隐；

编译过程：v-if切换有一个局部编译/卸载的过程，切换过程中合适地销毁和重建内部的事件监听和子组件；v-show只是简单的基于css切换；

编译条件：v-if是惰性的，如果初始条件为假，则什么也不做；只有在条件第一次变为真时才开始局部编译; v-show是在任何条件下，无论首次条件是否为真，都被编译，然后被缓存，而且DOM元素保留；

性能消耗：v-if有更高的切换消耗；v-show有更高的初始渲染消耗；

使用场景：v-if适合运营条件不大可能改变；v-show适合频繁切换。

附上目标：
```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>test</title>
    <!--内部样式表-->
	<style type="text/css">
	.div1{
		margin:300px auto;
		width:300px;
		height: auto;
	}
	.button1{
        width: 50px;		
        height: 30px;
		opacity: 30;
		border: 3;
		margin-left: 20px;
	}
	.input1{
        width: 200px;
        height: 25px;
		box-shadow:0 0 8px #1c1b1d;
		border:2;
	}
	span{
		font-size: 50px;
	}
	.oi1{
		margin-top: 30px;
	}
	.complete{
		color: rgb(0, 0, 0);
	}
    .button2{
        width: 20px;
        height:20px ;
        color: #1c1b1d;
    }
    .button3{
        width:50px;
        height: 50px;
        position: fixed;
    }
	</style>
</head>
<body>

	<div id="list" class="div1">
	<span>TodolistDemo</span>
        <!--添加文本域，-->
        
		<input class="input1" type="text" v-model="inputVaule" v-on:keyup.enter="add"/>
        <!--添加按钮-->
        <button v-on:click="add" class="button1">添加</button>
        <!--删除全部按钮-->
        <button v-on:click="removeallTodo" class="button3">删除全部</button>
        <!--添加列表-->
		<ol >
			<li v-for="item in items" >
			<div class="ol1">
                <!--内容在这-->
				<label  v-bind:class="{ complete:item.completed }">{{item.text}}</label>
                <!--删除按钮-->
				<button v-on:click="removeTodo(item)" class="button2">x</button></li>
			</div>
		</ol>
        
	</div>
	
	<script src="./vue.js"></script>
	<script src="vue-resource.js"></script>
    <!--逻辑语块在这-->
	<script src="vuetest.js"></script>

</body>
</html>
```
```js
//localStroage保存数据，这一块js参考了网上的
var STORAGE_KEY = 'todos-vuejs'//名称
var todoStorage = {
  fetch: function () {
    var todos = JSON.parse(localStorage.getItem(STORAGE_KEY) || '[]')
    todos.forEach(function (todo, index) {
      todo.id = index
    })
    todoStorage.uid = todos.length
    return todos
  },
  save: function (todos) {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(todos))
  }
}		

//这一块自己写的添加，删除和删除全部的功能
var vm=new Vue({
  el: '#list',
  data: {
  	items:todoStorage.fetch(),//直接从localstroage拿数据
  	inputVaule:""
  },
  mounted:function(){

  },
  methods:{
  	add:function(){//添加
  		var _this=this;
  		this.items.push({text:this.inputVaule,completed:true});
  		this.inputVaule="";
  	},
    removeTodo: function (todo) {//删除
      this.items.splice(this.items.indexOf(todo), 1)
    },
    removeallTodo: function (todo) {//删除全部
        this.items.splice(this.items)
      }
  },

  watch:{
  	items:{
  		handler:function(items){
  			todoStorage.save(items)
  		},
  		deep:true
  	}
  }
})
```
---

####logback日志框架

日志框架没啥好说的，原本想看log4j来着，然后想起来之前mc的服务器被黑就是因为log4j有bug的原因，就看了logback，耗时间也就是整配置文件上了(就是因为这个我才忘记写力扣了emmm)。
```xml
<?xml version="1.0" encoding="utf-8" ?>
<!-- 从高到地低 OFF 、 FATAL 、 ERROR 、 WARN 、 INFO 、 DEBUG 、 TRACE 、 ALL -->
<!-- 日志输出规则  根据当前ROOT 级别，日志输出时，级别高于root默认的级别时  会输出 -->
<!-- 以下  每个配置的 filter 是过滤掉输出文件里面，会出现高级别文件，依然出现低级别的日志信息，通过filter 过滤只记录本级别的日志-->

<!-- 属性描述 scan：性设置为true时，配置文件如果发生改变，将会被重新加载，默认值为true scanPeriod:设置监测配置文件是否有修改的时间间隔，如果没有给出时间单位，
默认单位是毫秒。当scan为true时，此属性生效。默认的时间间隔为1分钟。debug:当此属性设置为true时，将打印出logback内部日志信息，实时查看logback运行状态。默认值为false。 -->
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <!-- 定义日志文件 输入位置 -->
    <property name="logPath" value="E:/学习/java/Test/log/test_log" />
    <!-- 日志最大的历史 30天 -->
    <property name="maxHistory" value="30"/>

    <!-- 配置项， 通过此节点配置日志输出位置（控制台、文件、数据库）、输出格式等-->

    <!-- ConsoleAppender代表输出到控制台 -->
    <appender name="consoleLog" class="ch.qos.logback.core.ConsoleAppender">
        <target>System.out</target>
        <!-- layout代表输出格式 -->
        <layout class="ch.qos.logback.classic.PatternLayout">

            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%-5level] %c [%thread] : -%msg%n</pattern>
        </layout>
    </appender>

    <!-- 日志输出文件 -->
    <appender name="fileInfoLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%-5level] %c [%thread] : -%msg%n</pattern>
        </encoder>
        <!-- 滚动记录文件，先将日志记录到指定文件，当符合某个条件时，将日志记录到其他文件 RollingFileAppender-->
        <!-- 滚动策略，它根据时间来制定滚动策略.既负责滚动也负责触发滚动 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- 输出路径 -->
            <file>${logPath}/all/%d.log</file>
            <fileNamePattern>${logPath}/data-%d{yyyy-MM-dd}/%d.log</fileNamePattern>
            <!-- 可选节点，控制保留的归档文件的最大数量，超出数量就删除旧文件假设设置每个月滚动，且<maxHistory>是6，
            则只保存最近6个月的文件，删除之前的旧文件。注意，删除旧文件是，那些为了归档而创建的目录也会被删除-->
            <maxHistory>${maxHistory}</maxHistory>
            <maxFileSize>5MB</maxFileSize>
        </rollingPolicy>
        <!-- 按照固定窗口模式生成日志文件，当文件大于20MB时，生成新的日志文件。窗口大小是1到3，当保存了3个归档文件后，将覆盖最早的日志。
        <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
          <fileNamePattern>${logPath}/%d{yyyy-MM-dd}/.log.zip</fileNamePattern>
          <minIndex>1</minIndex>
          <maxIndex>3</maxIndex>
        </rollingPolicy>   -->
        <!-- 查看当前活动文件的大小，如果超过指定大小会告知RollingFileAppender 触发当前活动文件滚动
        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <maxFileSize>5MB</maxFileSize>
        </triggeringPolicy>   -->
    </appender>
    <!-- 特殊记录Error日志 -->
    <appender name="fileErrorLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 只记录ERROR级别日志，添加范围过滤，可以将该类型的日志特殊记录到某个位置 -->
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>ERROR</level>
        </filter>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%-5level] %c [%thread] : -%msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${logPath}/error/%d.log</fileNamePattern>
            <!-- 日志最大的历史 60天 -->
            <maxHistory>60</maxHistory>
        </rollingPolicy>
    </appender>

    <!-- 根节点，表名基本的日志级别，里面可以由多个appender规则 -->
    <!-- level="info"代表基础日志级别为info -->
    <root level="ALL">
        <!-- 引入控制台输出规则,如果不关联日志，则不会打印 -->
      <!--  <appender-ref ref="consoleLog" />打印在控制台 -->
        <appender-ref ref="fileInfoLog" />
        <appender-ref ref="fileErrorLog" />
    </root>
</configuration>
```
