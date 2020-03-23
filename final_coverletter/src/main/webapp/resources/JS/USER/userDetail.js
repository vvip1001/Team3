
function add_div(id){
	/*var id = document.getElementById("default");
	console.log(id.id);
    var div = document.createElement('div');
    var filed = id.nextSibling.nextSibling;
    console.log(field.id);
    div.innerHTML = document.getElementById(id.id).innerHTML;

    document.getElementById(field.id).appendChild(div);
    */
	var field = document.getElementById(id);
	var parent = field.parentNode;
	var bro = parent.previousSibling.previousSibling;
	var bro2 = parent.previousSibling.previousSibling.previousSibling.previousSibling;

	var div = document.createElement('div');
	
	 div.innerHTML = document.getElementById(bro2.id).innerHTML;
	 document.getElementById(bro.id).appendChild(div);
}



function remove_div(obj){
	
	var object = obj;
	var object_p = object.parentNode;
	var p_bro = object_p.previousSibling.previousSibling;
	 
	var tag = document.getElementById( p_bro.id );
     tag.removeChild( tag.lastChild );
}
window.onload = function () {                

    var slider1 = new rSlider({
        target: '#slider1',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider1:" + vals);
        }
    });
    var slider1 = new rSlider({
        target: '#slider2',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider1:" + vals);
        }
    });
    var slider1 = new rSlider({
        target: '#slider3',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider1:" + vals);
        }
    });
    var slider1 = new rSlider({
        target: '#slider4',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider1:" + vals);
        }
    });
    var slider1 = new rSlider({
        target: '#slider5',
        values: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        range: false,
        set: [0],
        tooltip: false,
        onChange: function (vals) {
            console.log("slider1:" + vals);
        }
    });
    

};



