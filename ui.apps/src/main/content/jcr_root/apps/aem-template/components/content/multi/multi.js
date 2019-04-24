"use strict";
use(function() {

    var styleString = '';
    var styles = [];

    var sectionNumber = parseInt(properties.get('section'), 10);
    var sectionWidth = 12 / sectionNumber;

	var backgroundClass = properties.get('backgroundColorClass');

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
        sectionNumber:   sectionNumber,
        sectionWidth:    sectionWidth
    };
});
