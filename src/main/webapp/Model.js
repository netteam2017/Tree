var Model = function (){

}
Model.prototype = {
    set data (data){

        this._data = data;

        var i = 0;
        var h=0;
        var n=0;
        this._map = new Map();
        this._children = new Map();
        while (i < this.data.tasks.entry.length){
            var str = JSON.stringify(this.data.tasks.entry[i].key.task.id);
            this.map.set(str,this.data.tasks.entry[i].key);
            this.children.set(str,this.data.tasks.entry[i].value);
            i++;
        }
        this.listener();
    },
    get data () {return this._data;},
    set listener(listener){this._listener = listener;},
    get listener () {return this._listener;},
    set map (map) {this._map = map;},
    set children (children) {this._children = children;},
    get map () {return this._map;},
    get children () {return this._children;}
}
Model.prototype.show = function(){
    console.log(this.data);
    console.log(this.listener);
}

Model.prototype.toString = function(){
    return this.data;

}
Model.prototype.addMap = function(i,Id){
    this._map[i] = Id;
}

Model.prototype.getElementById = function(key){
    //key = '{"height":1,"number":1}';
    var task = {};
    if (this.map.has(key)){
        task = this.map.get(key);
    }
    return task;
}

Model.prototype.getChildren = function(key){
    var tasks = null;
    if (this.children.has(key)){
        tasks = this.children.get(key);
        }
        return tasks;
}

Model.prototype.deleteElement = function(key){
    if (this.map.has(key)){
        data = this.data;
        var i = 0;
        while(i<data.tasks.entry.length){
            if(JSON.stringify(data.tasks.entry[i].key.task.id)===(key)){
                var k = i;
                data.subTasks.entry.splice(k,1);
                this.map.delete(key);
                console.log(this.map);
            }
            i++;
        }
        this.data = data;
    }
}

Model.prototype.getHead = function(){
    return(model.getElementById('{"height":1,"number":1}'));
}

Model.prototype.showMap = function(){
    console.log('map', this.map);
}

Model.prototype.showChildren = function() {
    console.log('children', this.children);
}

Model.prototype.getTreeChildren = function(id){

    var childrenResult = this.getChildren(id);
    if (childrenResult!=null&&childrenResult!=""){
    var str = "[";
    var children = jQuery.makeArray(JSON.parse(childrenResult));
    var i = 0;
    while (i<children.length){
        var elem = this.getElementById(JSON.stringify(children[i].task.id));
        if(this.getChildren(JSON.stringify(children[i].task.id))!=""){

            var child = [{"name":  elem.task.name
                            ,"parent":  this.getElementById(id).task.name,
                            "children": this.getTreeChildren(JSON.stringify(elem.task.id))
                            }];
                            //console.log('tytyt',JSON.stringify(child));
                            str = str + JSON.stringify(child);
        }else{
            var child = [{"name":  elem.task.name
                         ,"parent":  this.getElementById(id).task.name
                         }];
                          str = str + JSON.stringify(child);
        }
        i++;
    }
    }
    return str + "]";
}