"use strict";
use(function() {

    var componentsList = [];
    var compArray = properties.get("component");
    var sizeArray = properties.get("size");
    var positionArray = properties.get("position");


    if(compArray != null){
        console.log("test");
        var index = 0;
        for(var i = 0; i < compArray.length; i++) {
        	var singleObj = {};
        	for (var a = 0; a < positionArray[i] - index; a++) {
            	var itemObj = {};
            	itemObj['component'] = "product";
				componentsList.push(itemObj);
        	}
        	index = positionArray[i] + sizeArray[i];
        	singleObj['component'] = compArray[i];
        	singleObj['size'] = sizeArray[i];
        	singleObj['position'] = positionArray[i];
        	componentsList.push(singleObj);
    	};
        for (var a = index; a < 20; a++) {
            var itemObj = {};
            	itemObj['component'] = "product";
				componentsList.push(itemObj);
        }

   	} else {
        for (var a = 0; a < 20; a++) {
            var itemObj = {};
            	itemObj['component'] = "product";
				componentsList.push(itemObj);
        }
    }


   	return {
        componentsList: componentsList
    };
});
