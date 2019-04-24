"use strict";
use(function() {

    var styleString = '';
    var styles = [];

    var limit = properties.get('limit');
	var hashtag = properties.get('hashtag');


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
        limit:   		limit,
        hashtag: 		hashtag
    };
});
