//localStroage保存数据，这一块js参考了网上的，因为js才开始看emm
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
