"use strict";
use(function() {

    var styleString = '';
    var styles = [];

    var backgroundType = properties.get('background');
    var title = properties.get('title');
    var placeholder = properties.get('placeholder');
    var backgroundClass = properties.get('backgroundColorClass');
    var mainClass = properties.get('mainColorClass');

    var backgroundImage = properties.get('fileReference');

    // Apply text color override to all component variants
    if(mainClass == 'bw-custom') {
        styles.push('color: ' + properties.get('mainColor', '#777777'));
    }

    if(backgroundType == 'color') {
        if(backgroundClass!=null ){
            if(backgroundClass.length == 1){
				if(backgroundClass[0] == 'bw-custom') {
            		styles.push('background-color: ' + properties.get('backgroundColor', '#777777'));
               }
            }
			else if(backgroundClass == 'bw-custom') {
            styles.push('background-color: ' + properties.get('backgroundColor', '#777777'));
            }
        }

    }
    else if(backgroundType == 'image') {
        styles.push('background-position: ' + properties.get('backgroundPosition'));
        styles.push('background-image: url(' + backgroundImage + ')');
        styles.push('background-size: ' + properties.get('backgroundSize'));
    }
    else {
        console.log("Unknown background type for Content Container component");
    }

    var paddings = [];
    paddings.push(properties.get('paddingTop', 'auto'));
    paddings.push(properties.get('paddingRight', 'auto'));
    paddings.push(properties.get('paddingBottom', 'auto'));
    paddings.push(properties.get('paddingLeft', 'auto'));

    var padding = paddings.reduce(function(acc, val) {
        return acc + val + ' ';
    }, 'padding: ');

    styles.push(padding);
    styleString = styles.join('; ');

    return {
        styles:          styleString,
        title:			 title,
        placeholder:	 placeholder
    }
});
